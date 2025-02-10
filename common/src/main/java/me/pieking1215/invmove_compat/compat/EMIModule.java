package me.pieking1215.invmove_compat.compat;

//? if emi {

import me.pieking1215.invmove.InvMove;
import me.pieking1215.invmove.InvMoveConfig;
import me.pieking1215.invmove.module.CVComponent;
import me.pieking1215.invmove.module.ModuleImpl;
import net.minecraft.client.gui.screens.Screen;

import dev.emi.emi.api.EmiApi;

public class EMIModule extends ModuleImpl {
    @Override
    public String getId() {
        return "emi";
    }

    @Override
    public CVComponent getTitle() {
        return CVComponent.literal(InvMove.instance().modNameFromModid("emi"));
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