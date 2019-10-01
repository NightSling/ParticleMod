package net.chachy.particlemod.gui.helper;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.EnumChatFormatting;

public abstract class ParticleGuiScreen extends GuiScreen {

    /**
     * {@author asbyth} To make Gui's more fun (:
     */

    // Create a getter to get the center
    protected int getCenter() {
        return width / 2;
    }

    // Create a getter for the row positioning.
    protected int getRowPos(int rowNumber) {
        return 55 + rowNumber * 23;
    }

    // Create a getter for an "Enabled"/"Disabled" string at the end of an option.
    protected String getSuffix(final boolean enabled) {
        return enabled ? (EnumChatFormatting.GREEN + "Enabled") : (EnumChatFormatting.RED + "Disabled");
    }

}