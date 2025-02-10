package me.pieking1215.invmove_compat;

import me.pieking1215.invmove.InvMove;
import me.pieking1215.invmove_compat.compat.ClothConfigCompat;
//? if rei
import me.pieking1215.invmove_compat.compat.REICompat;
//? if emi
import me.pieking1215.invmove_compat.compat.EMICompat;
//? if jei
import me.pieking1215.invmove_compat.compat.JEICompat;

public abstract class InvMoveCompats {
    public static final String MOD_ID = "invmove_compat";

    public static void init() {
        if (InvMove.instance().hasMod("cloth-config") || InvMove.instance().hasMod("cloth_config") || InvMove.instance().hasMod("cloth-config2")) {
            InvMove.registerModule(new ClothConfigCompat());
        }

        //? if rei {
        if (InvMove.instance().hasMod("roughlyenoughitems")) {
            InvMove.registerModule(new REICompat());
        }
        //?}

        //? if emi {
        if (InvMove.instance().hasMod("emi")) {
            InvMove.registerModule(new EMICompat());
        }
        //?}

        //? if jei {
        if (InvMove.instance().hasMod("jei")) {
            InvMove.registerModule(new JEICompat());
        }
        //?}
    }
}
