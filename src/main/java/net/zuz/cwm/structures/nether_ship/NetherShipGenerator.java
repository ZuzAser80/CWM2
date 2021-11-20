package net.zuz.cwm.structures.nether_ship;

import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.structure.*;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ServerWorldAccess;

import java.util.List;
import java.util.Random;

public class NetherShipGenerator {
    private static final Identifier IGLOO_TOP = new Identifier("igloo/bottom");
    public static StructurePieceType NetherShipBottom;

    public static void registry()
    {
        NetherShipBottom = NetherShipGenerator.NetherShipBottom::new;
    }
    public static void addPieces(StructureManager manager, BlockPos pos, BlockRotation rotation, List<StructurePiece> pieces) {
        pieces.add(new NetherShipBottom(manager, IGLOO_TOP, pos, rotation));
    }
    public static class NetherShipBottom extends SimpleStructurePiece {
        public NetherShipBottom(StructureManager manager, Identifier identifier, BlockPos pos, BlockRotation rotation) {
            super(StructurePieceType.IGLOO, 0, manager, identifier, identifier.toString(), createPlacementData(rotation, identifier), getPosOffset(identifier, pos, 240));
        }

        public NetherShipBottom(ServerWorld world, NbtCompound nbt) {
            super(StructurePieceType.IGLOO, nbt, world, (identifier) -> {
                return createPlacementData(BlockRotation.valueOf(nbt.getString("Rot")), identifier);
            });
        }


        private static StructurePlacementData createPlacementData(BlockRotation rotation, Identifier identifier) {
            return (new StructurePlacementData()).setRotation(rotation).setMirror(BlockMirror.NONE).setPosition(new BlockPos(0, 0, 0));
        }

        private static BlockPos getPosOffset(Identifier identifier, BlockPos pos, int yOffset) {
            return pos.add(new BlockPos(0, 0, 0));
        }

        @Override
        protected void handleMetadata(String metadata, BlockPos pos, ServerWorldAccess world, Random random, BlockBox boundingBox) {

        }
    }

}
