package net.chachy.particlemod.handlers.handler.update;

import cc.hyperium.Hyperium;
import cc.hyperium.event.EntityJoinWorldEvent;
import cc.hyperium.event.InvokeEvent;
import cc.hyperium.event.ServerJoinEvent;
import net.chachy.modutils.ChachyMod;
import net.chachy.particlemod.ParticleMod;
import net.chachy.particlemod.config.Configuration;
import net.chachy.particlemod.handlers.utils.Handler;
import net.minecraft.client.Minecraft;

public class UpdateHandler implements Handler {
    /**
     * Class used for handling if they're on the latest version.
     */

    @Override
    public String getHandlerName() {
        return "UpdateHandler";
    }

    // Initialize a final boolean to check if the mod is at it's latest version.
    private final boolean isLatestVersion = ChachyMod.INSTANCE.isLatestVersion(() -> "ParticleAddon", ParticleMod.INSTANCE.VERSION);

    /**
     * If the event {@link EntityJoinWorldEvent} is posted, it runs this method
     *
     * @see cc.hyperium.event.EventBus
     */
    @InvokeEvent
    public void onWorldJoin(EntityJoinWorldEvent event) {
        // Check if the entity joined is the player, the update messages option is enabled and isn't the latest version
        if (event.getEntity() == Minecraft.getMinecraft().thePlayer && Configuration.INSTANCE.showUpdateMessages() && !isLatestVersion)  {
            // Run the update message method.
            sendUpdateMessage();
        }

    }

    @InvokeEvent
    public void onServerJoin(ServerJoinEvent event) {
        // Check if update messages are enabled and isn't the latest version.
        if (Configuration.INSTANCE.showUpdateMessages() && !isLatestVersion) {
            // Run the update message method.
            sendUpdateMessage();
        }

    }

    private void sendUpdateMessage() {
        // Send a message using Hyperium#sendMessage() to tell the user a new version is out.
        Hyperium.INSTANCE.getHandlers().getGeneralChatHandler().sendMessage(
                "A new version of Particle Addon is out! Get it at https://api.chachy.tk/download/ParticleAddon/" + ChachyMod.INSTANCE.getVersion(() -> "ParticleAddon"));
    }
}
