package dev.cobblesword.hardcoregames;

import dev.cobblesword.hardcoregames.commands.KitCommand;
import dev.cobblesword.hardcoregames.common.commands.CommandFramework;
import dev.cobblesword.hardcoregames.kits.KitManager;
import org.bukkit.plugin.java.JavaPlugin;

public class HardcoreGamesPlugin extends JavaPlugin
{
    private CommandFramework commandFramework;
    private KitManager kitManager;

    @Override
    public void onEnable()
    {
        this.commandFramework = new CommandFramework(this);
        this.kitManager = new KitManager(this);

        this.commandFramework.registerCommands(new KitCommand(this.kitManager));
    }

    @Override
    public void onDisable()
    {

    }
}
