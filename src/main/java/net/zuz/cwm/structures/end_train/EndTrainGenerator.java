package net.zuz.cwm.structures.end_train;


import net.minecraft.world.gen.feature.ConfiguredStructureFeature;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.StructurePoolFeatureConfig;


public class EndTrainGenerator {

    public EndTrainGenerator() {
    }
    //public static ConfiguredStructureFeature<StructurePoolFeatureConfig, ?> END_TRAIN_FEATURE;
    public static void registry()
    {
        //END_TRAIN_FEATURE = END_TRAIN_FEATURE_START.configure(new StructurePoolFeatureConfig(() -> EndTrainData.POOL, 2));
    }
    public static void init() {
        EndTrainData.init();
    }


}
