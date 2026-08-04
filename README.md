# CobbleCompanion: CobbleDollars/CustomNPCs

Teil der **CobbleCompanion**-Familie — ein modulares Baukasten-System für Cobblemon-Server.
Siehe [Verwandte Module](#verwandte-module--related-modules) unten für alle Varianten.

**Kurzbeschreibung:**
Verbindet CustomNPCs-Händler mit CobbleDollars: Lagerbestand-Synchronisation und
Handels-Integration.

## Beschreibung

Verknüpft Händler-NPCs aus **CustomNPCs-Unofficial-NeoForge** mit der CobbleDollars-Wirtschaft:

- Lagerbestand deines NPC-Händlers wird live mit einem verlinkten CobbleDollars-Verkaufssystem
  synchronisiert.
- Kauf-/Verkaufsinteraktion direkt am NPC, abgerechnet in CobbleDollars.
- Optionale Create-Anbindung für NPC-Händler, die an ein Lagerticker-Netzwerk angebunden sind.

**Abhängigkeiten:** CobbleCompanion: Basis + CobbleCompanion: CobbleDollars (beide erforderlich),
CustomNPCs-Unofficial-NeoForge und CobbleDollars (beide erforderlich).

---

## English

**Summary:**
Bridges CustomNPCs traders and CobbleDollars: live stock sync and trading integration.

## Description

Links trader NPCs from **CustomNPCs-Unofficial-NeoForge** to the CobbleDollars economy:

- Your NPC trader's stock stays live-synced with a linked CobbleDollars selling system.
- Buy/sell interaction directly at the NPC, billed in CobbleDollars.
- Optional Create integration for NPC traders wired into a stock ticker network.

**Dependencies:** CobbleCompanion: Basis + CobbleCompanion: CobbleDollars (both required),
CustomNPCs-Unofficial-NeoForge and CobbleDollars (both required).

---

## Bauen / Building

Aus Lizenzgründen liegen keine fremden Mod-Jars in `libs/` im Repo – du musst sie vor dem Bauen
selbst dort ablegen.
*No foreign mod jars ship in `libs/` for licensing reasons — place them there yourself before
building.*

**Eigene Abhängigkeiten (musst du selbst bauen) / Own dependencies (build them yourself):**
- `CobbleCompanion-Basis-*.jar` — aus [CobbleCompanion](https://github.com/siralusian/CobbleCompanion) bauen.
- `CobbleCompanion-CobbleDollars-*.jar` — aus [CobbleCompanion-CobbleDollars](https://github.com/siralusian/CobbleCompanion-CobbleDollars) bauen.

Beide jeweils mit `./gradlew jar`, das Ergebnis aus `build/libs/` hierher nach `libs/` kopieren.

**Erforderlich / Required:**
- `Cobblemon-neoforge-*.jar`, `CobbleDollars-neoforge-*.jar`
- `CustomNPCs-Unofficial-NeoForge-*.jar`

**Optional:**
- `create-*.jar`, `ponder-neoforge-*.jar` — für die optionale Create-Anbindung

## Verwandte Module / Related modules

- [CobbleCompanion](https://github.com/siralusian/CobbleCompanion) — Basis
- [CobbleCompanion: CobbleDollars](https://github.com/siralusian/CobbleCompanion-CobbleDollars)
- [CobbleCompanion: CobbleDollars/Create](https://github.com/siralusian/CobbleCompanion-CobbleDollars-Create)
- [CobbleCompanion: CobblemonWorker](https://github.com/siralusian/CobbleCompanion-CobblemonWorker)
- [CobbleCompanion: Create/Let's Do](https://github.com/siralusian/CreateLetsDo)
- [CobbleCompanion: AllInOne](https://github.com/siralusian/CobbleCompanion-AllInOne)
- [CobbleCompanion: CobbleDollars-Bundle](https://github.com/siralusian/CobbleCompanion-CobbleDollarsBundle)
