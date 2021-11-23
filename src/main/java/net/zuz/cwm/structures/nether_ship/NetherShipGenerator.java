package net.zuz.cwm.structures.nether_ship;

import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.structure.*;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ServerWorldAccess;

import java.util.Random;

public class NetherShipGenerator {
    private static final Identifier nether_ship = new Identifier("nethership/main");
    private Identifier stuff = new Identifier("cwm", "nether_ship");

    public static void registry()
    {
    }
    public NetherShipGenerator() {

    }
    public static void create(StructureManager manager, BlockPos pos, BlockRotation rotation, StructurePiecesHolder structurePiecesHolder, Random random) {
            structurePiecesHolder.addPiece(new nether_ship_piece(manager, NetherShipFeature.nether_ship, pos, rotation, 0));
    }
    public static class nether_ship_piece extends SimpleStructurePiece {

        public nether_ship_piece(ServerWorld world, NbtCompound nbt) {
            super(NetherShipFeature.nether_ship, nbt, world, (stuff) -> {
                return createplacementdata(BlockRotation.valueOf(nbt.getString("rot")));
            });
        }
        public nether_ship_piece(StructureManager manager, StructurePieceType netherShipBottom, BlockPos pos, BlockRotation rotation, int i) {
            super(NetherShipFeature.nether_ship, 0, manager, nether_ship, netherShipBottom.toString(), createplacementdata(rotation), getoffset(nether_ship, pos, 0));
        }

        private static StructurePlacementData createplacementdata(BlockRotation rotation) {
            return (new StructurePlacementData());
                    //.setRotation(rotation)
                    //.setMirror(BlockMirror.NONE)
                    //.setPosition(BlockPos.ORIGIN);
        }

        private static BlockPos getoffset(Identifier identifier, BlockPos pos, int yOffset) {
            return pos.add(0, 0, 0);
        }

        protected void writeNbt(ServerWorld world, NbtCompound nbt) {
            super.writeNbt(world, nbt);
            nbt.putString("rot", this.placementData.getRotation().name());
        }

        protected void handleMetadata(String metadata, BlockPos pos, ServerWorldAccess world, Random random, BlockBox boundingBox) {
            //if ("chest".equals(metadata)) {
            //    world.setBlockState(pos, Blocks.AIR.getDefaultState(), 3);
            //    BlockEntity blockEntity = world.getBlockEntity(pos.down());
            //    if (blockEntity instanceof ChestBlockEntity) {
            //        ((ChestBlockEntity)blockEntity).setLootTable(LootTables.IGLOO_CHEST_CHEST, random.nextLong());
            //    }
            //
            //}
        }
    }

}
