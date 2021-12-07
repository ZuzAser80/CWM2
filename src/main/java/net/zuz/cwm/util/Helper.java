package net.zuz.cwm.util;

import net.fabricmc.fabric.api.biome.v1.BiomeModificationContext;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredStructureFeature;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class Helper {

    public static Identifier id(String name) {
        return new Identifier("cwm", name);
    }
    public static void addStructure(BiomeModificationContext context, ConfiguredStructureFeature<?, ?> feature) {
        context.getGenerationSettings().addBuiltInStructure(feature);
    }
    public static void addToBiome(Identifier id, Predicate<BiomeSelectionContext> selectorPredicate, Consumer<BiomeModificationContext> biomeAdditionConsumer) {
        BiomeModifications.create(id).add(ModificationPhase.ADDITIONS, selectorPredicate, biomeAdditionConsumer);
    }
}
