package net.zuz.cwm.structures.end_train;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.structure.pool.StructurePool;
import net.minecraft.structure.pool.StructurePoolElement;
import net.minecraft.structure.pool.StructurePools;
import net.minecraft.structure.processor.StructureProcessorLists;
import net.minecraft.util.Identifier;

public class EndTrainData {
    public static final StructurePool POOL;

    public EndTrainData() {
    }

    public static void init() {
    }

    static {
        POOL = StructurePools.register
                (new StructurePool(new Identifier("cwm", "end_train"), new Identifier("empty"),
                        ImmutableList.of(Pair.of(StructurePoolElement.ofProcessedSingle("end_train/end_train_1", StructureProcessorLists.EMPTY), 1)),
                        StructurePool.Projection.RIGID));
    }
}
