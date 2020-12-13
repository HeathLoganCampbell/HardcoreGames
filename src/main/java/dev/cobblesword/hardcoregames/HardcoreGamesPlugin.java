package dev.cobblesword.hardcoregames;

import dev.cobblesword.hardcoregames.commands.KitCommand;
import dev.cobblesword.hardcoregames.common.commands.CommandFramework;
import dev.cobblesword.hardcoregames.kits.KitManager;
import dev.cobblesword.hardcoregames.match.Match;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class HardcoreGamesPlugin extends JavaPlugin
{
    private CommandFramework commandFramework;
    private KitManager kitManager;
    private Match match;

    @Override
    public void onEnable()
    {
        this.commandFramework = new CommandFramework(this);
        this.kitManager = new KitManager(this);
        this.match = new Match();

        this.commandFramework.registerCommands(new KitCommand(this.kitManager));

        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, this.match, 20L, 20L);
    }

    @Override
    public void onDisable()
    {

    }
}
