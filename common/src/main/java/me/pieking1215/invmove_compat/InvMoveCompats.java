package me.pieking1215.invmove_compat;

import me.pieking1215.invmove.InvMove;
import me.pieking1215.invmove_compat.compat.ClothConfigCompat;
import me.pieking1215.invmove_compat.compat.REICompat;

import java.util.function.Function;

public abstract class InvMoveCompats {
    public static final String MOD_ID = "invmove_compat";

    public static void init() {
        if (InvMove.instance().hasMod("roughlyenoughitems")) {
            InvMove.registerModule(new REICompat());
        }

        if (InvMove.instance().hasMod("cloth-config") || InvMove.instance().hasMod("cloth_config") || InvMove.instance().hasMod("cloth-config2")) {
            InvMove.registerModule(new ClothConfigCompat());
        }
    }
}
