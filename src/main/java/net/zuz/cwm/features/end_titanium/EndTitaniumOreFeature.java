package net.zuz.cwm.features.end_titanium;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.CountPlacementModifier;
import net.minecraft.world.gen.decorator.HeightRangePlacementModifier;
import net.minecraft.world.gen.decorator.SquarePlacementModifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;

public class EndTitaniumOreFeature {
    private static ConfiguredFeature<?, ?> END_TITANIUM_ORE_CONFIGURED_FEATURE = Feature.ORE
            .configure(new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.END_STONE), // we use new BlockMatchRuleTest(Blocks.END_STONE) here
                    EndTitanium.END_TITANIUM_ORE_BLOCK.getDefaultState(),
                    9));

    public static PlacedFeature END_TITANIUM_ORE_PLACED_FEATURE = END_TITANIUM_ORE_CONFIGURED_FEATURE.withPlacement(
            CountPlacementModifier.of(20),
            SquarePlacementModifier.of(),
            HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(64)));
    public static void registry() {
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
                new Identifier("cwm", "end_titanium_ore"), END_TITANIUM_ORE_CONFIGURED_FEATURE);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier("cwm", "end_titanium_ore"),
                END_TITANIUM_ORE_PLACED_FEATURE);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES,
                RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                        new Identifier("cwm", "end_titanium_ore")));
    }
}
