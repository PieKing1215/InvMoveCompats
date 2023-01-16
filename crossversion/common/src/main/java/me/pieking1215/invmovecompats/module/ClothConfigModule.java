package me.pieking1215.invmovecompats.module;

import me.pieking1215.invmove.InvMove;
import me.pieking1215.invmove.module.ModuleImpl;
import me.pieking1215.invmove.module.CVComponent;
import me.shedaniel.clothconfig2.gui.AbstractConfigScreen;

public class ClothConfigModule extends ModuleImpl {
    @Override
    public String getId() {
        return "cloth-config";
    }

    @Override
    public CVComponent getTitle() {
        return CVComponent.literal(InvMove.instance().modNameFromModid("cloth-config"));
    }

    public ClothConfigModule() {
        super();
        register(AbstractConfigScreen.class).movement(Movement.FORCE_DISABLE).background(Background.SUGGEST_SHOW);
    }
}
