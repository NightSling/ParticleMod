package net.chachy.particlemod;

import cc.hyperium.Hyperium;
import cc.hyperium.event.EventBus;
import cc.hyperium.event.InitializationEvent;
import cc.hyperium.event.InvokeEvent;
import cc.hyperium.internal.addons.IAddon;
import net.chachy.particlemod.commands.ParticleGuiCommand;
import net.chachy.particlemod.config.Configuration;
import net.chachy.particlemod.handlers.ParticleHandlers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ParticleMod implements IAddon {
    public static ParticleMod INSTANCE = new ParticleMod();
    /**
     * The Particle Mod Main class.
     */

    private static Logger LOGGER = LogManager.getLogger("ParticleAddon");
    public static String VERSION = "1.0";

    @Override
    public void onLoad() {
        EventBus.INSTANCE.register(this);

        LOGGER.info("Particle Mod has been initialized.");
    }

    @InvokeEvent
    public void init(InitializationEvent e) {
        Hyperium.INSTANCE.getHandlers().getHyperiumCommandHandler().registerCommand(new ParticleGuiCommand());
        Hyperium.CONFIG.register(new Configuration());
        ParticleHandlers.getHandlers().registerHandlers();
        LOGGER.info("Registered Config, Handlers and Command!");
    }

    @Override
    public void onClose() {
        LOGGER.info("Shutting down ParticleMod " + VERSION);
    }

    /**
     * Dev environment check
     */
    public boolean isDevEnvironment() {
        try {
            return Class.forName("net.minecraft.client.Minecraft").getDeclaredField("theMinecraft") != null;
        } catch (NoSuchFieldException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}
