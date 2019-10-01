package net.chachy.particlemod.handlers.handler.update;

import cc.hyperium.Hyperium;
import cc.hyperium.event.EntityJoinWorldEvent;
import cc.hyperium.event.InvokeEvent;
import cc.hyperium.event.ServerJoinEvent;
import net.chachy.particlemod.ParticleMod;
import net.chachy.particlemod.config.Configuration;
import net.chachy.utils.ChachyMod;
import net.minecraft.client.Minecraft;

public class UpdateHandler {
    /**
     * Fire update messages if they aren't updated.
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
        Hyperium.INSTANCE.getHandlers().getGeneralChatHandler().sendMessage(
                "A new version of Particle Addon is out! Get it at https://api.chachy.tk/download/ParticleAddon/" + ChachyMod.INSTANCE.getVersion("ParticleAddon"));
    }
}
