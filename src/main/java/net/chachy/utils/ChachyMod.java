package net.chachy.utils;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import net.chachy.modutils.http.HttpUtils;
import net.chachy.particlemod.ParticleMod;

import java.io.IOException;
import java.util.Objects;

public class ChachyMod {
    /**
     * A simple class for mod utils
     */
    public static ChachyMod INSTANCE = new ChachyMod();

    public final boolean isLatestVersion(String mod, String version) {
        if (ParticleMod.INSTANCE.isDevEnvironment()) return true;
        return Objects.requireNonNull(getVersion(mod)).equalsIgnoreCase(version);
    }


    public JsonElement parseJson(String url) {
        try {
            return new JsonParser().parse(HttpUtils.get(url));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public final String getVersion(String mod) {
        try {
            return new JsonParser().parse(HttpUtils.get("https://api.chachy.tk/get/mod/" + mod)).getAsJsonObject().get("version").getAsString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
