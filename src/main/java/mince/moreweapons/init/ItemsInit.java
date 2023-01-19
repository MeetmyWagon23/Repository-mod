package mince.moreweapons.init;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ItemsInit implements ModInitializer {
    public static final Item STEEL_INGOT = new Item(new FabricItemSettings());
    @Override
    public void onInitialize() {
        Registry.register(Registry.REGISTRIES.ITEM, new Identifier("mod_id", "steel_ingot"), STEEL_INGOT);

    }
}
