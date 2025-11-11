package me.pieking1215.invmove_compat;

import me.pieking1215.invmove.module.Module;
import me.pieking1215.invmove.InvMove;

import me.pieking1215.invmove_compat.compat.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.function.Supplier;

public abstract class InvMoveCompats {
    public static final String MOD_ID = "invmove_compat";

    public static final Logger LOGGER = LogManager.getLogger();

    public static void init() {
        register(ClothConfigModule::new, "cloth-config", "cloth_config", "cloth-config2", "cloth_config2");

        //? if rei
        InvMoveCompats.register(REIModule::new, "roughlyenoughitems");
        //? if jei
        InvMoveCompats.register(JEIModule::new, "jei");
        //? if emi
        InvMoveCompats.register(EMIModule::new, "emi");
        //? if ponder
        /*InvMoveCompats.register(PonderModule::new, "ponder");*/
    }

    public static void register(Supplier<Module> moduleSup, String... modid) {
        LOGGER.info("Checking for modids: {}", Arrays.toString(modid));
        if(Arrays.stream(modid).anyMatch(s -> InvMove.instance().hasMod(s))) {
            InvMove.registerModule(moduleSup.get());
        }
    }
}
