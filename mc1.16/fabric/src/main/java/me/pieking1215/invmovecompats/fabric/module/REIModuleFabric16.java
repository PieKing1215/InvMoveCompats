package me.pieking1215.invmovecompats.fabric.module;

import me.pieking1215.invmove.InvMove;
import me.pieking1215.invmove.InvMoveConfig;
import me.pieking1215.invmove.module.CVComponent;
import me.pieking1215.invmove.module.ModuleImpl;
import me.shedaniel.rei.api.REIHelper;
import me.shedaniel.rei.api.REIOverlay;
import me.shedaniel.rei.gui.widget.TextFieldWidget;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.Screen;

public class REIModuleFabric16 extends ModuleImpl {
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
        TextFieldWidget sb = REIHelper.getInstance().getSearchTextField();
        if (InvMoveConfig.MOVEMENT.TEXT_FIELD_DISABLES.get()
                && sb != null
                && sb.isVisible()
                && sb.isFocused()) {
            return Movement.SUGGEST_DISABLE;
        }

        return super.shouldAllowMovement(screen);
    }
}
