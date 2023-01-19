package mince.moreweapons.init;

import mince.moreweapons.MoreWeapons;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.util.registry.Registry;


public class WeaponsInit {
    public static final SwordItem STEEL_SWORD = new SwordItem(ToolMaterialsInit.STEEL,7, -3.2f, new Item.Settings());
    public static void init() {
        Registry.register(Registry.ITEM, MoreWeapons.ID("steel_sword"), STEEL_SWORD);
    }
}