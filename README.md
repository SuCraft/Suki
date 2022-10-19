<img src="logo.png" alt="Suki logo" align="right">
<div align="center">
  <h1>Suki</h1>
  <h3>A fork of <a href="https://github.com/etil2jz/Mirai">Mirai</a></h3>
  <h4>Made for the server SuCraft: <i>sucraft.org</i></h4>
  
  [![Discord](https://img.shields.io/discord/363647798949969922?color=5865F2&label=discord&style=for-the-badge)](https://discord.com/invite/pbsPkpUjG4)
</div>

## About

Suki is a [Paper](https://github.com/PaperMC/Paper) server fork for SuCraft, a survival server since August 2011. As such, it must be stable and high performance.

Suki is a direct fork of [Mirai](https://github.com/etil2jz/Mirai), which includes various reasonably stable improvements from [Pufferfish](https://github.com/pufferfish-gg/Pufferfish), [Petal](https://github.com/Bloom-host/Petal), [Lithium](https://github.com/CaffeineMC/lithium-fabric) and more. To maintain stability, Suki may not always update from upstream right away if changes to Mirai have not been tested.

Suki adds unique performance mechanics specially geared towards getting the most out of your hardware for a community server.

&#10141; **See [Quick setup](https://github.com/SuCraft/Suki/wiki/Quick-setup) for a quick setup guide, and [Features](https://github.com/SuCraft/Suki/wiki/Features) for details of every feature.**

## Features

<h3>Inherited</h3>

- Fork of **[Mirai](https://github.com/etil2jz/Mirai)**, **[Pufferfish](https://github.com/pufferfish-gg/Pufferfish)** for the best performance.
- Contains **[Lithium](https://github.com/CaffeineMC/lithium-fabric)** patches which respect vanilla parity.
- Async pathfinding and multithreaded entity tracker from **[Petal](https://github.com/Bloom-host/Petal)** which drastically reduce entity load.
- Reduced bandwidth consumption and CPU usage from avoiding sending useless packets in certain situations.
- Bug fixes for several Minecraft issues.
- Faster process for vanilla methods.

<h3>Performance</h3>

<ul>
    <b>Very high view distance at low CPU</b> <a href="https://github.com/SuCraft/Suki/wiki/Features#view-distance">(&#10141; Wiki)</a>
    <li>
        Separate view distance for tracked chunks and non-tracked chunks, allowing a view distance of 32 with very low CPU usage.
    </li>
    <li>
        Automatically set the view distances of each player based on each client view distance and the configured total number of chunks the server can handle.
    </li>
    <li>
        Limit the chunks loaded and sent by the server based on the client view distance.
    </li>
</ul>

<ul>
    <b>Faster entity ticking</b> <a href="https://github.com/SuCraft/Suki/wiki/Features#entity-ticking">(&#10141; Wiki)</a>
    <li>
        Skip a custom proportion of active entity ticks. (Paper uses &frac14; by default.)
    </li>
    <li>
        Configurable item pickup frequency for hoppers and villagers. <a href="https://github.com/SuCraft/Suki/wiki/Features#item-pickup">(&#10141; Wiki)</a>
    </li>
    <li>
        Entities are woken up from inactivity with some variance instead of many at the same time.
    </li>
</ul>
<ul>
    <b>Accurate async CPU usage</b> <a href="https://github.com/SuCraft/Suki/wiki/Features#accurate-async-cpu-usage">(&#10141; Wiki)</a>
    <li>
    Environment variables that give you full control over the number of CPU cores/threads used for async tasks, such as chunk loading, entity tracking and async plugin tasks.
    </li>
</ul>

<ul>
    <b>Smooth networking</b>
    <li>
        Interweave chunk and non-chunk packets based on network conditions, so that heavy world loading under a constrained network does not impact smooth movement and combat. <a href="https://github.com/SuCraft/Suki/wiki/Features#network-constrained-chunk-sending">(&#10141; Wiki)</a>
    </li>
    <li>
        Small important packets are sent without delay.
    </li>
    <li>
        Prevent duplicate block and chunk updates sent over time, preventing FPS loss on the client when there are many recurring block updates such as from moving lights or pistons. <a href="https://github.com/SuCraft/Suki/wiki/Features#prevent-block-update-client-lag">(&#10141; Wiki)</a>
    </li>
    <li>
        Customize keepalive frequency and don't kick players for timing out. <a href="https://github.com/SuCraft/Suki/wiki/Features#keepalive">(&#10141; Wiki)</a>
    </li>
    <li>
        Further reach distance can be accepted from players to prevent block placements failing due to lag. <a href="https://github.com/SuCraft/Suki/wiki/Features#interaction-distance">(&#10141; Wiki)</a>
    </li>
    </li>
</ul>

<ul>
    <b>Configurable TPS oversleep</b> <a href="https://github.com/SuCraft/Suki/wiki/Features#tpsoversleep">(&#10141; Wiki)</a>
    <li>
    Configure the minimum tick oversleep time (the time that is used to perform scheduled main thread tasks).
    </li>
</ul>

<h3>Gameplay</h3>

<ul>
    <b>Additions</b>
    <li>
        A debug stick can be used in survival mode for block properties compatible with survival mode, such as changing the visual <code>lit</code> state of a furnace or the rotation of logs or stairs. <a href="https://github.com/SuCraft/Suki/wiki/Features#survival-debug-stick">(&#10141; Wiki)</a>
    </li>
    <li>
        Banners and other items/blocks can be placed directly into the head slot. <a href="https://github.com/SuCraft/Suki/wiki/Features#place-items-directly-into-head-slot">(&#10141; Wiki)</a>
    </li>
    <li>
        Bone meal can be used on stripped logs to unstrip them. <a href="https://github.com/SuCraft/Suki/wiki/Features#bone-meal-regrows-bark">(&#10141; Wiki)</a>
    </li>
</ul>

<ul>
    <b>Changes</b>
    <li>
        Configurable difficulty settings: <a href="https://github.com/SuCraft/Suki/wiki/Features#difficulty-changes">(&#10141; Wiki)</a>
        <ul>
            <li>Zombies can call for reinforcements on all difficulties</li>
            <li>All raids are Hard (so they contain evokers)</li>
            <li>Cave spiders poison on Easy difficulty</li>
            <li>Wither skulls give the wither effect on Easy difficulty</li>
            <li>Prevent lightning from spawning fire</li>
            <li>Set the minimum health left after starving</li>
            <li>Spiders can spawn with potion effects on all difficulties</li>
            <li>Set the reputation change for player-villager interactions</li>
            <li>Players can share villager discounts</li>
        </ul>
    </li>
    <li>
        Configurable enchantment compatibilities: <a href="https://github.com/SuCraft/Suki/wiki/Features#enchantability">(&#10141; Wiki)</a>
        <ul>
            <li>Looting on a bow, crossbow, trident, axe, hoe, pickaxe or shovel</li>
            <li>Protection and Thorns on an elytra</li>
            <li>Sharpness, Smite and Bane of Arthropods on a hoe, pickaxe or shovel</li>
            <li>Knockback and Fire Apect on an axe, hoe, pickaxe or shovel</li>
            <li>Efficiency, Fortune and Silk Touch on a sword</li>
        </ul>
    </li>
</ul>

<h3>Other</h3>

<ul>
    <b>Disable signed chat</b> <a href="https://github.com/SuCraft/Suki/wiki/Features#signed-chat">(&#10141; Wiki)</a>
    <li>
    Signed chat and chat reporting can be completely disabled. (All messages are sent as system chat.)
    </li>
</ul>

<ul>
    <b>Privacy for administrators</b>
    <li>
        Permissions to see plugins in <code>/plugins</code>. <a href="https://github.com/SuCraft/Suki/wiki/Features#plugins">(&#10141; Wiki)</a>
    </li>
    <li>
        Hide players' game modes from others. <a href="https://github.com/SuCraft/Suki/wiki/Features#hide-game-modes">(&#10141; Wiki)</a>
    </li>
</ul>

<ul>
    <b>Disable some console messages</b> <a href="https://github.com/SuCraft/Suki/wiki/Features#console-logs">(&#10141; Wiki)</a>
    <li>
    <code>Moved too quickly</code> and <code>Moved wrongly</code> logs
    </li>
    <li>
    Empty chat messages
    </li>
    <li>
    <code>[Not Secure]</code> marker for insecure chat
    </li>
    <li>
    Invalid statistics warnings
    </li>
</ul>

<ul>
    <b>No corrupted chunk relocations</b> <a href="https://github.com/SuCraft/Suki/wiki/Features#relocate-corrupted-chunks">(&#10141; Wiki)</a>
    <li>
    Prevents staggered terrain after data corruption.
    </li>
</ul>

## Building

You can clone this repository and build it yourself.
If you are interested in making a Paperweight fork, check out [the example template](https://github.com/PaperMC/paperweight-examples)!

In order to distribute and use this server software, you need a paperclip file:

```bash
./gradlew applyPatches && ./gradlew createReobfPaperclipJar
```

## License
Patches are licensed under GPL-3.0. No license is given for the Suki image; all copyright rights reserved. All other files are licensed under MIT.

Made with <span style="color: #e25555;">&#9829;</span> on Earth.
