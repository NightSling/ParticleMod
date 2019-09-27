package net.chachy.particlemod.handlers;

import cc.hyperium.event.EventBus;
import net.chachy.particlemod.handlers.handler.particle.ParticleHandler;
import net.chachy.particlemod.handlers.handler.update.UpdateHandler;

public class ParticleHandlers {
    /**
     * Class to keep handlers getters.
     */
    private static ParticleHandlers handlers = new ParticleHandlers();
    private static ParticleHandler particleHandler = new ParticleHandler();
    private static UpdateHandler updateHandler = new UpdateHandler();

    public ParticleHandler getParticleHandler() {
        return particleHandler;
    }

    public UpdateHandler getUpdateHandler() {
        return updateHandler;
    }

    public static ParticleHandlers getHandlers() {
        return handlers;
    }

    public void registerHandlers() {
        EventBus.INSTANCE.register(particleHandler);
        EventBus.INSTANCE.register(updateHandler);
    }
}
