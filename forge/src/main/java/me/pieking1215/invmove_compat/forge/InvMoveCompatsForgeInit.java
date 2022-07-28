package me.pieking1215.invmove_compat.forge;

import me.pieking1215.invmove.InvMove;
import me.pieking1215.invmove_compat.InvMoveCompats;
import me.pieking1215.invmove_compat.forge.compat.JEICompat;

public class InvMoveCompatsForgeInit {
    static void init() {
        InvMoveCompats.init();

        // ignore rei's jei stub
        if (InvMoveCompats.isModLoaded.apply("jei") && !InvMoveCompats.isModLoaded.apply("roughlyenoughitems")) {
            InvMove.registerModule(new JEICompat());
        }

    }
}
