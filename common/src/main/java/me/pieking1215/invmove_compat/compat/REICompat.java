package me.pieking1215.invmove_compat.compat;

import me.pieking1215.invmove.InvMoveConfig;
import me.pieking1215.invmove.module.Module;
import me.pieking1215.invmove.module.ModuleImpl;
import me.pieking1215.invmove.module.config.ConfigBool;
import me.pieking1215.invmove.module.config.ModuleConfig;
import me.shedaniel.rei.api.client.REIRuntime;
import me.shedaniel.rei.impl.client.gui.credits.CreditsScreen;
import me.shedaniel.rei.impl.client.gui.screen.AbstractDisplayViewingScreen;
import me.shedaniel.rei.impl.client.gui.screen.UncertainDisplayViewingScreen;
import me.shedaniel.rei.impl.client.gui.screen.WarningAndErrorScreen;
import net.minecraft.client.gui.screens.Screen;

@SuppressWarnings("UnstableApiUsage")
public class REICompat extends ModuleImpl {
    @Override
    public String getId() {
        return "roughlyenoughitems";
    }

    public REICompat() {
        super();

        register(CreditsScreen.class).movement(Movement.FORCE_DISABLE);
        register(WarningAndErrorScreen.class, UncertainDisplayViewingScreen.class)
                .movement(Movement.SUGGEST_DISABLE)
                .background(Background.SUGGEST_SHOW);

        register(AbstractDisplayViewingScreen.class).cfg("recipe").submit();
    }

    @Override
    public Movement shouldAllowMovement(Screen screen) {
        if(InvMoveConfig.MOVEMENT.TEXT_FIELD_DISABLES.get()
                && REIRuntime.getInstance().getSearchTextField() != null
                && REIRuntime.getInstance().getSearchTextField().isFocused()) {
            return Movement.FORCE_DISABLE;
        }

        return super.shouldAllowMovement(screen);
    }
}
