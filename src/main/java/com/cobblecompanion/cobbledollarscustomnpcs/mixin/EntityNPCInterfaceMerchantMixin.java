package com.cobblecompanion.cobbledollarscustomnpcs.mixin;

import com.cobblecompanion.cobbledollarscustomnpcs.data.CustomNpcMerchantShopManager;
import fr.harmex.cobbledollars.common.utils.extensions.PlayerExtensionKt;
import fr.harmex.cobbledollars.common.world.item.trading.CobbleDollarsShopHolder;
import fr.harmex.cobbledollars.common.world.item.trading.shop.Shop;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import noppes.npcs.entity.EntityNPCInterface;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Nutzer-Vorgabe: ein CustomNPC soll wahlweise die Funktion/das Kauf-GUI eines echten
 * CobbleMerchant bekommen, sein CustomNPCs-Aussehen aber behalten. Macht EntityNPCInterface per
 * Mixin direkt zu einem CobbleDollarsShopHolder (die 3 Getter/Setter-Paare, die das Interface
 * verlangt) - dadurch kann PlayerExtensionKt.openShop() (dieselbe Methode, die ein echter
 * CobbleMerchant in seinem eigenen mobInteract() aufruft, siehe javap-Analyse) den NPC 1:1 wie
 * einen echten Merchant behandeln, INKLUSIVE der eingebauten Angebots-Bearbeitung - kein eigenes
 * Options-Fenster nötig.
 *
 * Injiziert NICHT an HEAD von mobInteract(), sondern erst am Aufruf von RoleInterface.getType()
 * (per javap verifiziert: der einzige Aufruf dieser Methode in mobInteract(), unmittelbar vor
 * "if (role.getType()==0) role.interact(player) else say(...)") - an diesem Punkt hat CustomNPCs
 * bereits alle eigenen Vorrang-Prüfungen durchlaufen (Werkzeug in der Hand: Klon-/Wand-/Reit-/
 * Scripter-Tool -> eigener Editor bleibt UNANGETASTET, da dessen Rückgabe VOR diesem Punkt erfolgt;
 * außerdem Fraktion/Angriff/aktiver Dialog/Quest).
 *
 * Nutzer-Korrektur: bei Verkaufsmenü ORIGINAL NICHT canceln - solange man dem NPC keine eigene
 * GUI-Rolle (Trader o.ä.) gibt, hat er beim normalen Anklicken ohnehin kein konkurrierendes GUI, nur
 * den eingestellten Interaktionstext (DataAdvanced.getInteractLine(), "say()" im else-Zweig). Ein
 * cancel() hätte genau diesen Text unterdrückt - der Shop öffnet sich in diesem Fall als reiner
 * Zusatz-Effekt NEBEN dem normalen CustomNPCs-Verhalten, nicht als dessen Ersatz.
 *
 * Bei jedem ANDEREN Verkaufsmenü (Lagerhalter/Creative-Menü) dagegen WIRD gecancelt (siehe
 * cobblecompanion$openMerchantShop) - dort hat AlternateSellMenuOpener bereits ein eigenes Menü
 * geöffnet, jeder native role.interact()-Dispatch (RoleTrader-GUI, Dialog-Text) muss dann
 * unterbleiben, sonst konkurrieren zwei openMenu()-Aufrufe im selben Klick um dasselbe Fenster.
 */
@Mixin(EntityNPCInterface.class)
public abstract class EntityNPCInterfaceMerchantMixin implements CobbleDollarsShopHolder {

    @Unique
    private Shop cobblecompanion$shop;
    @Unique
    private UUID cobblecompanion$merchantUuid;
    @Unique
    private final Set<Player> cobblecompanion$tradingPlayers = new HashSet<>();

    @Override
    public Shop getShop() {
        EntityNPCInterface self = (EntityNPCInterface) (Object) this;
        if (cobblecompanion$shop == null) {
            cobblecompanion$shop = CustomNpcMerchantShopManager.getShop(self.getUUID(), self.registryAccess());
        }
        return cobblecompanion$shop;
    }

    @Override
    public void setShop(Shop shop) {
        EntityNPCInterface self = (EntityNPCInterface) (Object) this;
        cobblecompanion$shop = shop;
        CustomNpcMerchantShopManager.setShop(self.getUUID(), shop, self.registryAccess());
    }

    @Override
    public UUID getMerchantUUID() {
        if (cobblecompanion$merchantUuid == null) {
            cobblecompanion$merchantUuid = ((EntityNPCInterface) (Object) this).getUUID();
        }
        return cobblecompanion$merchantUuid;
    }

    @Override
    public void setMerchantUUID(UUID uuid) {
        cobblecompanion$merchantUuid = uuid;
    }

    @Override
    public Set<Player> getTradingPlayers() {
        return cobblecompanion$tradingPlayers;
    }

    @Override
    public void setTradingPlayers(Set<Player> players) {
        cobblecompanion$tradingPlayers.clear();
        cobblecompanion$tradingPlayers.addAll(players);
    }

    @Inject(
        method = "mobInteract",
        at = @At(value = "INVOKE", target = "Lnoppes/npcs/roles/RoleInterface;getType()I"),
        cancellable = true)
    private void cobblecompanion$openMerchantShop(Player player, net.minecraft.world.InteractionHand hand, CallbackInfoReturnable<InteractionResult> cir) {
        EntityNPCInterface self = (EntityNPCInterface) (Object) this;
        if (!(player instanceof ServerPlayer serverPlayer)) return;

        // Nutzer-Fund (Live-Bug 57, tatsächliche Ursache nach Fehldiagnosen chunk-loading/Distanz
        // gefunden): bei Verkaufsmenü "Lagerhalter"/"Creative-Menü" öffnet
        // CustomNpcTraderLinkInteractionHandler bereits das passende alternative Menü (siehe
        // AlternateSellMenuOpener) und canceled dafür das auslösende PlayerInteractEvent - dieser
        // Injektionspunkt liegt aber INNERHALB von mobInteract() (CustomNPCs eigenem
        // Interaktions-Dispatch, läuft über einen eigenen Netzwerk-Pfad statt vanilla
        // Player.interactOn()) und wird von dieser Cancel-Markierung NICHT übersprungen - der
        // anschließende role.interact()-Aufruf (z.B. RoleTrader.interact(), öffnet CustomNPCs
        // EIGENES natives Handels-GUI) lief deshalb bisher IMMER zusätzlich, unabhängig vom
        // eingestellten Verkaufsmenü. Zwei server-seitige openMenu()-Aufrufe im selben Klick
        // konkurrieren um dasselbe Spieler-Fenster - je nach Zeitpunkt/Netzwerk-Reihenfolge sah man
        // das gerade erst geöffnete Lagerhalter-/Creative-Menü kurz aufblitzen (eigener Aufruf zuerst)
        // oder gar nicht (CustomNPCs' eigenes Menü gewann das Rennen) - exakt das gemeldete "mal <1
        // Sekunde sichtbar, mal gar nicht". Muss deshalb VOR jedem role-spezifischen Dispatch greifen,
        // nicht nur vor dem CobbleMerchant-Emulations-Pfad (isEnabled-Zweig unten).
        if (com.cobblecompanion.data.MerchantSettingsManager.getSellMenu(self.getUUID())
                != com.cobblecompanion.data.MerchantSettingsManager.SellMenu.ORIGINAL) {
            cir.setReturnValue(InteractionResult.SUCCESS);
            cir.cancel();
            return;
        }

        if (!CustomNpcMerchantShopManager.isEnabled(self.getUUID())) return;

        PlayerExtensionKt.openShop(serverPlayer, this);
        cobblecompanion$tradingPlayers.add(player);
    }
}
