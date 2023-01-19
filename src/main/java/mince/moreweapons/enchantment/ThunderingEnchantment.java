package mince.moreweapons.enchantment;

import mince.moreweapons.api.ChanceUtil;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.FireAspectEnchantment;
import net.minecraft.entity.*;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.registry.Registry;

    public class ThunderingEnchantment extends Enchantment {
        protected ThunderingEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot[] slotTypes) {
            super(weight, type, slotTypes);
            ThunderingEnchantment register = Registry.register(Registry.ENCHANTMENT, ("Thundering"), this);
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
            if (ChanceUtil.percentChance(50)) {
                LightningEntity lightningEntity = EntityType.LIGHTNING_BOLT.create(target.getEntityWorld());
                if (lightningEntity != null) {
                    lightningEntity.setCosmetic(true);
                    lightningEntity.refreshPositionAfterTeleport(target.getX(), target.getY(), target.getZ());
                }
                target.playSound(SoundEvents.ENTITY_LIGHTNING_BOLT_IMPACT, 1.0f, 1.0f);
                target.damage(DamageSource.LIGHTNING_BOLT, 6.0f);
            }
            super.onTargetDamaged(user, target, level);
        }
    }
