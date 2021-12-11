package net.zuz.cwm.structures.end_train;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.structure.pool.StructurePool;
import net.minecraft.structure.pool.StructurePoolElement;
import net.minecraft.structure.pool.StructurePools;
import net.minecraft.structure.processor.StructureProcessorLists;
import net.minecraft.util.Identifier;

public class EndCatacombsGenerator {
    public static StructurePool POOL;



    public static void init() {
    }
    //cwm:end_catacombs_treasure
    static {
        POOL = StructurePools.register
                (new StructurePool(new Identifier("cwm", "end_catacombs_pool"),
                        new Identifier("empty"),
                        ImmutableList.of(
                                Pair.of(StructurePoolElement.ofLegacySingle("end_catacombs/end_catacombs_corridor_1"), 3),
                                Pair.of(StructurePoolElement.ofLegacySingle("end_catacombs/end_catacombs_corridor_2"), 1),
                                Pair.of(StructurePoolElement.ofLegacySingle("end_catacombs/end_catacombs_upstairs_1"), 2),
                                Pair.of(StructurePoolElement.ofLegacySingle("end_catacombs/end_catacombs_crossing_1"), 4),
                                Pair.of(StructurePoolElement.ofLegacySingle("end_catacombs/end_catacombs_stairs_1"), 3),
                                Pair.of(StructurePoolElement.ofLegacySingle("end_catacombs/end_catacombs_downstairs_1"), 2)



                        ),
                StructurePool.Projection.RIGID)
                );
        StructurePools.register
                (new StructurePool(new Identifier("cwm", "end_catacombs_treasure"),
                        new Identifier("empty"),
                        ImmutableList.of(
                                Pair.of(StructurePoolElement.ofLegacySingle("end_catacombs/treasure/end_catacombs_treasure_chest_1"), 4),
                                Pair.of(StructurePoolElement.ofLegacySingle("end_catacombs/treasure/end_catacombs_ender_chest"), 1),
                                Pair.of(StructurePoolElement.ofEmpty(), 3)
                        ),
                        StructurePool.Projection.RIGID)
                );
        StructurePools.register
                (new StructurePool(new Identifier("cwm", "end_catacombs_mobs"),
                        new Identifier("empty"),
                        ImmutableList.of(
                                Pair.of(StructurePoolElement.ofLegacySingle("end_catacombs/mobs/end_catacombs_spawner_1"), 1),
                                Pair.of(StructurePoolElement.ofLegacySingle("end_catacombs/mobs/end_catacombs_spawner_2"), 1),
                                Pair.of(StructurePoolElement.ofEmpty(), 2)
                                ),
                        StructurePool.Projection.RIGID)
                );
    }
}
