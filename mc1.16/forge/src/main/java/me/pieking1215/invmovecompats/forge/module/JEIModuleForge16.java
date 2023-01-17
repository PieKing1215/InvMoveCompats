package me.pieking1215.invmovecompats.forge.module;

import me.pieking1215.invmove.InvMove;
import me.pieking1215.invmove.InvMoveConfig;
import me.pieking1215.invmove.module.CVComponent;
import me.pieking1215.invmove.module.ModuleImpl;
import mezz.jei.Internal;
import net.minecraft.client.gui.screens.Screen;

public class JEIModuleForge16 extends ModuleImpl {
    @Override
    public String getId() {
        return "jei";
    }

    @Override
    public CVComponent getTitle() {
        return CVComponent.literal(InvMove.instance().modNameFromModid("jei"));
    }

//    @Override
//    public Movement shouldAllowMovement(Screen screen) {
//        if (InvMoveConfig.MOVEMENT.TEXT_FIELD_DISABLES.get()
//                && Internal.getRuntime() != null
//                && Internal.getRuntime().getIngredientListOverlay().hasKeyboardFocus()
//        ) {
//            return Movement.SUGGEST_DISABLE;
//        }
//
//        return super.shouldAllowMovement(screen);
//    }
}
