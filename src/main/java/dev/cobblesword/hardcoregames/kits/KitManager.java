package dev.cobblesword.hardcoregames.kits;

import dev.cobblesword.hardcoregames.HardcoreGamesPlugin;
import dev.cobblesword.hardcoregames.kits.kits.Fireman;
import dev.cobblesword.hardcoregames.kits.kits.Fisherman;
import dev.cobblesword.hardcoregames.kits.kits.Jumper;
import dev.cobblesword.hardcoregames.kits.kits.None;

import java.util.HashMap;

public class KitManager
{
    public static final KitBase NONE_KIT = new None();
    private HashMap<String, KitBase> kits = new HashMap<>();

    public KitManager(HardcoreGamesPlugin hardcoreGamesPlugin)
    {
        this.registerKit(NONE_KIT);
        this.registerKit(new Fireman());
        this.registerKit(new Fisherman());
        this.registerKit(new Jumper());
    }

    public void registerKit(KitBase kitBase)
    {
        this.kits.put(kitBase.getName(), kitBase);
    }

    public KitBase getKit(String kitName)
    {
        return this.kits.get(kitName);
    }
}
