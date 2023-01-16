package me.pieking1215.invmovecompats.fabric_like.module;

import dev.emi.emi.api.EmiApi;
import dev.emi.emi.screen.EmiScreenManager;
import me.pieking1215.invmove.InvMove;
import me.pieking1215.invmove.InvMoveConfig;
import me.pieking1215.invmove.module.CVComponent;
import me.pieking1215.invmove.module.ModuleImpl;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.Screen;

public class EMIModule19 extends ModuleImpl {
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
        EditBox sb = EmiScreenManager.search;
        if (InvMoveConfig.MOVEMENT.TEXT_FIELD_DISABLES.get()
                && sb != null
                && sb.active
                && sb.canConsumeInput()) {
            return Movement.SUGGEST_DISABLE;
        }

        return super.shouldAllowMovement(screen);
    }
}
