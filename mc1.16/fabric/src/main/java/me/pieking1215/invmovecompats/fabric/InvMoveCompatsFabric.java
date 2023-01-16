package me.pieking1215.invmovecompats.fabric;

import me.pieking1215.invmove.fabric.InvMoveInitializer;
import me.pieking1215.invmovecompats.InvMoveCompats;
import me.pieking1215.invmovecompats.fabric.module.REIModuleFabric16;

public class InvMoveCompatsFabric implements InvMoveInitializer {
    @Override
    public void init() {
        InvMoveCompats.init();
        InvMoveCompats.register(REIModuleFabric16::new, "roughlyenoughitems");
    }
}
