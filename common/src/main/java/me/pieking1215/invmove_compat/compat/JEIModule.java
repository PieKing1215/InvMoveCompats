package me.pieking1215.invmove_compat.compat;

//? if jei {

import me.pieking1215.invmove.InvMove;
import me.pieking1215.invmove.InvMoveConfig;
import me.pieking1215.invmove.module.CVComponent;
import me.pieking1215.invmove.module.ModuleImpl;

import mezz.jei.api.constants.ModIds;
import mezz.jei.api.runtime.IJeiRuntime;
//? if jei: >=9 <11 {
/*import mezz.jei.common.gui.recipes.RecipesGui;
*///?} else
import mezz.jei.gui.recipes.RecipesGui;

import net.minecraft.client.gui.screens.Screen;

public class JEIModule extends ModuleImpl {
    //? if >=1.17
    protected static IJeiRuntime runtime;

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
        //? if >=1.17 {
        IJeiRuntime rt = runtime;
        //?} else
        /*IJeiRuntime rt = mezz.jei.Internal.getRuntime();*/

        if(InvMoveConfig.MOVEMENT.TEXT_FIELD_DISABLES.get()
                && rt != null
                && rt.getIngredientListOverlay().hasKeyboardFocus()) {
            return Movement.FORCE_DISABLE;
        }

        return super.shouldAllowMovement(screen);
    }
}

//?}