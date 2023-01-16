package me.pieking1215.invmovecompats.forge;

import me.pieking1215.invmovecompats.InvMoveCompats;
import me.pieking1215.invmovecompats.InvMoveCompats19;

public class InvMoveForgeClient {

    static void register() {
        InvMoveCompats.init();
        InvMoveCompats19.init();
    }
}
