package me.pieking1215.invmovecompats.module;

import me.pieking1215.invmove.InvMove;
import me.pieking1215.invmove.InvMoveConfig;
import me.pieking1215.invmove.module.CVComponent;
import me.pieking1215.invmove.module.ModuleImpl;
import me.shedaniel.rei.api.client.REIRuntime;
import me.shedaniel.rei.api.client.gui.widgets.TextField;
import net.minecraft.client.gui.screens.Screen;

public class REIModule19 extends ModuleImpl {
    @Override
    public String getId() {
        return "rei";
    }

    @Override
    public CVComponent getTitle() {
        return CVComponent.literal(InvMove.instance().modNameFromModid("roughlyenoughitems"));
    }

    @Override
    public Movement shouldAllowMovement(Screen screen) {
        TextField sb = REIRuntime.getInstance().getSearchTextField();
        if (InvMoveConfig.MOVEMENT.TEXT_FIELD_DISABLES.get()
                && sb != null
                && sb.isFocused()) {
            return Movement.SUGGEST_DISABLE;
        }

        return super.shouldAllowMovement(screen);
    }
}
