package mince.moreweapons.init;

import mince.moreweapons.MoreWeapons;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ItemsInit {
    public static final Item STEEL_INGOT = new Item(new FabricItemSettings());

    public static void init() {
        Registry.register(Registry.ITEM, MoreWeapons.ID("steel_ingot"), STEEL_INGOT);

    }
}
