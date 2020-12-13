package dev.cobblesword.hardcoregames.kits.kits;

import dev.cobblesword.hardcoregames.kits.KitBase;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Jumper extends KitBase
{
    public Jumper()
    {
        super("jumper", "Jumper", "Jumper to where you need");

        this.addItem(new ItemStack(Material.ENDER_PEARL));
    }
}
