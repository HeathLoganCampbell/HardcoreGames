package dev.cobblesword.hardcoregames;

import dev.cobblesword.hardcoregames.kits.KitManager;
import org.bukkit.plugin.java.JavaPlugin;

public class HardcoreGamesPlugin extends JavaPlugin
{
    private KitManager kitManager;

    @Override
    public void onEnable()
    {
        this.kitManager = new KitManager(this);
    }

    @Override
    public void onDisable()
    {

    }
}
