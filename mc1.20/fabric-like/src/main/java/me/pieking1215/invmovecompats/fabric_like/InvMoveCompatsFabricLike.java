package me.pieking1215.invmovecompats.fabric_like;

import me.pieking1215.invmove.fabric_like.InvMoveInitializer;
import me.pieking1215.invmovecompats.InvMoveCompats;
import me.pieking1215.invmovecompats.InvMoveCompats20;
import me.pieking1215.invmovecompats.module.EMIModule20;

public class InvMoveCompatsFabricLike implements InvMoveInitializer {

    @Override
    public void init() {
        InvMoveCompats.init();
        InvMoveCompats20.init();
    }
}