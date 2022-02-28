package me.pieking1215.invmove_compat.forge.compat;

import me.pieking1215.invmove.InvMoveConfig;
import me.pieking1215.invmove.module.ModuleImpl;
import mezz.jei.Internal;
import mezz.jei.gui.recipes.RecipesGui;
import net.minecraft.client.gui.screens.Screen;

@SuppressWarnings("UnstableApiUsage")
public class JEICompat extends ModuleImpl {
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

        if(InvMoveConfig.MOVEMENT.TEXT_FIELD_DISABLES.get()
                && Internal.getRuntime() != null
                && Internal.getRuntime().getIngredientListOverlay().hasKeyboardFocus()) {
            return Movement.FORCE_DISABLE;
        }

        return super.shouldAllowMovement(screen);
    }
}
