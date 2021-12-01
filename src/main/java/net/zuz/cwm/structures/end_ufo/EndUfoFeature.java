package net.zuz.cwm.structures.end_ufo;

import com.mojang.serialization.Codec;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.structure.v1.FabricStructureBuilder;
import net.minecraft.structure.MarginedStructureStart;
import net.minecraft.structure.StructureManager;
import net.minecraft.structure.StructurePieceType;
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
import net.minecraft.world.gen.feature.ConfiguredStructureFeature;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;

import static net.zuz.cwm.util.Helper.id;

public class EndUfoFeature extends StructureFeature<DefaultFeatureConfig> {

    public EndUfoFeature(Codec<DefaultFeatureConfig> codec) {
        super(codec);
    }

    public StructureStartFactory<DefaultFeatureConfig> getStructureStartFactory() {
        return EndUfoFeature.Start::new;
    }

    public static class Start extends MarginedStructureStart<DefaultFeatureConfig> {
        public Start(StructureFeature<DefaultFeatureConfig> structureFeature, ChunkPos chunkPos, int i, long l) {
            super(structureFeature, chunkPos, i, l);
        }

        @Override
        public void init(DynamicRegistryManager registryManager, ChunkGenerator chunkGenerator, StructureManager manager, ChunkPos pos, Biome biome, DefaultFeatureConfig config, HeightLimitView world) {
            int i = pos.getStartX();
            int j = pos.getStartZ();
            int k = 160;
            EndUfoGenerator.addPieces(manager, this, this.random, new BlockPos(i, k, j));
        }

    }
    public static StructurePieceType EndUfoPiece = EndUfoGenerator.MainPiece::new;
    public static void registry()
    {
        final StructureFeature<DefaultFeatureConfig> NETHER_SHIP_BOTTOM = new EndUfoFeature(DefaultFeatureConfig.CODEC);
        Registry.register(Registry.STRUCTURE_PIECE, id("end_ufo_piece"), EndUfoPiece);
        FabricStructureBuilder.create(id("end_ufo"), NETHER_SHIP_BOTTOM)
                .step(GenerationStep.Feature.SURFACE_STRUCTURES)
                .defaultConfig(256, 16, 13249)
                .adjustsSurface()
                .register();
        final ConfiguredStructureFeature<?, ?> MY_CONFIGURED = NETHER_SHIP_BOTTOM.configure(DefaultFeatureConfig.DEFAULT);
        RegistryKey<ConfiguredStructureFeature<?, ?>> myConfigured = RegistryKey.of(Registry.CONFIGURED_STRUCTURE_FEATURE_KEY, new Identifier("cmw", "end_ufo"));
        BuiltinRegistries.add(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, myConfigured.getValue(), MY_CONFIGURED);
        BiomeModifications.addStructure(BiomeSelectors.foundInTheEnd(), myConfigured);
    }
}
