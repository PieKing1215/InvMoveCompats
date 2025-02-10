package me.pieking1215.invmove_compat.fabric;

import me.pieking1215.invmove.fabric.InvMoveInitializer;
import me.pieking1215.invmove_compat.InvMoveCompats;

public class InvMoveCompatsFabric implements InvMoveInitializer {
    @Override
    public void init() {
        InvMoveCompats.init();
    }
}
