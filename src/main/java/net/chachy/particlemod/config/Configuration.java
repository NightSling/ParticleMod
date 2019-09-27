package net.chachy.particlemod.config;

import cc.hyperium.config.ConfigOpt;

public class Configuration {
    /**
     * The configuration class.
     */
    public static Configuration INSTANCE = new Configuration();
    @ConfigOpt
    private boolean enabled = true;

    @ConfigOpt
    //
    // This variable has been marked as public due to the setter not setting the value correctly
    //
    public int multiplier = 1;

    @ConfigOpt
    private boolean MULTIPLY_WITHOUT_CRITS = false;

    @ConfigOpt
    private boolean UPDATE_MESSAGES = true;

    public int getMultiplier() {
        return multiplier;
    }

    public boolean isMultiplyWithoutCrits() {
        return MULTIPLY_WITHOUT_CRITS;
    }

    public void setMultiplyWithoutCrits(boolean b) {
        this.MULTIPLY_WITHOUT_CRITS = b;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean showUpdateMessages() {
        return UPDATE_MESSAGES;
    }

    public void setUpdateMessages(boolean update) {
        this.UPDATE_MESSAGES = update;
    }
}
