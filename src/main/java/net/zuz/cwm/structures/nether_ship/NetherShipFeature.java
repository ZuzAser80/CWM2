package net.zuz.cwm.structures.nether_ship;

import com.mojang.serialization.Codec;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.structure.v1.FabricStructureBuilder;
import net.minecraft.structure.StructureManager;
import net.minecraft.structure.StructureStart;
import net.minecraft.util.BlockRotation;
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

public class NetherShipFeature extends StructureFeature<DefaultFeatureConfig> {
    public NetherShipFeature(Codec<DefaultFeatureConfig> codec) {
        super(codec);
    }
    public static void registry()
    {
        final StructureFeature<DefaultFeatureConfig> NETHER_SHIP_BOTTOM = new NetherShipFeature(DefaultFeatureConfig.CODEC);
        Registry.register(Registry.STRUCTURE_PIECE, new Identifier("cwm", "nether_ship_bottom"), NetherShipGenerator.NetherShipBottom);
        FabricStructureBuilder.create(new Identifier("cwm", "nether_ship"), NETHER_SHIP_BOTTOM)
                .step(GenerationStep.Feature.SURFACE_STRUCTURES)
                .defaultConfig(32, 8, 12345)
                .adjustsSurface()
                .register();
        final ConfiguredStructureFeature<?, ?> MY_CONFIGURED = NETHER_SHIP_BOTTOM.configure(DefaultFeatureConfig.DEFAULT);
        RegistryKey<ConfiguredStructureFeature<?, ?>> myConfigured = RegistryKey.of(Registry.CONFIGURED_STRUCTURE_FEATURE_KEY, new Identifier("cmw", "nether_ship"));
        BuiltinRegistries.add(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, myConfigured.getValue(), MY_CONFIGURED);
        BiomeModifications.addStructure(BiomeSelectors.foundInTheNether(), myConfigured);
    }

    @Override
    public StructureFeature.StructureStartFactory<DefaultFeatureConfig> getStructureStartFactory() {
        return Start::new;
    }

    public static class Start extends StructureStart<DefaultFeatureConfig> {
        public Start(StructureFeature<DefaultFeatureConfig> structureFeature, ChunkPos chunkPos, int i, long l) {
            super(structureFeature, chunkPos, i, l);
        }

        @Override
        public void init(DynamicRegistryManager registryManager, ChunkGenerator chunkGenerator, StructureManager manager, ChunkPos pos, Biome biome, DefaultFeatureConfig config, HeightLimitView world) {
            int x = pos.x * 16;
            int z = pos.z * 16;
            int y = 240;
            BlockPos blockPos = new BlockPos(x, y, z);
            BlockRotation rotation = BlockRotation.random(this.random);
            NetherShipGenerator.addPieces(manager, blockPos, rotation, this.children);
            this.setBoundingBoxFromChildren();
        }


        // Called when the world attempts to spawn in a new structure, and is the gap between your feature and generator.
    }
}
