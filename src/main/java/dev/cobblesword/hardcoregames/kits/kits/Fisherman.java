package dev.cobblesword.hardcoregames.kits.kits;

import dev.cobblesword.hardcoregames.kits.KitBase;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Fisherman extends KitBase
{
    public Fisherman()
    {
        super("fisherman", "Fisherman", "Spawn with a fishing rod...");

        this.addItem(new ItemStack(Material.FISHING_ROD));
    }
}
