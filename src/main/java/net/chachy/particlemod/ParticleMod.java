package net.chachy.particlemod;

import cc.hyperium.Hyperium;
import cc.hyperium.event.InitializationEvent;
import cc.hyperium.event.InvokeEvent;
import cc.hyperium.internal.addons.IAddon;
import net.chachy.particlemod.command.ParticleGuiCommand;
import net.chachy.particlemod.config.Configuration;
import net.chachy.particlemod.handlers.ParticleHandlers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ParticleMod implements IAddon {
    /**
     * The Particle Mod Main class.
     *
     * @author chachy
     * @see cc.hyperium.internal.addons.IAddon
     */
    /**
     * Create an instance of this class for non-static methods.
     */
    public static ParticleMod INSTANCE = new ParticleMod();
    /**
     * Initialize the logger used for sending errors and general info to the logs
     *
     * @see LogManager
     */
    private static Logger LOGGER = LogManager.getLogger("ParticleAddon");
    /**
     * Create a version variable (used for {@link net.chachy.particlemod.handlers.handler.update.UpdateHandler}
     */
    public final String VERSION = "1.0";

    @Override
    public void onLoad() {
        // Tell the logs that the addon has been loaded
        LOGGER.info("Particle Addon has been initialized.");
    }

    @InvokeEvent
    public void init(InitializationEvent e) {
        // Register the Gui Command
        Hyperium.INSTANCE.getHandlers().getHyperiumCommandHandler().registerCommand(new ParticleGuiCommand());
        // Register the config to the client's config stored in hyperium/CONFIG.json
        Hyperium.CONFIG.register(new Configuration());
        ParticleHandlers.getHandlers().registerHandlers();
        LOGGER.info("Registered Config, Handlers and Command!");
    }

    @Override
    public void onClose() {
        // Save the config in case.
        Hyperium.CONFIG.save();
        // Tell the logs the mod is shutting down
        LOGGER.info("Shutting down ParticleMod " + VERSION);
    }

    /**
     * Dev environment check
     */
    public boolean isDevEnvironment() {
        try {
           // Check if the method Minecraft#theMinecraft is not null
            return Class.forName("net.minecraft.client.Minecraft").getDeclaredField("theMinecraft") != null;
        } catch (NoSuchFieldException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        // If an exception is thrown it automatically returns false;
        return false;
    }

    public void sendDebugToConsole(String debug) {
        // Used for debugging
        if (isDevEnvironment()) {
            // Check for the dev environment just in case someone pushes with a debug.
            LOGGER.debug(debug);
        }
    }
}
