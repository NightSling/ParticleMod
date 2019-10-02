package net.chachy.utils;

import com.google.gson.JsonParser;
import net.chachy.modutils.http.HttpUtils;
import net.chachy.particlemod.ParticleMod;

import java.io.IOException;
import java.util.Objects;

public class ChachyMod {
    /**
     * Initialize an instance of the class.
     */
    public static ChachyMod INSTANCE = new ChachyMod();

    public final boolean isLatestVersion(String mod, String version) {
        // Check if it is the dev environment then its instantly true due to them being able to change the version in ParticleMod#VERSION
        if (ParticleMod.INSTANCE.isDevEnvironment()) return true;
        // Check if the getVersion() string equals the VERSION variable.
        return Objects.requireNonNull(getVersion(mod)).equalsIgnoreCase(version);
    }


    public final String getVersion(String mod) {
        try {
            // Return the version member from my api.
            return new JsonParser().parse(HttpUtils.get("https://api.chachy.tk/get/mod/" + mod)).getAsJsonObject().get("version").getAsString();
        } catch (IOException e) {
            // Send a stacktrace to the log to say there was an error.
            e.printStackTrace();
        }
        // If an error is thrown use the version and act as if it's update to date. In case my api is down it would have crashed people.
        // TODO: if it throws an error, check every 10m until it responds with an accepted code.
        return ParticleMod.INSTANCE.VERSION;
    }
}
