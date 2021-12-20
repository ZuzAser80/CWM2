package net.zuz.cwm.structures.quarry;

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
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.ConfiguredStructureFeature;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.StructurePoolFeatureConfig;

import static net.zuz.cwm.util.Helper.id;

public class EndTowerFeature extends StructureFeature<StructurePoolFeatureConfig> {
    public EndTowerFeature(Codec<StructurePoolFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public StructureStartFactory<StructurePoolFeatureConfig> getStructureStartFactory() {
        return EndTowerFeature.Start::new;
    }
    public static class Start extends MarginedStructureStart<StructurePoolFeatureConfig> {
        public Start(StructureFeature<StructurePoolFeatureConfig> s, ChunkPos c, int i, long l) {
            super(s, c, i, l);
        }

        @Override
        public void init(DynamicRegistryManager registryManager, ChunkGenerator chunkGenerator, StructureManager manager, ChunkPos pos, Biome biome, StructurePoolFeatureConfig config, HeightLimitView world) {
            ///EndCatacombsGenerator.init();
            StructurePoolBasedGenerator.generate(
                    registryManager, config, PoolStructurePiece::new, chunkGenerator, manager,
                    new BlockPos(pos.getStartX(), 64, pos.getStartZ()),
                    this, this.random, true, false, world
            );
            this.setBoundingBoxFromChildren();
        }
    }
    
    //DO NOT TOUCH THIS SHIT
    public static void registry() {
        //values
        Identifier QUARRY_ID = id("end_castle");
        StructureFeature<StructurePoolFeatureConfig> QUARRY_FEATURE_CONFIG = new EndTowerFeature(StructurePoolFeatureConfig.CODEC);
        ConfiguredStructureFeature<StructurePoolFeatureConfig, ?> QUARRY_FEATURE =
                QUARRY_FEATURE_CONFIG.configure
                        (new StructurePoolFeatureConfig(() ->
                                EndTowerGenerator.POOL, 7));
        //registering stuff
        Registry.register(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, QUARRY_ID, QUARRY_FEATURE);
        FabricStructureBuilder.create(QUARRY_ID, QUARRY_FEATURE_CONFIG)
                .step(GenerationStep.Feature.UNDERGROUND_ORES)
                .defaultConfig(128, 16, 23449)
                .superflatFeature(QUARRY_FEATURE)
                .register();
        RegistryKey<ConfiguredStructureFeature<?, ?>> myConfigured = RegistryKey.of(Registry.CONFIGURED_STRUCTURE_FEATURE_KEY,
                QUARRY_ID);
        BiomeModifications.addStructure(BiomeSelectors.foundInTheEnd(), myConfigured);
        //adding it to end only, shall we?
    }
}
