package com.cobblecompanion.cobbledollarscustomnpcs;

import com.cobblecompanion.cobbledollarscreate.CobbleMerchantLinkInteractionHandler;
import com.cobblecompanion.cobbledollarscustomnpcs.data.CustomNpcMerchantShopManager;
import com.cobblecompanion.data.AdminPermissionManager;
import com.cobblecompanion.data.CustomNpcTraderLinkManager;
import com.cobblecompanion.integrations.ModAvailability;
import com.cobblecompanion.integrations.create.CreateStockTickerBridge;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.AttackEntityEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.items.IItemHandler;
import noppes.npcs.entity.EntityNPCInterface;
import noppes.npcs.roles.RoleTrader;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Verknüpft einen CustomNPCs-Trader-NPC mit einem Lagerticker (Pflicht - ohne diese Verknüpfung
 * kann der NPC nichts mehr verkaufen, siehe mixin.create.ContainerNPCTraderMixin), optional einem
 * Zielinventar für Bezahl-Items, und optional einer Kreativen Kiste. Nutzer-Vorgabe (Update):
 * dieselbe Holzhacke+AdminOp-Steuerung wie bei CobbleMerchant (siehe
 * CobbleMerchantLinkInteractionHandler.isHoldingAdminTool - dort liegt die geteilte Prüfung, da
 * dieses Modul ohnehin schon von CobbleDollars/Create abhängt).
 */
public class CustomNpcTraderLinkInteractionHandler {

    private final Map<UUID, UUID> pendingLinkByAdmin = new HashMap<>();

    // HIGHEST + receiveCanceled: läuft garantiert vor allen anderen Listenern auf demselben Event,
    // robuster gegen Registrierungsreihenfolge.
    @SubscribeEvent(priority = EventPriority.HIGHEST, receiveCanceled = true)
    public void onAttackEntity(AttackEntityEvent event) {
        if (!(event.getEntity() instanceof ServerPlayer player)) return;
        if (!CobbleMerchantLinkInteractionHandler.isHoldingAdminTool(player)) return;
        if (!(event.getTarget() instanceof EntityNPCInterface npc)) return;
        // Nutzer-Korrektur (Bug): der RoleTrader/CobbleMerchant-Modus-Gate lief bisher VOR dieser
        // Prüfung - ein Admin konnte einen NPC dadurch nie verknüpfen/verwalten, BEVOR der Modus
        // schon aktiv war (Henne-Ei-Problem, da der Modus selbst nur über das Admin-Menü ein-/
        // ausschaltbar ist). Ein AdminOp-Spieler mit Holzhacke darf jetzt IMMER jeden NPC anklicken,
        // unabhängig von dessen Rolle/Modus.
        UUID npcUuid = npc.getUUID();
        event.setCanceled(true);

        if (npcUuid.equals(pendingLinkByAdmin.get(player.getUUID()))) {
            pendingLinkByAdmin.remove(player.getUUID());
            player.sendSystemMessage(Component.translatableWithFallback(
                "cobblecompanion.msg.customnpc_link_cancelled", "Linking cancelled."));
            return;
        }

        pendingLinkByAdmin.put(player.getUUID(), npcUuid);
        CustomNpcTraderLinkManager.Target existingTicker = CustomNpcTraderLinkManager.getTickerLink(npcUuid);
        CustomNpcTraderLinkManager.Target existingStorage = CustomNpcTraderLinkManager.getStorageLink(npcUuid);
        if (existingTicker != null || existingStorage != null) {
            player.sendSystemMessage(Component.translatableWithFallback(
                "cobblecompanion.msg.customnpc_link_start_existing",
                "Currently linked - ticker: %s, payment storage: %s. Left-click a stock ticker to change that link, a chest to change payment storage, or the NPC again to cancel.",
                formatTarget(existingTicker), formatTarget(existingStorage)));
        } else {
            player.sendSystemMessage(Component.translatableWithFallback(
                "cobblecompanion.msg.customnpc_link_start",
                "Left-click a stock ticker (required for this NPC to sell anything), a chest, or a linked creative crate to link this NPC."));
        }
    }

    private static String formatTarget(CustomNpcTraderLinkManager.Target target) {
        if (target == null) return "-";
        return target.x() + "," + target.y() + "," + target.z();
    }

    /**
     * Rechtsklick auf einen Trader-NPC: mit Holzhacke (AdminOp) öffnet das Admin-Optionsmenü (siehe
     * MerchantAdminOptionsInteractionHandler.buildAndSend), normaler Spieler bekommt je nach
     * MerchantSettingsManager.SellMenu ggf. ein alternatives Verkaufsmenü (siehe AlternateSellMenuOpener)
     * statt des normalen CustomNPCs-Kaufmenüs.
     */
    @SubscribeEvent(priority = EventPriority.HIGH)
    public void onEntityInteract(net.neoforged.neoforge.event.entity.player.PlayerInteractEvent.EntityInteract event) {
        if (event.getHand() != InteractionHand.MAIN_HAND) return;
        if (!(event.getEntity() instanceof ServerPlayer player)) return;
        if (!(event.getTarget() instanceof EntityNPCInterface npc)) return;

        // Nutzer-Korrektur: ein AdminOp-Spieler mit Holzhacke öffnet IMMER das Admin-Menü, egal ob
        // der NPC gerade Trader-Rolle/CobbleMerchant-Modus hat (siehe onAttackEntity-Kommentar,
        // gleiches Henne-Ei-Problem) - genau darüber schaltet man den Modus ja erst ein.
        if (CobbleMerchantLinkInteractionHandler.isHoldingAdminTool(player)) {
            event.setCanceled(true);
            com.cobblecompanion.cobbledollarscreate.MerchantAdminOptionsInteractionHandler.buildAndSend(
                player, npc.getUUID(), npc.getName().getString(), true);
            return;
        }

        // Normale Spieler sehen weiterhin nur dann ein (alternatives) Verkaufsmenü, wenn der NPC
        // tatsächlich als Händler aktiv ist.
        boolean isMerchantMode = ModAvailability.isCobbleDollarsAvailable()
            && CustomNpcMerchantShopManager.isEnabled(npc.getUUID());
        if (!(npc.role instanceof RoleTrader) && !isMerchantMode) return;

        if (ModAvailability.isCreateAvailable()
                && com.cobblecompanion.cobbledollarscreate.AlternateSellMenuOpener.tryOpen(player, npc.getUUID(), npc.getName().getString())) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGH)
    public void onLeftClickBlock(PlayerInteractEvent.LeftClickBlock event) {
        if (event.getHand() != InteractionHand.MAIN_HAND) return;
        if (!(event.getEntity() instanceof ServerPlayer player)) return;
        if (!CobbleMerchantLinkInteractionHandler.isHoldingAdminTool(player)) return;

        UUID npcUuid = pendingLinkByAdmin.get(player.getUUID());
        if (npcUuid == null) return;

        Level level = event.getLevel();
        BlockPos pos = event.getPos();
        if (!(level instanceof net.minecraft.server.level.ServerLevel serverLevel)) return;

        if (ModAvailability.isCreateAvailable() && CreateStockTickerBridge.isStockTicker(level, pos)) {
            event.setCanceled(true);
            pendingLinkByAdmin.remove(player.getUUID());
            CustomNpcTraderLinkManager.setTickerLink(npcUuid, level.dimension(), pos);
            player.sendSystemMessage(Component.translatableWithFallback(
                "cobblecompanion.msg.customnpc_ticker_link_done",
                "NPC linked to stock ticker at %s, %s, %s - it can now sell items from that network's stock.",
                String.valueOf(pos.getX()), String.valueOf(pos.getY()), String.valueOf(pos.getZ())));
            return;
        }

        IItemHandler handler = CustomNpcTraderLinkManager.findItemHandler(serverLevel, pos);
        if (handler == null) {
            player.sendSystemMessage(Component.translatableWithFallback(
                "cobblecompanion.msg.customnpc_link_no_inventory", "This block is neither a stock ticker nor has an inventory."));
            return;
        }

        event.setCanceled(true);
        pendingLinkByAdmin.remove(player.getUUID());
        CustomNpcTraderLinkManager.setStorageLink(npcUuid, level.dimension(), pos);
        player.sendSystemMessage(Component.translatableWithFallback(
            "cobblecompanion.msg.customnpc_storage_link_done", "Payment items from this NPC will now be delivered to %s, %s, %s.",
            String.valueOf(pos.getX()), String.valueOf(pos.getY()), String.valueOf(pos.getZ())));
    }
}
