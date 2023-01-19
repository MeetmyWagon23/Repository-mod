package mince.moreweapons.enchantment;

import mince.moreweapons.MoreWeapons;
import mince.moreweapons.api.ChanceUtil;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.*;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.registry.Registry;

public class SmitingEnchantment extends Enchantment {
    protected SmitingEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot[] slotTypes){
        super(weight, type, slotTypes);
        Registry.register(Registry.ENCHANTMENT, MoreWeapons.ID("smiting"), this);

    }
    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        LightningEntity lightingEntity = EntityType.LIGHTNING_BOLT.create(target.getEntityWorld());
        if (lightingEntity != null) {
            lightingEntity.setCosmetic(true);
            lightingEntity.refreshPositionAfterTeleport(target.getX(), target.getY(), target.getZ());
        }
        if (ChanceUtil.percentChance(30)) {
            LightningEntity lightningEntity = EntityType.LIGHTNING_BOLT.create(target.getEntityWorld());
            if (lightingEntity != null) {
                lightingEntity.setCosmetic(true);
                lightingEntity.refreshPositionAfterTeleport(target.getX(), target.getY(), target.getZ());
            }
            target.playSound(SoundEvents.ENTITY_LIGHTNING_BOLT_IMPACT, 1.0f, 1.0f);
            target.getEntityWorld().spawnEntity(lightingEntity);
            target.damage(DamageSource.LIGHTNING_BOLT, 18.0f);
        }
        target.playSound(SoundEvents.ENTITY_LIGHTNING_BOLT_IMPACT, 1.0f, 1.0f);
        target.getEntityWorld().spawnEntity(lightingEntity);
        target.damage(DamageSource.LIGHTNING_BOLT, 18.0f);

        super.onTargetDamaged(user, target, level);

    }
}
