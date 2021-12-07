package net.zuz.cwm.structures.end_train;

import com.mojang.serialization.Codec;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.structure.v1.FabricStructureBuilder;
import net.minecraft.structure.MarginedStructureStart;
import net.minecraft.structure.PoolStructurePiece;
import net.minecraft.structure.StructureManager;
import net.minecraft.structure.pool.StructurePoolBasedGenerator;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.DynamicRegistryManager;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.HeightLimitView;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.*;



import static net.zuz.cwm.util.Helper.*;

public class EndCatacombsFeature extends StructureFeature<StructurePoolFeatureConfig> {
    public EndCatacombsFeature(Codec<StructurePoolFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public StructureStartFactory<StructurePoolFeatureConfig> getStructureStartFactory() {
        return EndCatacombsFeature.Start::new;
    }
    public static class Start extends MarginedStructureStart<StructurePoolFeatureConfig> {
        public Start(StructureFeature<StructurePoolFeatureConfig> s, ChunkPos c, int i, long l) {
            super(s, c, i, l);
        }

        @Override
        public void init(DynamicRegistryManager registryManager, ChunkGenerator chunkGenerator, StructureManager manager, ChunkPos pos, Biome biome, StructurePoolFeatureConfig config, HeightLimitView world) {
            StructurePoolBasedGenerator.generate(
                    registryManager, config, PoolStructurePiece::new, chunkGenerator, manager,
                    new BlockPos(pos.getStartX(), 60, pos.getStartZ()),
                    this, this.random, true, false, world
            );
            this.setBoundingBoxFromChildren();
        }
    }

    //DO NOT TOUCH THIS SHIT
    public static void registry() {
        //values
        Identifier END_TRAIN_ID = id("end_catacombs");
        StructureFeature<StructurePoolFeatureConfig> END_TRAIN_FEATURE_CONFIG = new EndCatacombsFeature(StructurePoolFeatureConfig.CODEC);
        ConfiguredStructureFeature<StructurePoolFeatureConfig, ?> END_TRAIN_FEATURE =
                END_TRAIN_FEATURE_CONFIG.configure
                        (new StructurePoolFeatureConfig(() -> EndCatacombsGenerator.POOL, 7));

        //registering stuff
        RegistryKey<ConfiguredStructureFeature<?, ?>> myConfigured = RegistryKey.of(Registry.CONFIGURED_STRUCTURE_FEATURE_KEY, END_TRAIN_ID);
        BuiltinRegistries.add(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, myConfigured.getValue(), END_TRAIN_FEATURE);

        FabricStructureBuilder.create(END_TRAIN_ID, END_TRAIN_FEATURE_CONFIG)
                .step(GenerationStep.Feature.UNDERGROUND_STRUCTURES)
                .defaultConfig(256, 16, 23449)
                .adjustsSurface()
                .register();
        BiomeModifications.addStructure(BiomeSelectors.foundInTheEnd(), myConfigured);
        //adding it to end only, shall we?
    }
}
