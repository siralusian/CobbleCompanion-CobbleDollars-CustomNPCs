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

- **Turn a CustomNPC into a CobbleMerchant-style shop**: **Alt+right-click** the NPC to toggle it
  on/off — it keeps its appearance, but right-clicking then opens the CobbleMerchant shop instead
  of CustomNPCs' own interaction.
- **Link it to a stock ticker or payout chest** (a stock ticker link is mandatory before the NPC
  can sell anything):
  1. Ctrl+right-click the NPC to start link mode.
  2. Ctrl+right-click a stock ticker (required) or a chest (optional payout target) to link it.
  3. Ctrl+right-click the same NPC again to cancel.

**Dependencies:** CobbleCompanion: Basis + CobbleCompanion: CobbleDollars (both required),
CustomNPCs-Unofficial-NeoForge and CobbleDollars (both required).

### Building

No foreign mod jars ship in `libs/` for licensing reasons — place them there yourself before
building.

**Own dependencies (build them yourself):**
- `CobbleCompanion-Basis-*.jar` — build from [CobbleCompanion](https://github.com/siralusian/CobbleCompanion).
- `CobbleCompanion-CobbleDollars-*.jar` — build from [CobbleCompanion-CobbleDollars](https://github.com/siralusian/CobbleCompanion-CobbleDollars).

Both via `./gradlew jar`, copy the result from `build/libs/` into `libs/` here.

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

- **CustomNPC zu einem CobbleMerchant-artigen Shop machen**: **Alt+Rechtsklick** auf den NPC
  schaltet um – er behält sein Aussehen, Rechtsklick öffnet danach den CobbleMerchant-Shop statt
  CustomNPCs' eigener Interaktion.
- **Mit Lagerticker/Auszahlungs-Kiste verknüpfen** (eine Ticker-Verknüpfung ist Pflicht, bevor der
  NPC etwas verkaufen kann):
  1. Strg+Rechtsklick auf den NPC startet den Verknüpfungs-Modus.
  2. Strg+Rechtsklick auf einen Lagerticker (Pflicht) oder eine Kiste (optionales
     Auszahlungsziel) verknüpft ihn.
  3. Erneutes Strg+Rechtsklick auf denselben NPC bricht ab.

**Abhängigkeiten:** CobbleCompanion: Basis + CobbleCompanion: CobbleDollars (beide erforderlich),
CustomNPCs-Unofficial-NeoForge und CobbleDollars (beide erforderlich).

### Bauen

Aus Lizenzgründen liegen keine fremden Mod-Jars in `libs/` im Repo – du musst sie vor dem Bauen
selbst dort ablegen.

**Eigene Abhängigkeiten (musst du selbst bauen):**
- `CobbleCompanion-Basis-*.jar` — aus [CobbleCompanion](https://github.com/siralusian/CobbleCompanion) bauen.
- `CobbleCompanion-CobbleDollars-*.jar` — aus [CobbleCompanion-CobbleDollars](https://github.com/siralusian/CobbleCompanion-CobbleDollars) bauen.

Beide jeweils mit `./gradlew jar`, das Ergebnis aus `build/libs/` hierher nach `libs/` kopieren.

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
