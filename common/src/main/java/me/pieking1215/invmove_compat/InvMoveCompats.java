package me.pieking1215.invmove_compat;

import me.pieking1215.invmove.module.Module;
import me.pieking1215.invmove.InvMove;

import me.pieking1215.invmove_compat.compat.ClothConfigModule;
//? if rei
import me.pieking1215.invmove_compat.compat.REIModule;
//? if emi
import me.pieking1215.invmove_compat.compat.EMIModule;
//? if jei
import me.pieking1215.invmove_compat.compat.JEIModule;

import java.util.Arrays;
import java.util.function.Supplier;

public abstract class InvMoveCompats {
    public static final String MOD_ID = "invmove_compat";

    public static void init() {
        register(ClothConfigModule::new, "cloth-config", "cloth_config", "cloth-config2", "cloth_config2");

        //? if rei
        InvMoveCompats.register(REIModule::new, "roughlyenoughitems");
        //? if jei
        InvMoveCompats.register(JEIModule::new, "jei");
        // for some reason doing EMIModule20::new causes a classload but this doesn't???
        //? if emi
        InvMoveCompats.register(EMIModule::new, "emi");
    }

    public static void register(Supplier<Module> moduleSup, String... modid) {
        System.out.println("[InvMoveCompats] Checking for modids: " + Arrays.toString(modid));
        if(Arrays.stream(modid).anyMatch(s -> InvMove.instance().hasMod(s))) {
            InvMove.registerModule(moduleSup.get());
        }
    }
}
