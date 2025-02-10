package me.pieking1215.invmove_compat.compat;

import me.pieking1215.invmove.InvMove;
import me.pieking1215.invmove.module.CVComponent;
import me.pieking1215.invmove.module.ModuleImpl;
import me.shedaniel.clothconfig2.gui.AbstractConfigScreen;

import java.util.Arrays;

public class ClothConfigModule extends ModuleImpl {
    @Override
    public String getId() {
        return "cloth-config";
    }

    @Override
    public CVComponent getTitle() {
        String clothId = Arrays.stream(new String[]{"cloth-config", "cloth_config", "cloth-config2", "cloth_config2"})
                .filter(id -> InvMove.instance().hasMod(id))
                .findFirst().orElse("cloth-config");
        return CVComponent.literal(InvMove.instance().modNameFromModid(clothId));
    }

    public ClothConfigModule() {
        super();

        register(AbstractConfigScreen.class).movement(Movement.FORCE_DISABLE).background(Background.SUGGEST_SHOW);
    }
}
