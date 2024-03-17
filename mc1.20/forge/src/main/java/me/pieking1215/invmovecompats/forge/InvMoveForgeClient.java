package me.pieking1215.invmovecompats.forge;

import me.pieking1215.invmovecompats.InvMoveCompats;
import me.pieking1215.invmovecompats.InvMoveCompats20;

public class InvMoveForgeClient {

    static void register() {
        InvMoveCompats.init();
        InvMoveCompats20.init();
    }
}
