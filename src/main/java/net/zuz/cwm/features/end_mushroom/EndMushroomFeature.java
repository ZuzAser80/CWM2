package net.zuz.cwm.features.end_mushroom;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.HeightmapDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.trunk.ForkingTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;
import net.zuz.cwm.mixin.FoliagePlacerTypeInvoker;

public class EndMushroomFeature {
    public static FoliagePlacerType<EndMushroomFoliagePlacer> RICH_FOLIAGE_PLACER;
    static EndMushroomSapling END_MUSHROOM_SAPLING;
    static ConfiguredFeature<?, ?> TREE_RICH = Feature.TREE
            // Configure the feature using the builder
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(Blocks.NETHERITE_BLOCK.getDefaultState()), // Trunk block provider
                    new ForkingTrunkPlacer(8, 3, 0), // places a straight trunk
                    new SimpleBlockStateProvider(Blocks.DIAMOND_BLOCK.getDefaultState()), // Foliage block provider
                    new SimpleBlockStateProvider(END_MUSHROOM_SAPLING.getDefaultState()), // Sapling provider; used to determine what blocks the tree can generate on
                    new EndMushroomFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), ConstantIntProvider.create(3)),
                    new TwoLayersFeatureSize(1, 0, 1) // The width of the tree at different layers; used to see how tall the tree can be without clipping into blocks
            ).build())
            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING)))
            .spreadHorizontally()
            .applyChance(3);
    private static RegistryKey<ConfiguredFeature<?, ?>> treeRich = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("cwm", "end_mushroom"));

 public static void registry()
 {
     RICH_FOLIAGE_PLACER = FoliagePlacerTypeInvoker.callRegister("end_mush_foliage_placer", EndMushroomFoliagePlacer.CODEC);
     END_MUSHROOM_SAPLING = new EndMushroomSapling(new EndMushroomSaplingGenerator(TREE_RICH),FabricBlockSettings.copyOf(Blocks.OAK_SAPLING));
     Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, treeRich.getValue(), TREE_RICH);
     Registry.register(Registry.BLOCK, new Identifier("tutorial", "rich_sapling"), END_MUSHROOM_SAPLING);
     Registry.register(Registry.ITEM, new Identifier("tutorial", "rich_sapling"), new BlockItem(END_MUSHROOM_SAPLING, new Item.Settings().group(ItemGroup.MISC)));
     // You should use the VEGETAL_DECORATION generation step for trees
     BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.VEGETAL_DECORATION, treeRich);
 }

}
