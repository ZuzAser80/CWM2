package net.zuz.cwm.structures.end_ufo;

import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.structure.SimpleStructurePiece;
import net.minecraft.structure.StructureManager;
import net.minecraft.structure.StructurePiecesHolder;
import net.minecraft.structure.StructurePlacementData;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ServerWorldAccess;

import java.util.Random;

public class EndUfoGenerator {
    private static final Identifier Nbt = new Identifier("end_ufo/main");


    public EndUfoGenerator() {
    }

    public static void addPieces(StructureManager manager, StructurePiecesHolder structurePiecesHolder, Random random, BlockPos pos) {
        BlockRotation blockRotation = BlockRotation.random(random);
        structurePiecesHolder.addPiece(new EndUfoGenerator.MainPiece(manager, Nbt, pos, blockRotation));
    }

    public static class MainPiece extends SimpleStructurePiece {
        public MainPiece(StructureManager manager, Identifier template, BlockPos pos, BlockRotation rotation) {
            super(EndUfoFeature.EndUfoPiece, 0, manager, template, template.toString(), createPlacementData(rotation), pos);
        }

        public MainPiece(ServerWorld world, NbtCompound nbt) {
            super(EndUfoFeature.EndUfoPiece, nbt, world, (identifier) -> {
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

    }
    //if (metadata.startsWith("Sentry")) {
    //                    ShulkerEntity shulkerEntity = (ShulkerEntity)EntityType.SHULKER.create(world.toServerWorld());
    //                    shulkerEntity.setPosition((double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D);
    //                    world.spawnEntity(shulkerEntity);
}
