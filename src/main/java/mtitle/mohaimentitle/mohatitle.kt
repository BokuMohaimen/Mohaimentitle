package mtitle.mohaimentitle

import org.bukkit.Bukkit
import org.bukkit.Bukkit.getConsoleSender
import org.bukkit.Bukkit.getServer
import org.bukkit.Sound
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

var prefix = "§e§l[Mohatitle]§r"

object mohatitle:CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (args.isEmpty()) {
            sender.sendMessage("§e-----${prefix}§e-----")
            sender.sendMessage("")
            sender.sendMessage("§d/mtitle <main> <sub> <intime> <time> <outtime>")
            sender.sendMessage("§d[*]を使うと空白を入れれます")
            sender.sendMessage("")
            sender.sendMessage("§e---------------------")
            return true
        }

        var main = ""
        var sub = ""
        if(args.size>=1)main = args[0].replace("&","§").replace("*"," ")
        if(args.size>=2)sub = args[1].replace("&","§").replace("*"," ")
        var Itime = 2
        var time = 60
        var Otime = 2
        try {
            if(args.size>=3)Itime = args[2].toInt() * 20
            if(args.size>=4)time = args[3].toInt() * 20
            if(args.size>=5)Otime = args[4].toInt() * 20
        } catch (e: NumberFormatException) {
            //時間が数字じゃない！
            return true
        }
        for (player in Bukkit.getOnlinePlayers()) {
            player.playSound(player.location, Sound.ENTITY_WITHER_SPAWN, 1f, 1f)
            player.sendTitle(main, sub, Itime, time, Otime)
        }
        return false
    }
}