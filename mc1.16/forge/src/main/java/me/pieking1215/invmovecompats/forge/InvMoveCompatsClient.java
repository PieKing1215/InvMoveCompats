package me.pieking1215.invmovecompats.forge;

import me.pieking1215.invmove.InvMove;
import me.pieking1215.invmove.module.Module;
import me.pieking1215.invmove.module.ModuleImpl;
import me.pieking1215.invmove.module.config.ModuleConfig;
import net.minecraft.client.gui.screens.Screen;

public class InvMoveCompatsClient {
    static void register() {
        InvMove.registerModule(new ModuleImpl() {
            @Override
            public String getId() {
                return "test";
            }
        });
    }
}
