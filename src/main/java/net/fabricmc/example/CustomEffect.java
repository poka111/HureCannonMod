package net.fabricmc.example;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;

public class CustomEffect extends StatusEffect{

    public CustomEffect() {
        super(StatusEffectCategory.BENEFICIAL, // whether beneficial or harmful for entities
        0x98D982);
    }

    @Override
    public boolean canApplyUpdateEffect(int duation,int amplifier){
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity,int amplifier){
       if(entity instanceof PlayerEntity){
        ((PlayerEntity) entity).addExperience(1 << amplifier);
       }
    }
    
}
