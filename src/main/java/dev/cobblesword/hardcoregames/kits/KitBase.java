package dev.cobblesword.hardcoregames.kits;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.HashMap;
import java.util.Map;

@Getter @Setter
public class KitBase
{
    private String name;
    private String displayName;
    private String description;
    private boolean hidden = false;

    private HashMap<Integer, ItemStack> inventory = new HashMap<>();
    private ItemStack[] armor = new ItemStack[4];

    public KitBase(String name, String displayName, String description)
    {
        this.name = name;
        this.displayName = displayName;
        this.description = description;
    }

    public void setItem(int slot, ItemStack item)
    {
        this.inventory.put(slot, item);
    }

    public void addItem(ItemStack item)
    {
        for(int i = 0; i < 9 * 4; i++)
        {
            ItemStack oldItem = this.inventory.get(i);
            if(oldItem == null)
            {
                this.setItem(i, item);
                break;
            }
        }
    }

    public void onApply(Player player)
    {

    }

    public void applyKit(Player player)
    {
        PlayerInventory inv = player.getInventory();
        for (Map.Entry<Integer, ItemStack> entry : inventory.entrySet())
        {
            Integer key = entry.getKey();
            ItemStack value = entry.getValue();

            inv.setItem(key, value);
        }

        inv.setArmorContents(this.armor);

        this.onApply(player);
    }
}
