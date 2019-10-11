package net.chachy.modutils;

import com.google.gson.JsonParser;
import net.chachy.modutils.http.HttpUtils;
import net.chachy.modutils.utils.DevUtils;
import net.chachy.modutils.utils.Mod;

import java.io.IOException;
import java.util.Objects;

public class ChachyMod {
    private String API_URL = "https://api.chachy.co.uk";
    public static ChachyMod INSTANCE = new ChachyMod();

    public final boolean isLatestVersion(String mod, String version) {
        if (DevUtils.INSTANCE.isMinecraftDevelopmentEnvironment()) return true;
        return Objects.requireNonNull(getVersion(mod)).equalsIgnoreCase(version);
    }

    public final boolean isLatestVersion(Mod mod, String version) {
        if (DevUtils.INSTANCE.isMinecraftDevelopmentEnvironment()) return true;
        return Objects.requireNonNull(getVersion(mod)).equalsIgnoreCase(version);
    }


    public final String getVersion(Mod mod) {
        try {
            return new JsonParser().parse(HttpUtils.get("https://api.chachy.co.uk/get/mod/" + mod.getModName())).getAsJsonObject().get("version").getAsString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public final String getVersion(String endpoint, String mod) {
        try {
            return new JsonParser().parse(HttpUtils.get(API_URL + endpoint + mod)).getAsJsonObject().get("version").getAsString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public final String getVersion(String mod) {
        try {
            return new JsonParser().parse(HttpUtils.get("https://api.chachy.co.uk/get/mod/" + mod)).getAsJsonObject().get("version").getAsString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setApiUrl(String url) {
        if (url.contains("/")) {
            url = url.replace("/", "");
        }
        this.API_URL = url;
    }
}
