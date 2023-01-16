package me.pieking1215.invmovecompats.forge;

import me.pieking1215.invmove.InvMove;
import me.pieking1215.invmove.module.Module;
import me.pieking1215.invmove.module.ModuleImpl;
import me.pieking1215.invmove.module.config.ModuleConfig;
import me.pieking1215.invmovecompats.InvMoveCompats;
import net.minecraft.client.gui.screens.Screen;

public class InvMoveCompatsClient {
    static void register() {
        InvMoveCompats.init();
    }
}
