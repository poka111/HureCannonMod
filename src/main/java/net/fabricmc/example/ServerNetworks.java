package net.fabricmc.example;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.scoreboard.ScoreboardObjective;
import net.minecraft.text.Text;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World.ExplosionSourceType;
import net.minecraft.world.explosion.Explosion;
import net.minecraft.scoreboard.Scoreboard;

public class ServerNetworks {

    private static int pressTicks = 0;

    public static void init(){

        //Gキーを押したときの処理
        ServerPlayNetworking.registerGlobalReceiver(ExampleMod.id("press_g_key"), ((server,player,handler,buf,responseSender) -> {
            ScoreboardObjective scoreObject = player.getScoreboard().getObjective("hure");

            if(scoreObject != null){
                player.getScoreboard().getPlayerScore(player.getEntityName(), scoreObject).incrementScore(1);
            }
        }));

        //Fキーを押したときの処理
        ServerPlayNetworking.registerGlobalReceiver(ExampleMod.id("press_f_1key"), ((server,player,handler,buf,responseSender) -> {
            player.sendMessage(Text.literal("スキル発動(パワー1)"),false);
            double distance = 5.0;
            Vec3d lookDirection = player.getRotationVector();
            double x = player.getX() + lookDirection.getX() * distance;
            double y = player.getY() + lookDirection.getY() * distance;
            double z = player.getZ() + lookDirection.getZ() * distance;
            player.getEntityWorld().createExplosion(player, x, y, z, 5, false, ExplosionSourceType.TNT);
        }));

        ServerPlayNetworking.registerGlobalReceiver(ExampleMod.id("press_f_2key"), ((server,player,handler,buf,responseSender) -> {
            player.sendMessage(Text.literal("スキル発動(パワー2)"),false);
            Vec3d lookDirection = player.getRotationVector();
            double x1 = player.getX() + lookDirection.getX() * 5;
            double y1 = player.getY() + lookDirection.getY() * 5;
            double z1 = player.getZ() + lookDirection.getZ() * 5;
            double x2 = player.getX() + lookDirection.getX() * 10;
            double y2 = player.getY() + lookDirection.getY() * 10;
            double z2 = player.getZ() + lookDirection.getZ() * 10;
            player.getEntityWorld().createExplosion(player, x1, y1, z1, 10, false, ExplosionSourceType.TNT);
            player.getEntityWorld().createExplosion(player, x2, y2, z2, 10, false, ExplosionSourceType.TNT);
        }));

        ServerPlayNetworking.registerGlobalReceiver(ExampleMod.id("press_f_3key"), ((server,player,handler,buf,responseSender) -> {
            player.sendMessage(Text.literal("スキル発動(パワー3)"),false);
            Vec3d lookDirection = player.getRotationVector();
            double x1 = player.getX() + lookDirection.getX() * 5;
            double y1 = player.getY() + lookDirection.getY() * 5;
            double z1 = player.getZ() + lookDirection.getZ() * 5;
            double x2 = player.getX() + lookDirection.getX() * 20;
            double y2 = player.getY() + lookDirection.getY() * 20;
            double z2 = player.getZ() + lookDirection.getZ() * 20;
            player.getEntityWorld().createExplosion(player, x1, y1, z1, 30, false, ExplosionSourceType.TNT);
            player.getEntityWorld().createExplosion(player, x2, y2, z2, 30, false, ExplosionSourceType.TNT);
        }));
    }
}
