package hure.client.keybind;

import org.lwjgl.glfw.GLFW;

import hure.client.network.ClientNetworks;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.input.Input;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import net.minecraft.client.option.KeyBinding;




public class keyBindings {
    public static KeyBinding HURE_KEY_BINDINGS_R = 
        new KeyBinding("key.hure_R",InputUtil.Type.KEYSYM,GLFW.GLFW_KEY_R,"category.hure");

    public static KeyBinding HURE_KEY_BINDINGS_G = 
        new KeyBinding("key.hure_G",InputUtil.Type.KEYSYM,GLFW.GLFW_KEY_G,"category.hure");

        public static KeyBinding HURE_KEY_BINDINGS_F = 
        new KeyBinding("key.hure_F",InputUtil.Type.KEYSYM,GLFW.GLFW_KEY_F,"category.hure");

    private static int pressTicks = 0;
    private static int pressFTicks = 0;
    private static int power = 0;


    public static void init(){

        KeyBindingHelper.registerKeyBinding(HURE_KEY_BINDINGS_R);
        KeyBindingHelper.registerKeyBinding(HURE_KEY_BINDINGS_G);
        KeyBindingHelper.registerKeyBinding(HURE_KEY_BINDINGS_F);

        ClientTickEvents.END_CLIENT_TICK.register(client ->{
            
            //R長押し isPressed,長押しじゃない時は wasPressedで、発火
            // if(!HURE_KEY_BINDINGS_R.isPressed()){
            //     isKeyPressed = true;
            //     pressTicks = 0;
            // }else{
            //     pressTicks++;
            //     client.player.sendMessage(Text.literal("長押し中：" + pressTicks),false);
            //     if(pressTicks >= 30){
            //         client.player.sendMessage(Text.literal("シャレーネパーンチ！"),false);
            //         pressTicks=0;
            //     }
            // }


            while(HURE_KEY_BINDINGS_G.wasPressed()){
                ClientNetworks.sendPressGKey();
            }

            if(!HURE_KEY_BINDINGS_F.isPressed()){
                pressFTicks = 0;
                if(power == 3){
                    power = 0;
                    ClientNetworks.sendPressF_3Key();
                }else if(power == 2){
                    power = 0;
                    ClientNetworks.sendPressF_2Key();
                }else if(power == 1){
                    power = 0;
                    ClientNetworks.sendPressF_1Key();
                }
            }else{
                pressFTicks++;
                // client.player.sendMessage(Text.literal("長押し中：" + pressTicks),false);
                if(pressFTicks >= 100){
                    if(pressFTicks == 100)client.player.sendMessage(Text.literal("チャージ：3(MAX)"),false);
                    power = 3;
                }else if(pressFTicks >= 50){
                    if(pressFTicks == 50)client.player.sendMessage(Text.literal("チャージ：2"),false);
                    power = 2;
                }else if(pressFTicks >= 1){
                    if(pressFTicks == 1)client.player.sendMessage(Text.literal("チャージ：1"),false);
                    power = 1;
                }
            }

        });
    }

}
