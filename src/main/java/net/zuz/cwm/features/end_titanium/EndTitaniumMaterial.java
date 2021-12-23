package net.zuz.cwm.features.end_titanium;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class EndTitaniumMaterial implements ToolMaterial {
    public static EndTitaniumMaterial EndTitaniumMaterial = new EndTitaniumMaterial();
    @Override
    public int getDurability() {
        return 750;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 10;
    }

    @Override
    public float getAttackDamage() {
        return 5;
    }

    @Override
    public int getMiningLevel() {
        return 2;
    }

    @Override
    public int getEnchantability() {
        return 4;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(EndTitanium.END_TITANIUM_INGOT);
    }
}
