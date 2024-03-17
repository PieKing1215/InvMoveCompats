package me.pieking1215.invmovecompats;

import me.pieking1215.invmovecompats.module.JEIModule20;
import me.pieking1215.invmovecompats.module.REIModule20;

public abstract class InvMoveCompats20 extends InvMoveCompats {
    public static void init() {
        InvMoveCompats.register(REIModule20::new, "roughlyenoughitems");
        InvMoveCompats.register(JEIModule20::new, "jei");
    }
}