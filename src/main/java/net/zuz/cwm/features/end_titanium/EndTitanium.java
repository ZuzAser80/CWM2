package net.zuz.cwm.features.end_titanium;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;
import net.zuz.cwm.features.CustomAxe;
import net.zuz.cwm.features.CustomHoe;
import net.zuz.cwm.features.CustomPick;

public class EndTitanium {
    public static Block END_TITANIUM_ORE_BLOCK = new Block(FabricBlockSettings.of(Material.STONE).hardness(4.0f).requiresTool().resistance(1.2F));
    public static Item END_TITANIUM_INGOT;
    public static void registry(ItemGroup g)
    {
        Block END_TITANIUM_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).hardness(4.0f).requiresTool().resistance(1.2F));
        Registry.register(Registry.BLOCK, new Identifier("cwm", "end_titanium_block"), END_TITANIUM_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("cwm", "end_titanium_block"), new BlockItem(END_TITANIUM_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

        //raw_end_titanium
        Registry.register(Registry.BLOCK, new Identifier("cwm", "end_titanium_ore"), END_TITANIUM_ORE_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("cwm", "end_titanium_ore"), new BlockItem(END_TITANIUM_ORE_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

        END_TITANIUM_INGOT = Registry.register(Registry.ITEM, new Identifier("cwm", "raw_end_titanium"), new Item(new Item.Settings().group(g)));
        Registry.register(Registry.ITEM, new Identifier("cwm", "end_titanium_ingot"), new Item(new Item.Settings().group(g)));

        Registry.register(Registry.ITEM, new Identifier("cwm", "end_titanium_shovel"), new ShovelItem(EndTitaniumMaterial.EndTitaniumMaterial, 1.6F, -1.0F, new Item.Settings().group(ItemGroup.TOOLS).rarity(Rarity.UNCOMMON).fireproof()));
        Registry.register(Registry.ITEM, new Identifier("cwm", "end_titanium_sword"), new SwordItem(EndTitaniumMaterial.EndTitaniumMaterial, 5, -2.5F, new Item.Settings().group(ItemGroup.COMBAT).rarity(Rarity.UNCOMMON).fireproof()));
        Registry.register(Registry.ITEM, new Identifier("cwm", "end_titanium_pickaxe"), new CustomPick(EndTitaniumMaterial.EndTitaniumMaterial, 3, 3.0F, new Item.Settings().group(ItemGroup.TOOLS).rarity(Rarity.UNCOMMON).fireproof()));
        Registry.register(Registry.ITEM, new Identifier("cwm", "end_titanium_axe"), new CustomAxe(EndTitaniumMaterial.EndTitaniumMaterial, 2, 1.25F, new Item.Settings().group(ItemGroup.TOOLS).rarity(Rarity.UNCOMMON).fireproof()));
        Registry.register(Registry.ITEM, new Identifier("cwm", "end_titanium_hoe"), new CustomHoe(EndTitaniumMaterial.EndTitaniumMaterial, 1, 1F, new Item.Settings().group(ItemGroup.TOOLS).rarity(Rarity.UNCOMMON).fireproof()));

    }
}
