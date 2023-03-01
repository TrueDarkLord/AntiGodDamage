package me.truedarklord.nogoddamage.events;

import com.earth2me.essentials.Essentials;
import io.lumine.mythic.bukkit.MythicBukkit;
import io.lumine.mythic.core.mobs.ActiveMob;
import me.truedarklord.nogoddamage.NoGodDamage;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class damageEvent implements Listener {

    private final NoGodDamage plugin;
    private final Essentials essentialsX;

    public damageEvent(NoGodDamage Plugin) {
        this.plugin = Plugin;
        essentialsX = (Essentials) plugin.getServer().getPluginManager().getPlugin("Essentials");
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event) {
        if ((!(event.getDamager() instanceof Player p))) return;

        ActiveMob mythicMob = MythicBukkit.inst().getMobManager().getActiveMob(event.getEntity().getUniqueId()).orElse(null);

        if (essentialsX != null && essentialsX.getUser(p.getUniqueId()).isGodModeEnabled() && mythicMob != null) {
            event.setCancelled(true);
        }
    }
}
