package me.chachy.ClearCommand;

import cc.hyperium.event.*;
import cc.hyperium.internal.addons.IAddon;
import javafx.scene.layout.Priority;
import me.chachy.ClearCommand.mycommand.MyCommand;
import net.minecraft.client.Minecraft;

public class ClearCommand implements IAddon {


    @Override
    public void onLoad() {
        System.out.println("Sucesfully loaded Addon!");
        EventBus.INSTANCE.register(this);
    }
    @InvokeEvent(Priority.LOW)
    private void init(Initialization event){
    Hyperium.INSTANCE.getHandlers().getHyperiumCommandHandler().registerCommand(new MyCommand());
  }
    @InvokeEvent
    private void onChatMessage(ChatEvent event) {
        if(event.getChat().getUnformattedText().contains("secret message!")) {
            Minecraft.getMinecraft().toggleFullscreen();
        }
    }

    @Override
    public void onClose() {
        System.out.println("Closing...");
    }
}