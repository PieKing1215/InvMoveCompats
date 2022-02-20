package me.pieking1215.invmove_compat;

import me.pieking1215.invmove.module.Module;
import me.pieking1215.invmove.module.Modules;
import me.pieking1215.invmove.module.config.ConfigBool;
import me.pieking1215.invmove.module.config.ModuleConfig;
import net.minecraft.client.gui.screens.Screen;

public class InvMoveCompats {
    public static final String MOD_ID = "invmove_compat";

    public static void init() {
        Modules.modules.add(new Module() {
            ModuleConfig movement = new ModuleConfig("movement");
            ConfigBool m_test = movement.bool("test", false);

            ModuleConfig background = new ModuleConfig("background");
            ConfigBool b_test = background.bool("test", true);

            @Override
            public String getId() {
                return "test";
            }

            @Override
            public Movement shouldAllowMovement(Screen screen) {
                return Movement.PASS;
            }

            @Override
            public Background shouldHideBackground(Screen screen) {
                return Background.PASS;
            }

            @Override
            public ModuleConfig getMovementConfig() {
                return movement;
            }

            @Override
            public ModuleConfig getBackgroundConfig() {
                return background;
            }
        });
    }
}
