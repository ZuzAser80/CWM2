package net.zuz.cwm;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;
import net.zuz.cwm.items.materials.Materials;
import net.zuz.cwm.items.trinkets.WarriorSkull.WarriorSkullItem;

public class ItemTabs {

    private Identifier id(String name) {
        return new Identifier("cwm", name);
    }
    public static Item logo1;
    public static Item logo2;
    public static Item logo3;
    public static Item logo4;

    public static void logo()
    {
        logo1 = Registry.register(Registry.ITEM, new Identifier("cwm", "logo_1"), new Item(new Item.Settings()));
        logo2 = Registry.register(Registry.ITEM, new Identifier("cwm", "logo_2"), new Item(new Item.Settings()));
        logo3 = Registry.register(Registry.ITEM, new Identifier("cwm", "logo_3"), new Item(new Item.Settings()));
        logo4 = Registry.register(Registry.ITEM, new Identifier("cwm", "logo_4"), new Item(new Item.Settings()));
    }
    final ItemGroup weapons = FabricItemGroupBuilder.build(
            id("weapons"),
            () -> new ItemStack(logo1)
    );
    final ItemGroup trinkets = FabricItemGroupBuilder.build(
            id("trinkets"),
            () -> new ItemStack(logo2)
    );
    final ItemGroup materials = FabricItemGroupBuilder.build(
            id("materials"),
            () -> new ItemStack(logo3)
    );
    final ItemGroup armor = FabricItemGroupBuilder.build(
            id("armor"),
            () -> new ItemStack(logo4)
    );
    public ItemGroup getWeapons() {
        return weapons;
    }
    public ItemGroup getTrinkets() {
        return trinkets;
    }
    public ItemGroup getMaterials() {
        return materials;
    }
    public ItemGroup getArmor() {
        return armor;
    }


}
