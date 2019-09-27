package net.chachy.particlemod.gui.helper;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.EnumChatFormatting;

public abstract class ParticleGuiScreen extends GuiScreen {

    /**
     * {@author asbyth} To make Gui's more fun (:
     */

    protected int getCenter() {
        return width / 2;
    }

    protected int getRowPos(int rowNumber) {
        return 55 + rowNumber * 23;
    }

    protected String getSuffix(final boolean enabled) {
        return enabled ? (EnumChatFormatting.GREEN + "Enabled") : (EnumChatFormatting.RED + "Disabled");
    }

}