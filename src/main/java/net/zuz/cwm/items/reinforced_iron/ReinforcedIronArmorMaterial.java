package net.zuz.cwm.items.reinforced_iron;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static net.zuz.cwm.util.Helper.id;

public class ReinforcedIronArmorMaterial implements ArmorMaterial {
    private static final int[] BASE_DURABILITY = new int[] {13, 15, 16, 11};
    private static final int[] PROTECTION_VALUES = new int[] {4, 6, 7, 3};
    public static Item REINFORCED_IRON_INGOT;
    @Override
    public int getDurability(EquipmentSlot slot) {
        return BASE_DURABILITY[slot.getEntitySlotId()] * 25;
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return PROTECTION_VALUES[slot.getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
        return 3;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_IRON;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(REINFORCED_IRON_INGOT);
    }

    @Override
    public String getName() {
        // Must be all lowercase
        return "reinforced_iron";
    }

    @Override
    public float getToughness() {
        return 2.1F;
    }

    @Override
    public float getKnockbackResistance() {
        return 0F;
    }
    public static void registry(ItemGroup materials, ItemGroup armor)
    {
        ArmorMaterial REINFORCED_IRON = new ReinforcedIronArmorMaterial();
        REINFORCED_IRON_INGOT = Registry.register(Registry.ITEM, id("reinforced_iron_ingot"), new Item(new Item.Settings().group(materials)));
        ArmorItem REINFORCED_IRON_HELMET = Registry.register(Registry.ITEM, id("reinforced_iron_helmet"), new ArmorItem(REINFORCED_IRON, EquipmentSlot.HEAD, (new Item.Settings()).group(armor)));
        ArmorItem REINFORCED_IRON_CHESTPLATE = Registry.register(Registry.ITEM, id("reinforced_iron_chestplate"), new ArmorItem(REINFORCED_IRON, EquipmentSlot.CHEST, (new Item.Settings()).group(armor)));
        ArmorItem REINFORCED_IRON_LEGGINGS = Registry.register(Registry.ITEM, id("reinforced_iron_leggings"), new ArmorItem(REINFORCED_IRON, EquipmentSlot.LEGS, (new Item.Settings()).group(armor)));
        ArmorItem REINFORCED_IRON_BOOTS = Registry.register(Registry.ITEM, id("reinforced_iron_boots"), new ArmorItem(REINFORCED_IRON, EquipmentSlot.FEET, (new Item.Settings()).group(armor)));
    }
}
