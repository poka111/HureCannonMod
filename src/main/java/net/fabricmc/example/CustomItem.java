package net.fabricmc.example;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.World.ExplosionSourceType;

public class CustomItem extends Item {

    int y = -80;

    public CustomItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {

        for(double i=0; i < 50; i++){
        double distance = 5.0+i;
        Vec3d lookDirection = playerEntity.getRotationVector();
        double x = playerEntity.getX() + lookDirection.getX() * distance;
        double y = playerEntity.getY() + lookDirection.getY() * distance;
        double z = playerEntity.getZ() + lookDirection.getZ() * distance;

        world.createExplosion(playerEntity, x, y, z, 5, false, ExplosionSourceType.BLOCK);
        }

        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }

}
