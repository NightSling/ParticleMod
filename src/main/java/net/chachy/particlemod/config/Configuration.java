package net.chachy.particlemod.config;

import cc.hyperium.config.ConfigOpt;

public class Configuration {
    /**
     * The configuration class.
     */

    /**
     * Initialize an instance of this class for non-static methods.
     */
    public static Configuration INSTANCE = new Configuration();

    // Create a boolean for enabling/disabling the mod.
    @ConfigOpt
    private boolean enabled = true;

    @ConfigOpt
    //
    // This variable has been marked as public due to the setter not setting the value correctly
    //
    // Create a integer for how many times the mod should multiply the particles.
    public int multiplier = 1;


    // Create a boolean for enabling/disabling the "Multiply On Animals" option.
    @ConfigOpt
    private boolean MULITPLY_ON_ANIMALS = false;

    // Create a boolean for enabling/disabling the "Multiply without Critical Hits" option.
    @ConfigOpt
    private boolean MULTIPLY_WITHOUT_CRITS = false;

    // Create a boolean for enabling/disabling update messages.
    @ConfigOpt
    private boolean UPDATE_MESSAGES = true;

    // Create a getter for the multiplier variable.
    public int getMultiplier() {
        return multiplier;
    }

    // Create a getter for the MULTIPLY_WITHOUT_CRITS variable since it's private.
    public boolean isMultiplyWithoutCrits() {
        return MULTIPLY_WITHOUT_CRITS;
    }

    // Create a setter for the MULTIPLY_WITHOUT_CRITS variable since it's private.
    public void setMultiplyWithoutCrits(boolean b) {
        this.MULTIPLY_WITHOUT_CRITS = b;
    }

    // Create a getter for the enabled variable since it's private.
    public boolean isEnabled() {
        return enabled;
    }

    // Create a setter for the enabled variable since it's private.
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    // Create a getter for the UPDATE_MESSAGES variable since it's private.
    public boolean showUpdateMessages() {
        return UPDATE_MESSAGES;
    }

    // Create a setter for the UPDATE_MESSAGES variable since it's private.
    public void setUpdateMessages(boolean update) {
        this.UPDATE_MESSAGES = update;
    }

    // Create a getter for the MULTIPLY_ON_ANIMALS variable since it's private.
    public boolean isMultiplyOnAnimals() {
        return MULITPLY_ON_ANIMALS;
    }

    // Create a setter for the MULTIPLY_ON_ANIMALS variable since it's private.
    public void setMultiplyOnAnimals(boolean b) {
        this.MULITPLY_ON_ANIMALS = b;
    }
}
