package mince.moreweapons.client;

import mince.moreweapons.init.ItemsInit;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;


@Environment(EnvType.CLIENT)
public class MoreWeaponsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        registerBowPredicates(ItemsInit.STEEL_BOW);
    }

    private static void registerBowPredicates(Item steelBow) {
        ModelPredicateProviderRegistry.register(steelBow, new Identifier("pull"), ((stack, world, entity, seed) -> {
            if (entity == null) {
                return 0f;
            } else {
                return entity.getActiveItem() != stack ? 0f : (stack.getMaxUseTime() - entity.getItemUseTimeLeft()) / 20f;
            }
        }));
        ModelPredicateProviderRegistry.register(steelBow, new Identifier("pulling"), ((stack, world, entity, seed) ->
                entity != null && entity.isUsingItem() && entity.getActiveItem().isOf(stack.getItem()) ? 1f : 0f));
    }
}

