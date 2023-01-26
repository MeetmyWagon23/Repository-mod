package mince.steelarmory.enchantment;

import mince.steelarmory.SteelArmory;
import net.minecraft.enchantment.DamageEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.registry.Registry;

public class PoisoningEnchantment extends Enchantment {
    protected PoisoningEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot[] slotTypes){
        super(weight, type, slotTypes);
        Registry.register(Registry.ENCHANTMENT, SteelArmory.ID("poisoning"), this);

    }

    @Override
    public int getMaxLevel() {
        return 3;
    }
    @Override
    protected boolean canAccept(Enchantment other) {
        return !(other instanceof DamageEnchantment);
    }
    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level){
        if(target instanceof LivingEntity livingEntity){
            livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 60 +(40*(level-1)), level-1, true, true));
        }
        super.onTargetDamaged(user, target, level);
    }
}
