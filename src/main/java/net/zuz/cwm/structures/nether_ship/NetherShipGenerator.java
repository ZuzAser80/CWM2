package net.zuz.cwm.structures.nether_ship;

import net.minecraft.block.entity.LootableContainerBlockEntity;
import net.minecraft.loot.LootTables;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.structure.*;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ServerWorldAccess;

import java.util.Random;

public class NetherShipGenerator {
    private static final Identifier NetherShipNbt = new Identifier("nether_ship/main");


    public NetherShipGenerator() {
    }

    public static void addPieces(StructureManager manager, StructurePiecesHolder structurePiecesHolder, Random random, BlockPos pos) {
        BlockRotation blockRotation = BlockRotation.random(random);
        structurePiecesHolder.addPiece(new MainPiece(manager, NetherShipNbt, pos, blockRotation));
    }

    public static class MainPiece extends SimpleStructurePiece {
        public MainPiece(StructureManager manager, Identifier template, BlockPos pos, BlockRotation rotation) {
            super(NetherShipFeature.NetherShipPiece, 0, manager, template, template.toString(), createPlacementData(rotation), pos);
        }

        public MainPiece(ServerWorld world, NbtCompound nbt) {
            super(NetherShipFeature.NetherShipPiece, nbt, world, (identifier) -> {
                return createPlacementData(BlockRotation.valueOf(nbt.getString("Rot")));
            });
        }

        private static StructurePlacementData createPlacementData(BlockRotation rotation) {
            return (new StructurePlacementData())
                    .setRotation(rotation)
                    .setMirror(BlockMirror.NONE);
        }

        protected void writeNbt(ServerWorld world, NbtCompound nbt) {
            super.writeNbt(world, nbt);
            nbt.putString("Rot", this.placementData.getRotation().name());
        }

        protected void handleMetadata(String metadata, BlockPos pos, ServerWorldAccess world, Random random, BlockBox boundingBox) {

        }
        //public boolean generate(StructureWorldAccess world, StructureAccessor structureAccessor, ChunkGenerator chunkGenerator, Random random, BlockBox boundingBox, ChunkPos chunkPos, BlockPos pos) {
        //    boundingBox.encompass(this.structure.calculateBoundingBox(this.placementData, this.pos));
        //    return super.generate(world, structureAccessor, chunkGenerator, random, boundingBox, chunkPos, pos);
        //}
    }
}
