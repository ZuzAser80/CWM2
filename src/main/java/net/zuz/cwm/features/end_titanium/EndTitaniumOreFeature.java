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
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

public class EndTitaniumOreFeature {
    public static void registry() {
        ConfiguredFeature<?, ?> ORE_END_TITANIUM = Feature.ORE
                .configure(new OreFeatureConfig(
                        new BlockMatchRuleTest(Blocks.END_STONE), // base block is endstone in the end biomes
                        EndTitanium.END_TITANIUM_ORE_BLOCK.getDefaultState(),
                        4))
                .uniformRange(YOffset.aboveBottom(10), YOffset.aboveBottom(60))
                .spreadHorizontally()
                .repeat(14);
        RegistryKey<ConfiguredFeature<?, ?>> oreGobberEnd = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
                new Identifier("cwm", "end_titanium_feature"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreGobberEnd.getValue(), ORE_END_TITANIUM);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES, oreGobberEnd);
    }
}
