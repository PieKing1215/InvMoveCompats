package me.pieking1215.invmove_compat;

import me.pieking1215.invmove.InvMove;
import me.pieking1215.invmove_compat.compat.ClothConfigCompat;
import me.pieking1215.invmove_compat.compat.REICompat;

import java.util.function.Function;

public class InvMoveCompats {
    public static final String MOD_ID = "invmove_compat";

    public static Function<String, Boolean> isModLoaded = s -> false;

    public static void init() {
        if (isModLoaded.apply("roughlyenoughitems")) {
            InvMove.registerModule(new REICompat());
        }

        if (isModLoaded.apply("cloth-config") || isModLoaded.apply("cloth_config")) {
            InvMove.registerModule(new ClothConfigCompat());
        }
    }
}
