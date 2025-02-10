package me.pieking1215.invmove_compat.compat;

//? if emi {

import me.pieking1215.invmove.InvMoveConfig;
import me.pieking1215.invmove.module.ModuleImpl;
import net.minecraft.client.gui.screens.Screen;

import dev.emi.emi.api.EmiApi;
import dev.emi.emi.screen.BoMScreen;
import dev.emi.emi.screen.ConfigScreen;
import dev.emi.emi.screen.RecipeScreen;

public class EMICompat extends ModuleImpl {
    @Override
    public String getId() {
        return "emi";
    }

    public EMICompat() {
        super();

        register(ConfigScreen.class).movement(Movement.FORCE_DISABLE);
        register(BoMScreen.class).movement(Movement.SUGGEST_DISABLE).background(Background.SUGGEST_SHOW);
        register(RecipeScreen.class).cfg("recipe").submit();
    }

    @Override
    public Movement shouldAllowMovement(Screen screen) {
        if(InvMoveConfig.MOVEMENT.TEXT_FIELD_DISABLES.get()
                && EmiApi.isSearchFocused()) {
            return Movement.FORCE_DISABLE;
        }

        return super.shouldAllowMovement(screen);
    }
}

//?}