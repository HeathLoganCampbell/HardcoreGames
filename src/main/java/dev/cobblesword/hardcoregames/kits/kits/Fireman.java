package dev.cobblesword.hardcoregames.kits.kits;

import dev.cobblesword.hardcoregames.kits.KitBase;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Fireman extends KitBase
{
    public Fireman()
    {
        super("fireman", "Fireman", "Put out them fires boy");

        this.addItem(new ItemStack(Material.WATER_BUCKET));
    }
}
