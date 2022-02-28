package me.pieking1215.invmove_compat.forge;

import me.pieking1215.invmove.module.Modules;
import me.pieking1215.invmove_compat.InvMoveCompats;
import me.pieking1215.invmove_compat.forge.compat.JEICompat;

public class InvMoveCompatsForgeInit {
    static void init() {
        InvMoveCompats.init();

        // ignore rei's jei stub
        if (InvMoveCompats.isModLoaded.apply("jei") && !InvMoveCompats.isModLoaded.apply("roughlyenoughitems")) {
            Modules.modules.add(new JEICompat());
        }

    }
}
