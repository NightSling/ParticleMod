package net.chachy.modutils.utils;

public class DevUtils {
    public static DevUtils INSTANCE = new DevUtils();

    public boolean isMinecraftDevelopmentEnvironment() {
        try {
            return Class.forName("net.minecraft.client.Minecraft").getDeclaredField("theMinecraft") != null;
        } catch (ClassNotFoundException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        return false;
    }
}
