package hure.client.network;

import net.fabricmc.example.ExampleMod;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.network.PacketByteBuf;

public class ClientNetworks{
    public static void init(){

    }

    public static void sendPressGKey(){
        ClientPlayNetworking.send(ExampleMod.id("press_g_key"),PacketByteBufs.empty());
    }

    public static void sendPressF_1Key(){
        ClientPlayNetworking.send(ExampleMod.id("press_f_1key"),PacketByteBufs.empty());
    }

    public static void sendPressF_2Key(){
        ClientPlayNetworking.send(ExampleMod.id("press_f_2key"),PacketByteBufs.empty());
    }

    public static void sendPressF_3Key(){
        ClientPlayNetworking.send(ExampleMod.id("press_f_3key"),PacketByteBufs.empty());
    }
}