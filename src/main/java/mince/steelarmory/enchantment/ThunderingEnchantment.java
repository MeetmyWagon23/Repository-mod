package mince.steelarmory.enchantment;

import mince.steelarmory.SteelArmory;
import mince.steelarmory.api.ChanceUtil;
import mince.steelarmory.mixin.LivingEntityAccessor;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.FireAspectEnchantment;
import net.minecraft.entity.*;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.*;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.registry.Registry;

public class ThunderingEnchantment extends Enchantment {
    protected ThunderingEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot[] slotTypes) {
        super(weight, type, slotTypes);
        Registry.register(Registry.ENCHANTMENT, SteelArmory.ID("thundering"), this);
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        return (super.isAcceptableItem(stack)
                && ((SwordItem) stack.getItem()).getMaterial() == ToolMaterials.NETHERITE)
                || stack.getItem() instanceof AxeItem;
    }

    @Override
    protected boolean canAccept(Enchantment other) {
        return !(other instanceof FireAspectEnchantment);
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (target instanceof LivingEntity le && user instanceof ServerPlayerEntity) {
            if (ChanceUtil.percentChance(100)) {
                LightningEntity lightningEntity = EntityType.LIGHTNING_BOLT.create(le.getEntityWorld());
                if (lightningEntity != null) {
                    lightningEntity.setCosmetic(true);
                    lightningEntity.refreshPositionAfterTeleport(le.getX(), le.getY(), le.getZ());
                }
                float enchantDamage = level * 1.0f;// set like this because i am lazy, read below.
                le.timeUntilRegen = 0;
                float lastDam = ((LivingEntityAccessor) le).getLastDamageTaken();
                if (le.damage(DamageSource.LIGHTNING_BOLT, enchantDamage)) {
                    le.getEntityWorld().playSound(null, le.getX(), le.getY(), le.getZ(), SoundEvents.ENTITY_LIGHTNING_BOLT_THUNDER, SoundCategory.WEATHER,
                            1.5f, 1.5f);
                    /*
                    Used for testing purposes, this helped us found the issue below.

                    user.sendMessage(Text.of("target health is " + le.getHealth()));
                    user.sendMessage(Text.of(String.valueOf(user.getClass())));

                     */
                }
                ((LivingEntityAccessor) le).setLastDamageTaken(lastDam + enchantDamage);
            }
            super.onTargetDamaged(user, target, level);
            /*
            mainhand and offhand is called twice, so this enchantment deals damage twice. EnchantmentHelper - OnTagetDamage method. go look at Arthropods dmg enchant so see.
                       \/
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (target instanceof LivingEntity livingEntity) {
            if (this.typeIndex == 2 && level > 0 && livingEntity.getGroup() == EntityGroup.ARTHROPOD) {
                int i = 20 + user.getRandom().nextInt(10 * level);
                livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, i, 3));
             */
        }
    }
}