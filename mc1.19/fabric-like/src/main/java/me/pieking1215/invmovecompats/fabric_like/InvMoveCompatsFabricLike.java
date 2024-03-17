package me.pieking1215.invmovecompats.fabric_like;

import me.pieking1215.invmove.fabric_like.InvMoveInitializer;
import me.pieking1215.invmovecompats.InvMoveCompats;
import me.pieking1215.invmovecompats.InvMoveCompats19;
import me.pieking1215.invmovecompats.fabric_like.module.EMIModule19;

public class InvMoveCompatsFabricLike implements InvMoveInitializer {

    @Override
    public void init() {
        InvMoveCompats.init();
        InvMoveCompats19.init();
        InvMoveCompats.register(() -> new EMIModule19(), "emi");
    }
}