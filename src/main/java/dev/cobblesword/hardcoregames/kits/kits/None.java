package dev.cobblesword.hardcoregames.kits.kits;

import dev.cobblesword.hardcoregames.kits.KitBase;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class None extends KitBase
{
    public None()
    {
        super("none", "None", "Nothing to see here");

        this.setHidden(true);
    }
}
