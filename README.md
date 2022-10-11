<img src="logo.png" alt="Suki logo" align="right">
<div align="center">
  <h1>Suki</h1>
  <h3>A fork of <a href="https://github.com/etil2jz/Mirai">Mirai</a></h3>
  <h4>Made for the server SuCraft: <i>sucraft.org</i></h4>
  
  [![Discord](https://img.shields.io/discord/363647798949969922?color=5865F2&label=discord&style=for-the-badge)](https://discord.com/invite/pbsPkpUjG4)
</div>

## Features

#### Inherited

- Fork of **[Mirai](https://github.com/etil2jz/Mirai)**, with notably:
    - Fork of **[Pufferfish](https://github.com/pufferfish-gg/Pufferfish)** for the best performance.
    - Contains **[Lithium](https://github.com/CaffeineMC/lithium-fabric)** patches which respect Vanilla parity.
    - Async Pathfinding and Multithreaded Entity Tracker from **[Petal](https://github.com/Bloom-host/Petal)** which drastically reduce entity load.
    - Reduced bandwidth consumption and CPU usage from avoiding sending useless packets in certain situations.
    - Bug fixes for several Minecraft issues.
    - Faster process for Vanilla methods.\
&nbsp;
- Patches from **[EmpireCraft](https://github.com/starlis/empirecraft)** improving performance, gameplay and fixing inconsistencies.

#### Performance

<ul>
    <b>Smoother entity activation</b>
    <li>
        <sup style="color: #999999;">Configurable</sup> Skip a custom proportion of active entity ticks. (Paper uses &frac14; by default.)
    </li>
    <li>
        <sup style="color: #999999;">Configurable</sup> Entities are immune from being made inactive for a time after certain actions (like a fox targeting a rabbit, or a tamed dog while it is not sitting).
    </li>
    <li>
        <sup style="color: #999999;">Configurable</sup> Entities are woken up from inactivity with some variance instead of many at the same time.
    </li>
</ul>

<ul>
    <b>Smoother experience for bad connections</b>
    <li>
        Prevent duplicate block and chunk updates sent over time, preventing FPS loss on the client when there are many recurring block updates such as from moving lights or pistons.
    </li>
    <li>
        <sup style="color: #999999;">Configurable</sup> Interweave chunk and non-chunk packets based on network conditions, so that heavy world loading under a constrained network does not impact smooth movement and combat.
    </li>
    <li>
        Small important packets are sent without delay.
    </li>
    <li>
        <sup style="color: #999999;">Configurable</sup> Disable <code>Moved too quickly</code> and <code>Moved wrongly</code>.
    </li>
    <li>
        <sup style="color: #999999;">Configurable</sup> Don't kick players for timing out.
    </li>
    <li>
        Further reach distance is accepted from players to prevent block placements failing due to lag.
    </li>
</ul>

<ul>
    <b>Higher view distance</b>
    <li>
        <sup style="color: #999999;">Configurable</sup> Separate view distance for tracked chunks and non-tracked chunks, allowing a view distance of 32 with very low CPU usage.
    </li>
    <li>
        <sup style="color: #999999;">Configurable</sup> Limit the chunks loaded and ticked by the server based on the client view distance.
    </li>
    <li>
        Ignore too high client view distances, instead of kicking the player.
    </li>
    <li>
        <sup style="color: #999999;">Configurable</sup> Fairly adapt the maximum view distances of all players automatically based on each player's client view distance and the configured total number of chunks the server can handle.
    </li>
</ul>


<ul>
    <b>Mask short TPS dips</b>
    <br>
    <sup style="color: #999999;">Configurable</sup> Set a custom TPS catch-up time (to temporarily perform ticks faster than 20 TPS after TPS goes below 20).
</ul>
<ul>
    <b>Better async thread usage</b>
    <br>
    Multithreading environment variables (add to your command line as follows: <code>java -Dsuki.systemcpus.forexecutors=4 -jar server.jar</code>):
    <ul>
        <li>
            <code>suki.systemcpus.forexecutors</code>
            <br>
            &nbsp;&nbsp;&nbsp;&nbsp;The number of CPU cores assumed for the main thread and async chunk loading combined
            <br>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<i>Default</i>: number of CPU threads / 2
            <br>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<i>Recommended</i>: number of CPU cores
        </li>
        <li>
            <code>suki.threads.asyncexecutor</code>
            <br>
            &nbsp;&nbsp;&nbsp;&nbsp;The number of threads used by the async task executor
            <br>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<i>Default</i>: 4
            <br>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<i>Recommended</i>: minimum the number of CPU cores, maximum the number of CPU threads
        </li>
        <li>
            <code>suki.threads.tracker</code>
            <br>
            &nbsp;&nbsp;&nbsp;&nbsp;The number of threads used by the async entity tracker
            <br>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<i>Default</i>: 4
            <br>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<i>Recommended</i>: minimum the number of CPU cores, maximum the number of CPU threads
        </li>
        <li>
            <code>suki.threads.upgradeworld</code>
            <br>
            &nbsp;&nbsp;&nbsp;&nbsp;The number of threads used to upgrade chunks from older versions
            <br>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<i>Default</i>: number of CPU threads * &frac38;
            <br>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<i>Recommended</i>: minimum 1, approximately half the number of CPU cores
        </li>
        <li>
            <code>suki.threads.levelexecutor</code>
            <br>
            &nbsp;&nbsp;&nbsp;&nbsp;(Not recommended) The number of threads to execute tasks when a chunk is loaded for a world, or -1 to disable this feature
            <br>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<i>Default</i>: -1
            <br>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<i>Recommended</i>: -1
        </li>
    </ul>
</ul>

#### Content

<ul>
    <b>Additions</b>
    <li>
        Debug stick can be used in survival mode (with a permission) for a limited number of block properties, such as changing the visual <code>lit</code> state of a furnace or the rotation of logs or stairs. (Permission <code>bukkit.debugstick.survivallike</code> - default <code>false</code>)
    </li>
    <li>
        Banners and other items/blocks can be placed directly into the head slot. (Permissions <code>bukkit.moreitemsonhead.banner</code>, <code>bukkit.moreitemsonhead.all</code> - default <code>false</code>)
    </li>
    <li>
        <sup style="color: #999999;">Configurable</sup> Bone meal can be used on stripped logs to grow back their bark.
    </li>
</ul>

<ul>
    <b>Changes</b>
    <li>
        <sup style="color: #999999;">Configurable</sup> Strongholds can <a href="https://cdn.discordapp.com/attachments/363647799373463562/990000668611854357/2022-06-24_23.07.08.png">spawn above ground</a>, are bigger and are more challenging with webs, holes and water.
    </li>
    <li>
        <sup style="color: #999999;">Configurable</sup> Gameplay difficulty changes:
        <ul>
            <li>Zombies can call for reinforcements on all difficulties.</li>
            <li>All raids are hard (so they contain evokers).</li>
            <li>Cave spiders can have poison on easy difficulty.</li>
            <li>Wither skulls can give the wither effect on easy difficulty.</li>
            <li>Prevent lightning from spawning fire.</li>
            <li>Set the minimum health left after starving.</li>
            <li>Spiders can spawn with potion effects on all difficulties.</li>
            <li>Set the gossip (reputation) change for player-villager interactions.</li>
            <li>Players can share positive villager gossips.</li>
        </ul>
    </li>
    <li>
        Enchantment compatibilities:
        <ul>
            <li>Looting on a Bow, Crossbow and Trident</li>
            <li>Protection and Thorns on an Elytra</li>
        </ul>
    </li>
</ul>

#### Miscellaneous

<ul>
    <b>Privacy for administrators</b>
    <li>
        <sup style="color: #999999;">Configurable</sup> Hide player's game modes from others. (Permission <code>bukkit.seerealgamemodes</code> - default <code>op</code>)
    </li>
    <li>
        <sup style="color: #999999;">Configurable</sup> Adds permissions to see plugins in <code>/plugins</code>: <code>bukkit.seeplugin.&lt;alphanumeric lowercase plugin name&gt;</code>, for example <code>bukkit.seeplugin.deleteoffline5</code> for a plugin called "DeleteOffline5%". Defaults to <code>op</code>. Players with <code>bukkit.seeplugin.*</code> (default <code>op</code>) can see all plugins.
    </li>
</ul>

<ul>
    <b>Additional logging</b>
    <br>
    <sup style="color: #999999;">Configurable</sup> Log login protocol packets.
</ul>

<ul>
<b>No chunk relocations</b>
<br>
Prevents staggered terrain after data corruption.
</ul>

<ul>
    <b>No signed chat</b>
    <br>
    Signed chat is removed. (All messages are system chat and there is no <code>[NOT SECURE]</code> marker in the console.)
</ul>

## Building

You can clone this repository and build it yourself.
If you are interested in making a fork, check out this template [there](https://github.com/PaperMC/paperweight-examples)!

In order to distribute and use this server software, you need a paperclip file:

```bash
./gradlew applyPatches && ./gradlew createReobfPaperclipJar
```

<span style="line-height: 26pt;">Configuration options for Suki:</span>
&nbsp;&nbsp;&nbsp;<span style="font-size: 16pt; line-height:12pt;">&bull;</span>&nbsp;&nbsp;Global configuration: in `config/paper-global.yml`<br>&nbsp;&nbsp;&nbsp;<span style="font-size: 16pt; line-height:12pt;">&bull;</span>&nbsp;&nbsp;Per-world configuration: defaults in `config/paper-world-defaults.yml` and specific overrides for a world in `<world>/paper-world.yml`

## License
Patches are licensed under GPL-3.0.  
All other non-binary files are licensed under MIT.
No license is given for binary files; all copyright rights reserved.

Made with <span style="color: #e25555;">&#9829;</span> on Earth.
