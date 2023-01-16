package me.pieking1215.invmovecompats.forge;

import me.pieking1215.invmovecompats.InvMoveCompats;
import me.pieking1215.invmovecompats.InvMoveCompats18;

public class InvMoveForgeClient {

    static void register() {
        InvMoveCompats.init();
        InvMoveCompats18.init();
    }
}
