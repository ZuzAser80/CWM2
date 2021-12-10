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
                                Pair.of(StructurePoolElement.ofProcessedSingle("end_catacombs/end_catacombs_crossing", StructureProcessorLists.EMPTY), 1),
                                Pair.of(StructurePoolElement.ofProcessedSingle("end_catacombs/end_catacombs_one_way_corridor", StructureProcessorLists.EMPTY), 2),
                                Pair.of(StructurePoolElement.ofProcessedSingle("end_catacombs/end_catacombs_rotation", StructureProcessorLists.EMPTY), 2),
                                Pair.of(StructurePoolElement.ofProcessedSingle("end_catacombs/end_catacombs_upstairs_1", StructureProcessorLists.EMPTY), 2),
                                Pair.of(StructurePoolElement.ofProcessedSingle("end_catacombs/end_catacombs_shulker_room", StructureProcessorLists.EMPTY), 5),
                                Pair.of(StructurePoolElement.ofProcessedSingle("end_catacombs/end_catacombs_battle_corridor", StructureProcessorLists.EMPTY), 4),
                                Pair.of(StructurePoolElement.ofProcessedSingle("end_catacombs/end_catacombs_end_chest", StructureProcessorLists.EMPTY), 2),
                                Pair.of(StructurePoolElement.ofProcessedSingle("end_catacombs/end_catacombs_chest_room_1", StructureProcessorLists.EMPTY), 3),
                                Pair.of(StructurePoolElement.ofProcessedSingle("end_catacombs/end_catacombs_chest_doorway", StructureProcessorLists.EMPTY), 3)



                        ),
                StructurePool.Projection.RIGID)
                );
        StructurePools.register
                (new StructurePool(new Identifier("cwm", "end_catacombs_mobs"),
                        new Identifier("empty"),
                        ImmutableList.of(
                                Pair.of(StructurePoolElement.ofProcessedSingle("end_catacombs/mobs/end_catacombs_shulker", StructureProcessorLists.EMPTY), 1),
                                Pair.of(StructurePoolElement.ofProcessedSingle("end_catacombs/mobs/end_catacombs_enderman", StructureProcessorLists.EMPTY), 1)
                              //Pair.of(StructurePoolElement.ofEmpty(), 4)

                        ),
                        StructurePool.Projection.RIGID)
                );
        StructurePools.register
                (new StructurePool(new Identifier("cwm", "end_catacombs_treasure"),
                        new Identifier("empty"),
                        ImmutableList.of(
                                Pair.of(StructurePoolElement.ofProcessedSingle("end_catacombs/treasures/end_catacombs_diamond_pile", StructureProcessorLists.EMPTY), 2),
                                Pair.of(StructurePoolElement.ofProcessedSingle("end_catacombs/treasures/end_catacombs_diamond_pile_1", StructureProcessorLists.EMPTY), 2),
                                Pair.of(StructurePoolElement.ofProcessedSingle("end_catacombs/treasures/end_catacombs_diamond_pile_2", StructureProcessorLists.EMPTY), 1),
                                Pair.of(StructurePoolElement.ofProcessedSingle("end_catacombs/treasures/end_catacombs_emerald_pile", StructureProcessorLists.EMPTY), 2),
                                Pair.of(StructurePoolElement.ofProcessedSingle("end_catacombs/treasures/end_catacombs_emerald_pile_1", StructureProcessorLists.EMPTY), 2),
                                Pair.of(StructurePoolElement.ofProcessedSingle("end_catacombs/treasures/end_catacombs_amethyst_pile", StructureProcessorLists.EMPTY), 1),
                                Pair.of(StructurePoolElement.ofProcessedSingle("end_catacombs/treasures/end_catacombs_end_city_chest", StructureProcessorLists.EMPTY), 5),
                                Pair.of(StructurePoolElement.ofProcessedSingle("end_catacombs/treasures/end_catacombs_chest", StructureProcessorLists.EMPTY), 5),
                                Pair.of(StructurePoolElement.ofEmpty(), 5)
                        ),
                        StructurePool.Projection.RIGID)
                );
    }
}
