package me.pieking1215.invmovecompats.module;

import me.pieking1215.invmove.InvMove;
import me.pieking1215.invmove.InvMoveConfig;
import me.pieking1215.invmove.module.CVComponent;
import me.pieking1215.invmove.module.ModuleImpl;
import mezz.jei.api.constants.ModIds;
import mezz.jei.common.Internal;
import net.minecraft.client.gui.screens.Screen;

public class JEIModule18 extends ModuleImpl {
    @Override
    public String getId() {
        return "jei";
    }

    @Override
    public CVComponent getTitle() {
        return CVComponent.literal(InvMove.instance().modNameFromModid(ModIds.JEI_ID));
    }

    @Override
    public Movement shouldAllowMovement(Screen screen) {
        var r = Internal.getRuntime();
        if (r.isPresent()) {
            if (InvMoveConfig.MOVEMENT.TEXT_FIELD_DISABLES.get()
                    && r.get().getIngredientListOverlay().hasKeyboardFocus()) {
                return Movement.SUGGEST_DISABLE;
            }
        }

        return super.shouldAllowMovement(screen);
    }
}
