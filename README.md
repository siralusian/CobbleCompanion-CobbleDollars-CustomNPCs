# CobbleCompanion: CobbleDollars/CustomNPCs

[🇩🇪 Deutsche Version weiter unten](#deutsch)

## English

Bridges CustomNPCs traders and CobbleDollars: live stock sync and trading integration. Part of the
modular **CobbleCompanion** family for Cobblemon — usable in both singleplayer and multiplayer,
though this particular module (an automated NPC shop system) is aimed squarely at multiplayer
servers with an economy.

### What it does

Links trader NPCs from **CustomNPCs-Unofficial-NeoForge** to the CobbleDollars economy:

- Your NPC trader's stock stays live-synced with a linked CobbleDollars selling system.
- Buy/sell interaction directly at the NPC, billed in CobbleDollars.
- Optional Create integration for NPC traders wired into a stock ticker network (needs
  [CobbleCompanion: CobbleDollars/Create](https://github.com/siralusian/CobbleCompanion-CobbleDollars-Create)
  too).

### How to use it

Both interactions below need **AdminOp** ([granted via
`/companion adminop <name>`](https://github.com/siralusian/CobbleCompanion#admin-access--professor-tab))
— this module is built for whoever sets up the server's NPC shops, not something a regular player
configures.

Managed with a plain **wooden hoe** held by an AdminOp — the same admin tool CobbleMerchants use
(from [CobbleCompanion: CobbleDollars/Create](https://github.com/siralusian/CobbleCompanion-CobbleDollars-Create),
required alongside this module):

- **Turn a CustomNPC into a CobbleMerchant-style shop**: **right-click the NPC with the hoe** to
  open its admin options menu, then toggle **"CobbleMerchant mode"** on/off — it keeps its
  appearance, but a plain right-click then opens the CobbleMerchant shop instead of CustomNPCs' own
  interaction. The same menu also sets its price list, item source, sell menu, and delivery method
  — see the [Create module's
  wiki](https://github.com/siralusian/CobbleCompanion-CobbleDollars-Create/wiki/English#the-admin-options-menu)
  for what every option does.
- **Link it to a stock ticker or payout chest** (a stock ticker link is mandatory before the NPC
  can sell anything):
  1. **Left-click (attack) the NPC with the hoe** to start link mode.
  2. **Left-click a stock ticker** (required) or **a chest** (optional payout target) to link it.
  3. **Left-click the same NPC again** to cancel.

### Dependencies

Required:
[CobbleCompanion](https://modrinth.com/mod/uc8Q0UPV)
[CobbleCompanion: CobbleDollars](https://modrinth.com/mod/iXFx1KCW)
[CobbleCompanion: CobbleDollars/Create](https://modrinth.com/mod/q90smYb6) (the shared admin menu
and hoe tool live there)
[Create](https://modrinth.com/mod/create)
[CobbleDollars](https://modrinth.com/mod/cobbledollars)
[CustomNPCs Unofficial](https://curseforge.com/minecraft/mc-mods/customnpcs-unofficial)

### Check out my other projects too

- [Area Claims](https://curseforge.com/minecraft/mc-mods/area-claims) — Lets players claim their
  own area on your server.
- [CobbleCompanion](https://curseforge.com/minecraft/mc-mods/cobblecompanion-all-in-one) —
  companion tool for the Cobblemon mod.
- [Create: Let's Do Automation](https://curseforge.com/minecraft/mc-mods/create-let-s-do) — lets
  you automatically fill Let's Do work blocks using Create.
- [CreativeMenu](https://curseforge.com/minecraft/mc-mods/creative-menu) — freely design your
  Creative menu the way you want. Fully configurable in-game.
- [CopycatSign](https://curseforge.com/minecraft/mc-mods/create-copycat-sign) — hang pictures on
  your walls, Create trains, airships and more, with freely choosable border and back textures.
- [Item Creator](https://curseforge.com/minecraft/mc-mods/itemcreator) — create items with
  enchantments and more, entirely without /give commands.
- [InvSpy](https://curseforge.com/minecraft/mc-mods/invspy) — powerful tool for server admins.
  Check which player used a chest, or what your players are carrying in their inventory.
- [MobTweaks](https://curseforge.com/minecraft/mc-mods/mobtweak) — tool for server admins. Control
  which mobs may spawn where, adjust loot, or prevent world damage from Creepers, Endermen and co.

[![ko-fi](https://ko-fi.com/img/githubbutton_sm.svg)](https://ko-fi.com/C3W0229LCP)

---

## Deutsch

Verbindet CustomNPCs-Händler mit CobbleDollars: Lagerbestand-Synchronisation und
Handels-Integration. Teil der modularen **CobbleCompanion**-Familie für Cobblemon – nutzbar im
Singleplayer und auf Servern, wobei dieses Modul (ein automatisiertes NPC-Shop-System) klar auf
Multiplayer-Server mit Wirtschaft ausgerichtet ist.

### Was es macht

Verknüpft Händler-NPCs aus **CustomNPCs-Unofficial-NeoForge** mit der CobbleDollars-Wirtschaft:

- Lagerbestand deines NPC-Händlers wird live mit einem verlinkten CobbleDollars-Verkaufssystem
  synchronisiert.
- Kauf-/Verkaufsinteraktion direkt am NPC, abgerechnet in CobbleDollars.
- Optionale Create-Anbindung für NPC-Händler, die an ein Lagerticker-Netzwerk angebunden sind
  (braucht zusätzlich
  [CobbleCompanion: CobbleDollars/Create](https://github.com/siralusian/CobbleCompanion-CobbleDollars-Create)).

### Benutzung

Beide Interaktionen unten brauchen **AdminOp** ([vergeben über
`/companion adminop <Name>`](https://github.com/siralusian/CobbleCompanion#admin-zugang--professor-tab))
– dieses Modul ist für die Person gebaut, die die Server-NPC-Shops einrichtet, nicht für die
normale Spieler-Nutzung.

Verwaltet mit einer ganz normalen **Holzhacke** in der Hand eines AdminOp – demselben
Admin-Werkzeug, das auch CobbleMerchants nutzen (aus
[CobbleCompanion: CobbleDollars/Create](https://github.com/siralusian/CobbleCompanion-CobbleDollars-Create),
zusätzlich zu diesem Modul erforderlich):

- **CustomNPC zu einem CobbleMerchant-artigen Shop machen**: **Rechtsklick auf den NPC mit der
  Holzhacke** öffnet dessen Admin-Optionsmenü, dort **"CobbleMerchant-Modus"** an-/ausschalten – er
  behält sein Aussehen, aber ein einfacher Rechtsklick öffnet danach den CobbleMerchant-Shop statt
  CustomNPCs' eigener Interaktion. Im selben Menü stellst du auch Preisliste, Item-Quelle,
  Verkaufsmenü und Auslieferungsmethode ein – siehe das
  [Wiki des Create-Moduls](https://github.com/siralusian/CobbleCompanion-CobbleDollars-Create/wiki/Deutsch#das-admin-optionsmenü)
  für jede Option im Detail.
- **Mit Lagerticker/Auszahlungs-Kiste verknüpfen** (eine Ticker-Verknüpfung ist Pflicht, bevor der
  NPC etwas verkaufen kann):
  1. **Linksklick (Angriff) auf den NPC mit der Holzhacke** startet den Verknüpfungs-Modus.
  2. **Linksklick auf einen Lagerticker** (Pflicht) oder **eine Kiste** (optionales
     Auszahlungsziel) verknüpft ihn.
  3. **Erneuter Linksklick auf denselben NPC** bricht ab.

### Abhängigkeiten

Erforderlich:
[CobbleCompanion](https://modrinth.com/mod/uc8Q0UPV)
[CobbleCompanion: CobbleDollars](https://modrinth.com/mod/iXFx1KCW)
[CobbleCompanion: CobbleDollars/Create](https://modrinth.com/mod/q90smYb6) (das geteilte Admin-Menü
und die Holzhacke leben dort)
[Create](https://modrinth.com/mod/create)
[CobbleDollars](https://modrinth.com/mod/cobbledollars)
[CustomNPCs Unoffizial](https://curseforge.com/minecraft/mc-mods/customnpcs-unofficial)

### Sieh dir auch meine anderen Projekte an

- [Area Claims](https://curseforge.com/minecraft/mc-mods/area-claims) — Erlaube es Spielern ihren eigenen Bereich auf deinem Server zu beanspruchen.
- [CobbleCompanion](https://curseforge.com/minecraft/mc-mods/cobblecompanion-all-in-one) Hilfstool für die Cobblemon Mod
- [Create: Let's Do Automation](https://curseforge.com/minecraft/mc-mods/create-let-s-do) — Ermöglicht das automatische Befüllen von Let's Do Arbeitsblöcken mithilfe von Create.
- [CreativeMenu](https://curseforge.com/minecraft/mc-mods/creative-menu) — Gestalte dein Creative Menü frei nach deinen Wünschen. Alles ingame einstellbar.
- [CopycatSign](https://curseforge.com/minecraft/mc-mods/create-copycat-sign) — Hänge Bilder an deine Wände, Züge, Luftschiffe und Co mit frei wählbaren Rand- und Rückseiten-Texturen.
- [Item Creator](https://curseforge.com/minecraft/mc-mods/itemcreator) — Erzeuge Items mit Verzauberungen und Co ganz ohne /give Commands
- [InvSpy](https://curseforge.com/minecraft/mc-mods/invspy) — Starkes Tool für Server-Betreiber. Prüfe welcher Spieler sich an einer Truhe bedient hat oder was deine Spieler im Inventar haben.
- [MobTweaks](https://curseforge.com/minecraft/mc-mods/mobtweak) — Tool für Server-Betreiber. Steuere welche Mobs wo spawnen dürfen, passe den Loot an oder verhindere Schaden in der Welt durch Creeper, Enderman und co.

*AI-generated content: this mod was developed with AI assistance (Claude). / KI-generierte Inhalte: Diese Mod wurde mit KI-Unterstützung (Claude) entwickelt.*