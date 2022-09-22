<img src="logo.png" alt="Suki logo" align="right">
<div align="center">
  <h1>Suki</h1>
  <h3>A fork of <a href="https://github.com/etil2jz/Mirai">Mirai</a></h3>
  <h4>Made for the server SuCraft: <i>sucraft.org</i></h4>
  
  [![Discord](https://img.shields.io/discord/363647798949969922?color=5865F2&label=discord&style=for-the-badge)](https://discord.com/invite/pbsPkpUjG4)
</div>

## Features

- Fork of **[Mirai](https://github.com/etil2jz/Mirai)** for the best performance, notably:
    - Fork of **[Pufferfish](https://github.com/pufferfish-gg/Pufferfish)** for the best performance.
    - Contains **[Lithium](https://github.com/CaffeineMC/lithium-fabric)** patches which respect Vanilla parity.
    - (WIP) Implements **[C2ME](https://github.com/RelativityMC/C2ME-fabric)** to improve chunk generation speed, I/O and loading.
    - Async Pathfinding and Multithreaded Entity Tracker from **[Petal](https://github.com/Bloom-host/Petal)** which drastically reduce entity load.
    - Reduced bandwidth consumption and CPU usage from avoiding sending useless packets in certain situations.
    - Bugfixes for several Minecraft issues.
    - Faster process for Vanilla methods.\
&nbsp;
- Patches from **[EmpireCraft](https://github.com/starlis/empirecraft)** improving performance, gameplay and fixing inconsistencies.\
&nbsp;
- <sup>Configurable</sup> Strongholds can [spawn above ground](https://cdn.discordapp.com/attachments/363647799373463562/990000668611854357/2022-06-24_23.07.08.png), are bigger and are more challenging with webs, holes and water.
- <sup>Configurable</sup> Adds permissions to see plugins in `/plugins`.
- <sup>Configurable</sup> Disable `Moved too quickly` and `Moved wrongly`.
- Small important packets are sent without delay.
- <sup>Configurable</sup> Don't kick players for timing out.
- Prevents staggered terrain after data corruption.
- Further reach distance is accepted from players to prevent block placements failing due to lag.
- Debug stick can be used in survival mode (with a permission) for a limited number of block properties, such as changing the visual `lit` state of a furnace or the rotation of logs or stairs.
- <sup>Configurable</sup> Gameplay difficulty changes:
    - Zombies can call for reinforcements on all difficulties.
    - All raids are hard (so they contain evokers).
    - Cave spiders can have poison on easy difficulty.
    - Wither skulls can give the wither effect on easy difficulty.
    - Prevent lightning from spawning fire.
    - Set the minimum health left after starving.
    - Spiders can spawn with potion effects on all difficulties.
    - Set the gossip (reputation) change for player-villager interactions.
    - Players can share positive villager gossips.
- Banners and other items/blocks can be placed directly into the head slot.
- <sup>Configurable</sup> Skip a custom proportion of active entity ticks (Paper uses 1/4 by default).
- <sup>Configurable</sup> Entities are immune from beig made inactive for a time after certain actions (like a fox targeting a rabbit, or a tamed dog while it is not sitting).
- <sup>Configurable</sup> Entities are woken up from inactivity with some variance instead of many at the same time
- Enchantment compatibilities:
    - Looting on a Bow, Crossbow and Trident
    - Protection and Thorns on an Elytra
- Signed chat is removed (all messages are system chat and there is no `[NOT SECURE]` marker in the console)
- <sup>Configurable</sup> Bone meal can be used on stripped logs to grow back their bark
- <sup>Configurable</sup> Set a custom TPS catch-up time (to temporarily perform ticks faster than 20 TPS after TPS goes below 20)
- Prevent duplicate block and chunk updates sent over time, preventing FPS loss on the client when there are many recurring block updates such as from moving lights or pistons.
- <sup>Configurable</sup> Interweave chunk and non-chunk packets based on network conditions, so that heavy world loading under a constrained network does not impact smooth movement and combat.
- <sup>Configurable</sup> Separate view distance for tracked chunks and non-tracked chunks, allowing a view distance of 32 with very low CPU usage.
- <sup>Configurable</sup> Limit the chunks loaded and ticked by the server based on the client view distance.
- <sup>Configurable</sup> Fairly adapt the maximum view distances of all players automatically based on each player's client view distance and the configured total number of chunks the server can handle.

## Building

You can clone this repository and build it yourself.
If you are interested in making a fork, check out this template [there](https://github.com/PaperMC/paperweight-examples)!

In order to distribute and use this server software, you need a paperclip file:

```bash
./gradlew applyPatches && ./gradlew createReobfPaperclipJar
```

## License
Patches are licensed under GPL-3.0.  
All other non-binary files are licensed under MIT.
No license is given for binary files; all copyright rights reserved.

Made with <span style="color: #e25555;">&#9829;</span> on Earth.
