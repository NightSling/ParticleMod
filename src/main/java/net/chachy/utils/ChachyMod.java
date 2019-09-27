package net.chachy.utils;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import net.chachy.modutils.http.HttpUtils;

import java.io.IOException;

public class ChachyMod {
    public static ChachyMod INSTANCE = new ChachyMod();

    public boolean isLatestVersion(String name, String version) throws IOException {
        return new JsonParser().parse(HttpUtils.get("https://api.chachy.tk/get/mod/" + name)).getAsJsonObject().get("latest_version").getAsString().equalsIgnoreCase(version);
    }

    public JsonElement parseJson(String url) {
        try {
            return new JsonParser().parse(HttpUtils.get(url));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
