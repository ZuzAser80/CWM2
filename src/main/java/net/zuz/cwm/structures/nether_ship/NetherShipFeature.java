package net.zuz.cwm.structures.nether_ship;

import com.mojang.serialization.Codec;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.structure.v1.FabricStructureBuilder;
import net.minecraft.structure.*;
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

public class NetherShipFeature extends StructureFeature<DefaultFeatureConfig> {

    public NetherShipFeature(Codec<DefaultFeatureConfig> codec) {
        super(codec);
    }

    public StructureStartFactory<DefaultFeatureConfig> getStructureStartFactory() {
        return NetherShipFeature.Start::new;
    }

    public static class Start extends MarginedStructureStart<DefaultFeatureConfig> {
        public Start(StructureFeature<DefaultFeatureConfig> structureFeature, ChunkPos chunkPos, int i, long l) {
            super(structureFeature, chunkPos, i, l);
        }

        @Override
        public void init(DynamicRegistryManager registryManager, ChunkGenerator chunkGenerator, StructureManager manager, ChunkPos pos, Biome biome, DefaultFeatureConfig config, HeightLimitView world) {
            int i = pos.getStartX() + this.random.nextInt(16);
            int j = pos.getStartZ() + this.random.nextInt(16);
            int k = 200;
            NetherShipGenerator.addPieces(manager, this, this.random, new BlockPos(i, k, j));
        }

    }
    public static StructurePieceType NetherShipPiece = NetherShipGenerator.MainPiece::new;
    public static void registry()
    {
        final StructureFeature<DefaultFeatureConfig> NETHER_SHIP_BOTTOM = new NetherShipFeature(DefaultFeatureConfig.CODEC);
        Registry.register(Registry.STRUCTURE_PIECE, id("nether_ship_piece"), NetherShipPiece);
        FabricStructureBuilder.create(id("nether_ship"), NETHER_SHIP_BOTTOM)
                .step(GenerationStep.Feature.SURFACE_STRUCTURES)
                .defaultConfig(256, 16, 14245)
                .adjustsSurface()
                .register();
        final ConfiguredStructureFeature<?, ?> MY_CONFIGURED = NETHER_SHIP_BOTTOM.configure(DefaultFeatureConfig.DEFAULT);
        RegistryKey<ConfiguredStructureFeature<?, ?>> myConfigured = RegistryKey.of(Registry.CONFIGURED_STRUCTURE_FEATURE_KEY, new Identifier("cmw", "nether_ship"));
        BuiltinRegistries.add(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, myConfigured.getValue(), MY_CONFIGURED);
        BiomeModifications.addStructure(BiomeSelectors.foundInTheNether(), myConfigured);
    }
}
