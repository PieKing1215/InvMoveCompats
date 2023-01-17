package me.pieking1215.invmovecompats;

import me.pieking1215.invmovecompats.module.JEIModule19;
import me.pieking1215.invmovecompats.module.REIModule19;

public abstract class InvMoveCompats19 extends InvMoveCompats {
    public static void init() {
        InvMoveCompats.register(REIModule19::new, "roughlyenoughitems");
        InvMoveCompats.register(JEIModule19::new, "jei");
    }
}
