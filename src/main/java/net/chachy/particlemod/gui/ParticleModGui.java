package net.chachy.particlemod.gui;

import cc.hyperium.Hyperium;
import net.chachy.particlemod.config.Configuration;
import net.chachy.particlemod.gui.helper.ParticleGuiScreen;
import net.minecraft.client.gui.GuiButton;
import net.minecraftforge.fml.client.config.GuiSlider;

public class ParticleModGui extends ParticleGuiScreen {
    // Initialize the config instance as a variable.
    private Configuration config = Configuration.INSTANCE;
    // Initialize the slider as a variable so it can be used across the class.
    private GuiSlider sliderScale;


    @Override
    public void initGui() {
        // Create a button to toggle the mod.
        this.buttonList.add(new GuiButton(1, this.getCenter() - 75, this.getRowPos(1), 150, 20, getSuffix(config.isEnabled())));
        // Create a button to initialize the slider variable.
        this.buttonList.add(sliderScale = new GuiSlider(2, this.getCenter() - 75, this.getRowPos(2),
                150, 20, "Particle Multiplier: ", "", 1.0, 100.0, config.getMultiplier(), false, true));
        // Create a button to toggle the Multiply without Critical option.
        this.buttonList.add(new GuiButton(3, this.getCenter() - 75, this.getRowPos(3), 150, 20, "Always Multiply: " + getSuffix(config.isMultiplyWithoutCrits())));
        // Create a button to toggle the Multiply on Animals option.
        this.buttonList.add(new GuiButton(4, this.getCenter() - 75, this.getRowPos(4), 150, 20, "Multiply on Animals: " + getSuffix(config.isMultiplyOnAnimals())));
        // Create a button to toggle the Update messages option.
        this.buttonList.add(new GuiButton(5, this.getCenter() - 75, this.getRowPos(5), 150, 20, "Update Messages: " + getSuffix(config.showUpdateMessages())));
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        // Create a tint behind the background
        this.drawWorldBackground(1);
        // Draw text onto the screen reading "Particle Addon" in the center of the rows.
        drawCenteredString(mc.fontRendererObj, "Particle Addon", getCenter(), getRowPos(0), -1);
        // Draw the screen.
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void actionPerformed(GuiButton button) {
        switch (button.id) {
            case 1:
                // Set the boolean to enabled/disabled and change the text.
                config.setEnabled(!config.isEnabled());
                button.displayString = getSuffix(config.isEnabled());
                break;
            case 3:
                // Set the boolean to enabled/disabled and change the text.
                config.setMultiplyWithoutCrits(!config.isMultiplyWithoutCrits());
                button.displayString = "Always Multiply: " + getSuffix(config.isMultiplyWithoutCrits());
                break;
            case 4:
                // Set the boolean to enabled/disabled and change the text.
                config.setMultiplyOnAnimals(!config.isMultiplyOnAnimals());
                button.displayString = "Multiply on Animals: " + getSuffix(config.isMultiplyOnAnimals());
                break;
            case 5:
                // Set the boolean to enabled/disabled and change the text.
                config.setUpdateMessages(!config.showUpdateMessages());
                button.displayString = "Update Messages: " + getSuffix(config.showUpdateMessages());
                break;
        }
    }

    @Override
    public void onGuiClosed() {
        // Set the sliderValue in the Configuration to it's current value
        config.multiplier = this.sliderScale.getValueInt();
        // Save the configuration.
        Hyperium.CONFIG.save();
    }

    @Override
    public boolean doesGuiPauseGame() {
        // Make sure the game doesn't pause when the gui opens.
        return false;
    }
}
