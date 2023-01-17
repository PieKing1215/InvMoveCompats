package me.pieking1215.invmovecompats;

import me.pieking1215.invmovecompats.module.JEIModule18;
import me.pieking1215.invmovecompats.module.REIModule18;

public abstract class InvMoveCompats18 extends InvMoveCompats {
    public static void init() {
        InvMoveCompats.register(REIModule18::new, "roughlyenoughitems");
        InvMoveCompats.register(JEIModule18::new, "jei");
    }
}
