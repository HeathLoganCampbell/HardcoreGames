package dev.cobblesword.hardcoregames.commands;

import dev.cobblesword.hardcoregames.common.commands.Command;
import dev.cobblesword.hardcoregames.common.commands.CommandArgs;
import dev.cobblesword.hardcoregames.kits.KitBase;
import dev.cobblesword.hardcoregames.kits.KitManager;
import lombok.AllArgsConstructor;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.util.Map;

@AllArgsConstructor
public class KitCommand
{
    private KitManager kitManager;

    private void sendAllKitsMessage(CommandSender sender)
    {
        StringBuilder stringBuilder = new StringBuilder(ChatColor.WHITE + "Kits (?)" + ChatColor.GRAY + ": " );
        for (Map.Entry<String, KitBase> kitEntry : this.kitManager.getKitMap().entrySet())
        {
            KitBase kit = kitEntry.getValue();
            stringBuilder.append(ChatColor.GREEN).append(kit.getDisplayName()).append(ChatColor.WHITE).append(", ");
        }
        stringBuilder.setLength(stringBuilder.length() - 2);
        sender.sendMessage(stringBuilder.toString());
    }

    // /kit <KitName>
    @Command(name = "kit", aliases = { "kits" }, inGameOnly = true)
    public void kitCommand(CommandArgs args)
    {
        if (args.length() == 0)
        {
            this.sendAllKitsMessage(args.getSender());
            return;
        }

        String kitName = args.getArgs(0);
        KitBase kit = kitManager.getKit(kitName);
        if(kit == null)
        {
            args.getSender().sendMessage(ChatColor.RED + "'" + kitName + "' is not a valid kit name, type '/kits' to view all kits.");
            return;
        }

        kit.applyKit(args.getPlayer());
        args.getSender().sendMessage(ChatColor.GREEN + "Applied '" + kitName + "'!" );
    }
}
