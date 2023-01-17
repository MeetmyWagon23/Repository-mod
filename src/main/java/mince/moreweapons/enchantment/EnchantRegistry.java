package mince.moreweapons.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

    public class EnchantRegistry {

        public static Enchantment SMITING;

        public static void init() {
            SMITING = new ThunderingEnchantment(Enchantment.Rarity.RARE, EnchantmentTarget.WEAPON,
                    new EquipmentSlot[]{EquipmentSlot.MAINHAND});
        }
    }
