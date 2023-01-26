package mince.steelarmory.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class EnchantRegistry {
    public static Enchantment THUNDERING;
    public static Enchantment POISONING;

    public static void init(){
        THUNDERING = new ThunderingEnchantment(Enchantment.Rarity.RARE, EnchantmentTarget.WEAPON,
                new EquipmentSlot[]{EquipmentSlot.MAINHAND});
        POISONING = new PoisoningEnchantment(Enchantment.Rarity.RARE, EnchantmentTarget.WEAPON,
                new EquipmentSlot[]{EquipmentSlot.MAINHAND});

    }
}
