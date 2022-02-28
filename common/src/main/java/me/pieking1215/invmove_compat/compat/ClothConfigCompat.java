package me.pieking1215.invmove_compat.compat;

import me.pieking1215.invmove.module.ModuleImpl;
import me.shedaniel.clothconfig2.gui.AbstractConfigScreen;

public class ClothConfigCompat extends ModuleImpl {

    @Override
    public String getId() {
        return "cloth-config";
    }

    public ClothConfigCompat() {
        super();
        register(AbstractConfigScreen.class).movement(Movement.FORCE_DISABLE).background(Background.SUGGEST_SHOW);
    }
}
