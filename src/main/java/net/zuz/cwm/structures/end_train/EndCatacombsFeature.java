package net.zuz.cwm.structures.end_train;

import com.mojang.serialization.Codec;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.structure.v1.FabricStructureBuilder;
import net.minecraft.structure.StructureGeneratorFactory;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;



import static net.zuz.cwm.util.Helper.*;

public class EndCatacombsFeature extends JigsawFeature {
    public EndCatacombsFeature(Codec<StructurePoolFeatureConfig> configCodec) {
        super(configCodec, 30, true, true, (context) -> {
            return true;
        });
    }

    
    //DO NOT TOUCH THIS SHIT
    public static void registry() {
        //values
        Identifier END_TRAIN_ID = id("end_catacombs");
        StructureFeature<StructurePoolFeatureConfig> END_TRAIN_FEATURE_CONFIG = new EndCatacombsFeature(StructurePoolFeatureConfig.CODEC);
        ConfiguredStructureFeature<StructurePoolFeatureConfig, ?> END_TRAIN_FEATURE =
                END_TRAIN_FEATURE_CONFIG.configure
                        (new StructurePoolFeatureConfig(() ->
                                EndCatacombsGenerator.POOL, 3));
        //registering stuff
        Registry.register(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, END_TRAIN_ID, END_TRAIN_FEATURE);
        FabricStructureBuilder.create(END_TRAIN_ID, END_TRAIN_FEATURE_CONFIG)
                .step(GenerationStep.Feature.UNDERGROUND_STRUCTURES)
                .defaultConfig(512, 32, 23449)
                .register();
        RegistryKey<ConfiguredStructureFeature<?, ?>> myConfigured = RegistryKey.of(Registry.CONFIGURED_STRUCTURE_FEATURE_KEY,
                END_TRAIN_ID);
        BiomeModifications.addStructure(BiomeSelectors.foundInTheEnd(), myConfigured);
        //adding it to end only, shall we?
    }
}
