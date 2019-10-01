package net.chachy.particlemod.command;

import cc.hyperium.Hyperium;
import cc.hyperium.commands.BaseCommand;
import net.chachy.particlemod.config.Configuration;
import net.chachy.particlemod.gui.ParticleModGui;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ParticleGuiCommand implements BaseCommand {
    /**
     * Command class which is registered in {@link net.chachy.particlemod.ParticleMod}
     *
     * @see BaseCommand
     */

    // Register the command name.
    @Override
    public String getName() {
        return "particlemod";
    }


    // Register the command usage.
    @Override
    public String getUsage() {
        return "/" + getName();
    }

    @Override
    public List<String> getCommandAliases() {
        // Aliases for the mod but since there is only one we use a singletonList.
        return Collections.singletonList("particleaddon");
    }

    @Override
    public void onExecute(String[] args) {
        // Check if there isn't any args or if the args in the command do not equal to "value"
        if (args.length == 0 || !args[0].equalsIgnoreCase("value")) {
            // Show the gui.
            Hyperium.INSTANCE.getHandlers().getGuiDisplayHandler().setDisplayNextTick(new ParticleModGui());
        } else {
            // Show the value if the args equal "value"
            Hyperium.INSTANCE.getHandlers().getGeneralChatHandler().sendMessage("The multiplier is at " + Configuration.INSTANCE.getMultiplier());
        }
    }

    @Override
    public List<String> onTabComplete(String[] args) {
        // Complete the command being typed to the full command when once of these patterns are picked up.
        return Arrays.asList("particlem", "particl", "particlead", "ad", "mo");
    }
}
