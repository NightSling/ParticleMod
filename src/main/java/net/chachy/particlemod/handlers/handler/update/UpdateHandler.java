package net.chachy.particlemod.handlers.handler.update;

import cc.hyperium.event.EntityJoinWorldEvent;
import cc.hyperium.event.InvokeEvent;
import cc.hyperium.event.ServerJoinEvent;
import net.chachy.modutils.ChachyMod;
import net.chachy.particlemod.config.Configuration;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;

import java.io.IOException;

import static cc.hyperium.utils.ChatColor.*;

public class UpdateHandler {
    /**
     * Fire update messages if they aren't updated, currently disabled due to it not being on my api yet.
     */
    @InvokeEvent
    public void onWorldJoin(EntityJoinWorldEvent event) throws IOException {
        /*
        if (event.getEntity() == Minecraft.getMinecraft().thePlayer && Configuration.INSTANCE.showUpdateMessages()) {
            sendUpdateMessage();
        }
         */
    }

    @InvokeEvent
    public void onServerJoin(ServerJoinEvent event) throws IOException {
        /*
        if (Configuration.INSTANCE.showUpdateMessages()) {
            sendUpdateMessage();
        }
         */
    }


    public void sendUpdateMessage() throws IOException {
        String prefix = DARK_AQUA + "[" + AQUA + BOLD + "ParticleAddon" + DARK_AQUA + "] " + WHITE + "";
        Minecraft.getMinecraft().thePlayer.addChatMessage(
                new ChatComponentText(
                        prefix +
                                "A new version of Particle Addon is out! \n " +
                                "Get it at https://api.chachy.tk/static/downloads/ParticleAddon-"
                                + ChachyMod.parseJson("https://api.chachy.tk/get/mod/particleAddon/latestVersion").getAsJsonObject().get("version").getAsString()
                                + ".jar"));
    }
}
