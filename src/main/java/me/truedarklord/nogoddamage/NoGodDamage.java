package me.truedarklord.nogoddamage;

import me.truedarklord.nogoddamage.events.damageEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class NoGodDamage extends JavaPlugin {

    @Override
    public void onEnable() {
        new damageEvent(this);
    }
    @Override
    public void onDisable() {}

}
