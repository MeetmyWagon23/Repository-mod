package mince.steelarmory;

import mince.steelarmory.enchantment.EnchantRegistry;
import mince.steelarmory.init.ItemsInit;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SteelArmory implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "steelarmory";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static Identifier ID(String name){
		return new Identifier(MOD_ID, name);
	}
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
		EnchantRegistry.init();
		ItemsInit.weaponsInit();
		ItemsInit.toolsInit();
		ItemsInit.itemsInit();
		ItemsInit.armorsInit();
	}
}
