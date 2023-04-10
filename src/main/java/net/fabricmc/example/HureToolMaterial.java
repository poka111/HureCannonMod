package net.fabricmc.example;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class HureToolMaterial implements ToolMaterial{

    public static final HureToolMaterial INSTANCE = new HureToolMaterial();

    @Override
    public int getDurability(){
        return 10000;
    }

    @Override
    public float getMiningSpeedMultiplier(){
        return 200.0F;
    }

    @Override
    public float getAttackDamage(){
        return 30.0F;
    }

    @Override
    public int getMiningLevel(){
        return 5;
    }

    @Override
    public int getEnchantability(){
        return 30;
    }

    @Override
    public Ingredient getRepairIngredient(){
        return Ingredient.ofItems(Items.DIAMOND);
    }
}