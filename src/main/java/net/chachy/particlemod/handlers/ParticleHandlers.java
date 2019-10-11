package net.chachy.particlemod.handlers;

import cc.hyperium.event.EventBus;
import net.chachy.particlemod.ParticleMod;
import net.chachy.particlemod.handlers.handler.particle.ParticleHandler;
import net.chachy.particlemod.handlers.handler.update.UpdateHandler;
import net.chachy.particlemod.handlers.utils.Handler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParticleHandlers {
    // Create a private static initialization of the class
    private static ParticleHandlers INSTANCE = new ParticleHandlers();
    // Create a variable of the ParticleHandler class
    private ParticleHandler particleHandler = new ParticleHandler();
    // Create a variable of the UpdateHandler class
    private UpdateHandler updateHandler = new UpdateHandler();

    // Create a getter for the particleHandler variable.
    public ParticleHandler getParticleHandler() {
        return particleHandler;
    }

    // Create a getter for the updateHandler variable.
    public UpdateHandler getUpdateHandler() {
        return updateHandler;
    }

    // Create a getter for the INSTANCE variable.
    public static ParticleHandlers getHandlers() {
        return INSTANCE;
    }

    // Register handlers.
    public void registerHandler(Handler handler) {
       // Register handler to eventbus
        EventBus.INSTANCE.register(handler);
    }
}
