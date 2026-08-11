# CobbleCompanion: CobbleDollars/CustomNPCs

[![ko-fi](https://ko-fi.com/img/githubbutton_sm.svg)](https://ko-fi.com/C3W0229LCP)

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

**Dependencies:** CobbleCompanion: Basis + CobbleCompanion: CobbleDollars + CobbleCompanion:
CobbleDollars/Create (all required — the shared admin menu and hoe tool live in the Create
module), CustomNPCs-Unofficial-NeoForge and CobbleDollars (both required).

### Building

No foreign mod jars ship in `libs/` for licensing reasons — place them there yourself before
building.

**Own dependencies (build them yourself):**
- `CobbleCompanion-Basis-*.jar` — build from [CobbleCompanion](https://github.com/siralusian/CobbleCompanion).
- `CobbleCompanion-CobbleDollars-*.jar` — build from [CobbleCompanion-CobbleDollars](https://github.com/siralusian/CobbleCompanion-CobbleDollars).
- `CobbleCompanion-CobbleDollars-Create-*.jar` — build from [CobbleCompanion-CobbleDollars-Create](https://github.com/siralusian/CobbleCompanion-CobbleDollars-Create)
  (the shared admin menu/hoe tool live there — required, not just for compiling).

All three via `./gradlew jar`, copy the result from `build/libs/` into `libs/` here.

**Required:**
- `Cobblemon-neoforge-*.jar`, `CobbleDollars-neoforge-*.jar`
- `CustomNPCs-Unofficial-NeoForge-*.jar`

**Optional:**
- `create-*.jar`, `ponder-neoforge-*.jar` — for the optional Create/stock-ticker integration

### Other CobbleCompanion projects

- [CobbleCompanion](https://github.com/siralusian/CobbleCompanion) — the base mod.
- [CobbleCompanion: CobbleDollars](https://github.com/siralusian/CobbleCompanion-CobbleDollars) —
  the CobbleDollars base this module builds on.
- [CobbleCompanion: CobbleDollars/Create](https://github.com/siralusian/CobbleCompanion-CobbleDollars-Create)
- [CobbleCompanion: CobblemonWorker](https://github.com/siralusian/CobbleCompanion-CobblemonWorker)
- [CobbleCompanion: Create/Let's Do](https://github.com/siralusian/CreateLetsDo)
- [CobbleCompanion: AllInOne](https://github.com/siralusian/CobbleCompanion-AllInOne) — this
  module plus everything else, in one file.
- [CobbleCompanion: CobbleDollars-Bundle](https://github.com/siralusian/CobbleCompanion-CobbleDollarsBundle) —
  this module plus the Create integration, in one file.

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

**Abhängigkeiten:** CobbleCompanion: Basis + CobbleCompanion: CobbleDollars + CobbleCompanion:
CobbleDollars/Create (alle erforderlich – das geteilte Admin-Menü und die Holzhacke leben im
Create-Modul), CustomNPCs-Unofficial-NeoForge und CobbleDollars (beide erforderlich).

### Bauen

Aus Lizenzgründen liegen keine fremden Mod-Jars in `libs/` im Repo – du musst sie vor dem Bauen
selbst dort ablegen.

**Eigene Abhängigkeiten (musst du selbst bauen):**
- `CobbleCompanion-Basis-*.jar` — aus [CobbleCompanion](https://github.com/siralusian/CobbleCompanion) bauen.
- `CobbleCompanion-CobbleDollars-*.jar` — aus [CobbleCompanion-CobbleDollars](https://github.com/siralusian/CobbleCompanion-CobbleDollars) bauen.
- `CobbleCompanion-CobbleDollars-Create-*.jar` — aus [CobbleCompanion-CobbleDollars-Create](https://github.com/siralusian/CobbleCompanion-CobbleDollars-Create)
  bauen (das geteilte Admin-Menü/die Holzhacke leben dort – erforderlich, nicht nur zum Kompilieren).

Alle drei jeweils mit `./gradlew jar`, das Ergebnis aus `build/libs/` hierher nach `libs/` kopieren.

**Erforderlich:**
- `Cobblemon-neoforge-*.jar`, `CobbleDollars-neoforge-*.jar`
- `CustomNPCs-Unofficial-NeoForge-*.jar`

**Optional:**
- `create-*.jar`, `ponder-neoforge-*.jar` — für die optionale Create-/Lagerticker-Anbindung

### Weitere CobbleCompanion-Projekte

- [CobbleCompanion](https://github.com/siralusian/CobbleCompanion) — die Basis-Mod.
- [CobbleCompanion: CobbleDollars](https://github.com/siralusian/CobbleCompanion-CobbleDollars) —
  die CobbleDollars-Basis, auf der dieses Modul aufbaut.
- [CobbleCompanion: CobbleDollars/Create](https://github.com/siralusian/CobbleCompanion-CobbleDollars-Create)
- [CobbleCompanion: CobblemonWorker](https://github.com/siralusian/CobbleCompanion-CobblemonWorker)
- [CobbleCompanion: Create/Let's Do](https://github.com/siralusian/CreateLetsDo)
- [CobbleCompanion: AllInOne](https://github.com/siralusian/CobbleCompanion-AllInOne) — dieses
  Modul plus alles andere, in einer Datei.
- [CobbleCompanion: CobbleDollars-Bundle](https://github.com/siralusian/CobbleCompanion-CobbleDollarsBundle) —
  dieses Modul plus die Create-Anbindung, in einer Datei.
