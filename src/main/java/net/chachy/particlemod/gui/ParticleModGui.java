package net.chachy.particlemod.gui;

import cc.hyperium.Hyperium;
import net.chachy.particlemod.config.Configuration;
import net.chachy.particlemod.gui.helper.ParticleGuiScreen;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.fml.client.config.GuiSlider;

public class ParticleModGui extends ParticleGuiScreen {
    private Configuration config = Configuration.INSTANCE;
    private GuiSlider sliderScale;
    private boolean MULTIPLY_WITHOUT_CRITS = config.isMultiplyWithoutCrits();



    @Override
    public void initGui() {
        this.buttonList.add(new GuiButton(1, this.getCenter() - 75, this.getRowPos(1), 150, 20, getEnabledSuffix()));
        this.buttonList.add(new GuiButton(3, this.getCenter() - 75, this.getRowPos(3), 150, 20, "Always Particles: " + getSuffix(MULTIPLY_WITHOUT_CRITS)));
        this.buttonList.add(new GuiButton(4, this.getCenter() - 75, this.getRowPos(4), 150, 20, "Update Messages: " + getSuffix(config.showUpdateMessages())));
        this.buttonList.add(sliderScale = new GuiSlider(2, this.getCenter() - 75, this.getRowPos(2), 150, 20, "Particle Multiplier: ", "", 1.0, 100.0, config.getMultiplier(), false, true));
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        drawCenteredString(fontRendererObj, "ParticleMod", getCenter(), getRowPos(1), 16777215);
        this.drawWorldBackground(1);
        super.drawScreen(mouseX, mouseY, partialTicks);

    }

    @Override
    protected void actionPerformed(GuiButton button) {
        switch (button.id) {
            case 1:
                config.setEnabled(!config.isEnabled());
                button.displayString = getEnabledSuffix();
                break;
            case 3:
                config.setMultiplyWithoutCrits(!config.isMultiplyWithoutCrits());
                button.displayString = "Always Particles: " + getSuffix(config.isMultiplyWithoutCrits());
                break;
            case 4:
                config.setUpdateMessages(!config.showUpdateMessages());
                button.displayString = "Update Messages: " + getSuffix(config.showUpdateMessages());
                break;
        }
}

    @Override
    public void onGuiClosed() {
        config.multiplier = this.sliderScale.getValueInt();
        System.out.println(config.getMultiplier());
        Hyperium.CONFIG.save();
    }

/**
     * Credit to {@author asbyth} for the row code, tooltips and row code. (Pretty much the whole code lmao)
     */


    /**
     *
     * Custom suffix
     * @return
     */
    private String getEnabledSuffix() {
        return config.isEnabled() ? ("Enabled: " + EnumChatFormatting.GREEN + "True") : ("Disabled: " + EnumChatFormatting.RED + "False");
    }
}
