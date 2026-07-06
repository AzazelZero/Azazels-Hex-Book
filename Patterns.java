package net.digideeps.azazelshexes.registry;


import at.petrak.hexcasting.api.casting.ActionRegistryEntry;
import at.petrak.hexcasting.api.casting.castables.Action;
import at.petrak.hexcasting.api.casting.math.HexDir;
import at.petrak.hexcasting.api.casting.math.HexPattern;
import net.digideeps.azazelshexes.Constants;
import net.digideeps.azazelshexes.registry.casting.OpClockGambit;
import net.digideeps.azazelshexes.registry.casting.OpTest;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Unmodifiable;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;


public class Patterns {

    private static Map<ActionRegistryEntry, ResourceLocation> Actions = new HashMap<>();
    private static void make(String name, String shape, HexDir startDirection, Action action){
        Actions.put(new ActionRegistryEntry(
                HexPattern.fromAngles(shape, startDirection),
                action
        ),
        new ResourceLocation(Constants.MOD_ID,name)
        );
    }

    @Unmodifiable
    public static Map<ActionRegistryEntry, ResourceLocation> makePatternsPatterns(){
        Actions.clear();
        make("zany","weaw",  HexDir.EAST, OpTest.INSTANCE);
        make("clockgambit","wawdwewewewewew",  HexDir.SOUTH_WEST, OpClockGambit.INSTANCE);
        return Map.copyOf(Actions);
    }


    public static void register(BiConsumer<ActionRegistryEntry, ResourceLocation> r) {
        makePatternsPatterns();
        Actions.forEach(r::accept);
    }

}
