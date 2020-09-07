package mtitle.mohaimentitle

import org.bukkit.plugin.java.JavaPlugin

class MohaimenTitle : JavaPlugin() {

    override fun onEnable() {
        // Plugin startup logic
        getCommand("mtitle")?.setExecutor(mohatitle)
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}
