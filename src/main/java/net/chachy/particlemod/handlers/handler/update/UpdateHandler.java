package net.chachy.particlemod.handlers.handler.update;

import cc.hyperium.event.EntityJoinWorldEvent;
import cc.hyperium.event.InvokeEvent;
import cc.hyperium.event.ServerJoinEvent;
import net.chachy.particlemod.ParticleMod;
import net.chachy.particlemod.config.Configuration;
import net.chachy.utils.ChachyMod;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;

import java.io.IOException;

import static cc.hyperium.utils.ChatColor.*;

public class UpdateHandler {
    /**
     * Fire update messages if they aren't updated, currently disabled due to it not being on my api yet.
     */
    private final boolean isLatestVersion = ChachyMod.INSTANCE.isLatestVersion("ParticleAddon", ParticleMod.VERSION);

    @InvokeEvent
    public void onWorldJoin(EntityJoinWorldEvent event) {
        if (event.getEntity() == Minecraft.getMinecraft().thePlayer && Configuration.INSTANCE.showUpdateMessages() && !isLatestVersion)  {
            sendUpdateMessage();
        }

    }

    @InvokeEvent
    public void onServerJoin(ServerJoinEvent event) {
        if (Configuration.INSTANCE.showUpdateMessages() && !isLatestVersion) {
            sendUpdateMessage();
        }

    }


    private void sendUpdateMessage() {
        String prefix = DARK_AQUA + "[" + AQUA + BOLD + "ParticleAddon" + DARK_AQUA + "] " + WHITE + "";
        Minecraft.getMinecraft().thePlayer.addChatMessage(
                new ChatComponentText(
                        prefix +
                                "A new version of Particle Addon is out! \n " +
                                "Get it at https://api.chachy.tk/download/ParticleAddon/"
                                + ChachyMod.INSTANCE.parseJson("https://api.chachy.tk/get/mod/ParticleAddon").getAsJsonObject().get("version").getAsString()));
    }
}
