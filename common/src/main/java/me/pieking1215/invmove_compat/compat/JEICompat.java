package me.pieking1215.invmove_compat.compat;

//? if jei {

import me.pieking1215.invmove.InvMoveConfig;
import me.pieking1215.invmove.module.ModuleImpl;

import mezz.jei.api.runtime.IJeiRuntime;
//? if jei: >=9 <11 {
/*import mezz.jei.common.gui.recipes.RecipesGui;
*///?} else
import mezz.jei.gui.recipes.RecipesGui;

import net.minecraft.client.gui.screens.Screen;

import java.util.function.Supplier;

public class JEICompat extends ModuleImpl {
    //? if >=1.17
    protected static IJeiRuntime runtime;

    @Override
    public String getId() {
        return "jei";
    }

    public JEICompat() {
        super();

        register(RecipesGui.class).cfg("recipe").submit();
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