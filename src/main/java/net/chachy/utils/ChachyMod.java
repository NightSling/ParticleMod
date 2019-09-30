package net.chachy.utils;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import net.chachy.modutils.http.HttpUtils;
import net.chachy.particlemod.ParticleMod;

import java.io.IOException;

public class ChachyMod {
    public static ChachyMod INSTANCE = new ChachyMod();

    public boolean isLatestVersion(String name, String version) {
        if (ParticleMod.INSTANCE.isDevEnvironment()) {
            return false;
        } else {
            try {
                return new JsonParser().parse(HttpUtils.get("https://api.chachy.tk/get/mod/" + name)).getAsJsonObject().get("latest_version").getAsString().equalsIgnoreCase(version);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }


    public JsonElement parseJson(String url) {
        try {
            return new JsonParser().parse(HttpUtils.get(url));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getVersion(String mod) {
        try {
            return new JsonParser().parse(HttpUtils.get("https://api.chachy.tk/get/mod/" + mod)).getAsJsonObject().get("version").getAsString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
