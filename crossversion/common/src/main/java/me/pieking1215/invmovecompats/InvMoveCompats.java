package me.pieking1215.invmovecompats;

import me.pieking1215.invmove.InvMove;
import me.pieking1215.invmove.module.Module;
import me.pieking1215.invmovecompats.module.ClothConfigModule;

import java.util.Arrays;
import java.util.function.Supplier;

public class InvMoveCompats {
    public final static String MOD_ID = "invmovecompats";

    public static void init() {
        register(ClothConfigModule::new, "cloth-config", "cloth_config", "cloth-config2", "cloth_config2");
    }

    public static void register(Supplier<Module> moduleSup, String... modid) {
        System.out.println("[InvMoveCompats] Checking for modids: " + Arrays.toString(modid));
        if(Arrays.stream(modid).anyMatch(s -> InvMove.instance().hasMod(s))) {
            InvMove.registerModule(moduleSup.get());
        }
    }

}
