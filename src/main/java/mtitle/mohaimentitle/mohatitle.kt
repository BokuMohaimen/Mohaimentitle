package mtitle.mohaimentitle

import org.bukkit.Bukkit
import org.bukkit.Sound
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

var prefix = "§e§l[Mohatitle]§r"

object mohatitle {
    class mohatitle : CommandExecutor {
        object mohadice : CommandExecutor {
            override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
                val p = sender as Player
                if (args.isEmpty()) {
                    p.sendMessage("§e-----${prefix}§e-----")
                    p.sendMessage("")
                    p.sendMessage("§d/mtitle <main> <sub> <intime> <time> <outtime>")
                    p.sendMessage("")
                    p.sendMessage("§e---------------------")
                    return true
                }

                var main = ""
                var sub = ""
                var time = 60
                var Itime = 2
                var Otime = 2
                var mode = "main"
                for (i in args.indices) {
                    if (mode == "main") {
                        main = main + args[i].replace("&", "§")
                    }
                    if (mode == "sub") {
                        sub = sub + args[i].replace("&", "§")
                    }
                    if (mode == "Itime") {
                        try {
                            Itime = args[i].toInt() * 20
                        } catch (e: NumberFormatException) {
                            if (mode == "time") {
                                try {
                                    time = args[i].toInt() * 20
                                } catch (e: NumberFormatException) {
                                }
                            }
                        }
                    }
                    if (mode == "Otime") {
                        try {
                            Otime = args[i].toInt() * 20
                        } catch (e: NumberFormatException) {
                        }
                    }
                }






                for (player in Bukkit.getOnlinePlayers()) {
                    player.playSound(player.location, Sound.ENTITY_WITHER_SPAWN, 1f, 1f)
                    player.sendTitle(main, sub, Itime, time, Otime)
                }
            }
        }
    }
}