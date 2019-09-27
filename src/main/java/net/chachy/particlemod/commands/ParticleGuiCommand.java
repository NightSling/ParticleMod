package net.chachy.particlemod.commands;

import cc.hyperium.Hyperium;
import cc.hyperium.commands.BaseCommand;
import net.chachy.particlemod.config.Configuration;
import net.chachy.particlemod.gui.ParticleModGui;

import java.util.Arrays;
import java.util.List;

public class ParticleGuiCommand implements BaseCommand {
    /**
     * Command class which is registered in {@link net.chachy.particlemod.ParticleMod}
     */
    @Override
    public String getName() {
        return "particlemod";
    }

    @Override
    public String getUsage() {
        return "/" + getName();
    }

    @Override
    public List<String> getCommandAliases() {
        return Arrays.asList("particlem", "partmod", "particleaddon", "partaddon", "particlea");
    }

    @Override
    public void onExecute(String[] args) {
        if (args.length == 0) {
            Hyperium.INSTANCE.getHandlers().getGuiDisplayHandler().setDisplayNextTick(new ParticleModGui());
        } else if (args[0].equalsIgnoreCase("value")) {
            Hyperium.INSTANCE.getHandlers().getGeneralChatHandler().sendMessage("The multiplier is at " + Configuration.INSTANCE.getMultiplier());
        }
    }

    @Override
    public List<String> onTabComplete(String[] args) {
        return Arrays.asList("particlem", "particl", "particlead", "ad", "mo");
    }
}
