package net.zuz.cwm.structures.end_train;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.structure.PoolStructurePiece;
import net.minecraft.structure.StructureManager;
import net.minecraft.structure.pool.StructurePool;
import net.minecraft.structure.pool.StructurePoolElement;
import net.minecraft.structure.pool.StructurePools;
import net.minecraft.structure.processor.StructureProcessorLists;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.zuz.cwm.structures.end_ufo.EndUfoFeature;

public class EndCatacombsGenerator {
    public static final StructurePool POOL;



    public static void init() {
    }

    static {
        POOL = StructurePools.register
                (new StructurePool(new Identifier("cwm", "end_catacombs_pool"),
                        new Identifier("empty"),
                        ImmutableList.of(
                                Pair.of(StructurePoolElement.ofProcessedSingle("end_catacombs/end_catacombs_crossing", StructureProcessorLists.EMPTY), 4),
                                Pair.of(StructurePoolElement.ofProcessedSingle("end_catacombs/end_catacombs_one_way_corridor", StructureProcessorLists.EMPTY), 6),
                                Pair.of(StructurePoolElement.ofProcessedSingle("end_catacombs/end_catacombs_rotation", StructureProcessorLists.EMPTY), 1),
                                Pair.of(StructurePoolElement.ofProcessedSingle("end_catacombs/end_catacombs_upstairs", StructureProcessorLists.EMPTY), 1)
                        ),
                StructurePool.Projection.RIGID)
        );
    }
}
