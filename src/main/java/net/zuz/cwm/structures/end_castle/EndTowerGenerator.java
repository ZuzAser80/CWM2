package net.zuz.cwm.structures.end_castle;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.structure.pool.StructurePool;
import net.minecraft.structure.pool.StructurePoolElement;
import net.minecraft.structure.pool.StructurePools;
import net.minecraft.util.Identifier;

public class EndTowerGenerator {
    public static StructurePool POOL;

    //

    public static void init() {
    }
    //STRUCTURE VOID TO EVERY PIECE. YES RIGHT NOW. I MEAN RIGHT FUCKING NOW
    static {
        POOL = StructurePools.register
                (new StructurePool(new Identifier("cwm", "end_castle"),
                        new Identifier("empty"),
                        ImmutableList.of(
                                Pair.of(StructurePoolElement.ofLegacySingle("end_castle/end_castle_corridor_1"), 1),
                                Pair.of(StructurePoolElement.ofLegacySingle("end_castle/end_castle_top_1"), 1),
                                Pair.of(StructurePoolElement.ofLegacySingle("end_castle/end_castle_corridor_2"), 2),
                                Pair.of(StructurePoolElement.ofLegacySingle("end_castle/end_castle_tower_1"), 1),
                                Pair.of(StructurePoolElement.ofLegacySingle("end_castle/end_castle_tower_2"), 1),
                                Pair.of(StructurePoolElement.ofLegacySingle("end_castle/end_castle_tower_3"), 1),
                                Pair.of(StructurePoolElement.ofLegacySingle("end_castle/end_castle_tower_roof_1"), 3),
                                Pair.of(StructurePoolElement.ofLegacySingle("end_castle/end_castle_treasure_room_1"), 1),
                                Pair.of(StructurePoolElement.ofLegacySingle("end_castle/end_castle_top_2"), 1)

                        ),
                        StructurePool.Projection.RIGID)
                );
        StructurePools.register
                (new StructurePool(new Identifier("cwm", "end_castle_feature"),
                        new Identifier("empty"),
                        ImmutableList.of(
                                Pair.of(StructurePoolElement.ofLegacySingle("end_castle/feature/end_castle_chest_1"), 2),
                                Pair.of(StructurePoolElement.ofLegacySingle("end_castle/feature/end_castle_chest_3"), 1),
                                Pair.of(StructurePoolElement.ofLegacySingle("end_castle/feature/end_castle_chest_2"), 2),
                                Pair.of(StructurePoolElement.ofLegacySingle("end_castle/feature/end_castle_spawner_4"), 2),
                                Pair.of(StructurePoolElement.ofLegacySingle("end_castle/feature/end_castle_spawner_3"), 1),
                                Pair.of(StructurePoolElement.ofLegacySingle("end_castle/feature/end_castle_spawner_2"), 2),
                                Pair.of(StructurePoolElement.ofLegacySingle("end_castle/feature/end_castle_spawner_1"), 2)


                        ),
                        StructurePool.Projection.RIGID)
                );
    }
}
