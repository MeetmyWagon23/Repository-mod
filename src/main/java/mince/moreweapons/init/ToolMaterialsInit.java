package mince.moreweapons.init;

import mince.moreweapons.toolmaterials.BaseToolMaterial;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class ToolMaterialsInit {
    protected static final ToolMaterial STEEL =
            new BaseToolMaterial(2f, 20, 3, 7.0f, 500,
                    () -> Ingredient.ofItems(ItemsInit.STEEL_INGOT));

}
