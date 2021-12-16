package net.zuz.cwm.structures.quarry;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.structure.pool.StructurePool;
import net.minecraft.structure.pool.StructurePoolElement;
import net.minecraft.structure.pool.StructurePools;
import net.minecraft.util.Identifier;

public class EndTowerGenerator {
    public static StructurePool POOL;



    public static void init() {
    }
    //STRUCTURE VOID TO EVERY PIECE. YES RIGHT NOW. I MEAN RIGHT FUCKING NOW
    static {
        POOL = StructurePools.register
                (new StructurePool(new Identifier("cwm", "quarry"),
                        new Identifier("empty"),
                        ImmutableList.of(
                                Pair.of(StructurePoolElement.ofLegacySingle("quarry/quarry_empty"), 7),
                                Pair.of(StructurePoolElement.ofLegacySingle("quarry/quarry_side_1"), 1)

                        ),
                        StructurePool.Projection.RIGID)
                );
        StructurePools.register
                (new StructurePool(new Identifier("cwm", "quarry_decor"),
                        new Identifier("empty"),
                        ImmutableList.of(
                                Pair.of(StructurePoolElement.ofLegacySingle("quarry/decor/quarry_decor_1"), 2)
                        ),
                        StructurePool.Projection.RIGID)
                );
    }
}
