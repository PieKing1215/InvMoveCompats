package me.pieking1215.invmove_compat.compat;

//? if rei {

import me.pieking1215.invmove.InvMoveConfig;
import me.pieking1215.invmove.module.ModuleImpl;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.screens.Screen;

//? if rei: >= 6 {
import me.shedaniel.rei.api.client.REIRuntime;
import me.shedaniel.rei.api.client.gui.widgets.TextField;
import me.shedaniel.rei.impl.client.gui.credits.CreditsScreen;
import me.shedaniel.rei.impl.client.gui.screen.AbstractDisplayViewingScreen;
import me.shedaniel.rei.impl.client.gui.screen.UncertainDisplayViewingScreen;
import me.shedaniel.rei.impl.client.gui.screen.WarningAndErrorScreen;
//?} else {
/*import me.shedaniel.rei.api.REIHelper;
import me.shedaniel.rei.gui.widget.TextFieldWidget;
import me.shedaniel.rei.gui.credits.CreditsScreen;
import me.shedaniel.rei.gui.WarningAndErrorScreen;
import me.shedaniel.rei.gui.RecipeViewingScreen;
*///?}

import java.lang.reflect.Method;
import java.util.Arrays;

@SuppressWarnings("UnstableApiUsage")
public class REICompat extends ModuleImpl {
    private final Method isFocused;

    @Override
    public String getId() {
        return "roughlyenoughitems";
    }

    public REICompat() {
        super();

        register(CreditsScreen.class).movement(Movement.FORCE_DISABLE);
        register(WarningAndErrorScreen.class).movement(Movement.SUGGEST_DISABLE).background(Background.SUGGEST_SHOW);
        //? if rei: >= 6 {
        register(UncertainDisplayViewingScreen.class).movement(Movement.SUGGEST_DISABLE).background(Background.SUGGEST_SHOW);
        register(AbstractDisplayViewingScreen.class).cfg("recipe").submit();
        //?} else
        /*register(RecipeViewingScreen.class).cfg("recipe").submit();*/

        // we have to do this with reflection because on some versions REI's TextField::isFocused is incorrectly remapped
        //   in prod because it matches GuiEventListener::isFocused, which makes it crash when called normally
        isFocused = Arrays.stream(/*? if rei: >= 6 {*/TextField/*?} else {*/ /*TextFieldWidget *//*?}*/.class.getDeclaredMethods())
                .filter(m -> m.getName().equals("isFocused")).findFirst()
                .orElseGet(() -> Arrays.stream(/*? if rei: >= 6 {*/TextField/*?} else {*/ /*TextFieldWidget *//*?}*/.class.getDeclaredMethods())
                    .filter(m -> {
                        // check signature
                        if (m.getParameterCount() > 0 || m.getReturnType() != boolean.class)
                            return false;

                        // check for matching method in GuiEventListener
                        try {
                            GuiEventListener.class.getDeclaredMethod(m.getName());
                            return true;
                        } catch (NoSuchMethodException e) {
                            return false;
                        }
                    }).findFirst().orElse(null)
                );

        if (isFocused == null) {
            System.err.println("[InvMoveCompats] [REI] Couldn't find isFocused Method");
        }
    }

    @Override
    public Movement shouldAllowMovement(Screen screen) {
        try {
            if(InvMoveConfig.MOVEMENT.TEXT_FIELD_DISABLES.get()
                    && isFocused != null
                    && /*? if rei: >= 6 {*/REIRuntime/*?} else {*/ /*REIHelper *//*?}*/.getInstance().getSearchTextField() != null
                    && (boolean)isFocused.invoke(/*? if rei: >= 6 {*/REIRuntime/*?} else {*/ /*REIHelper *//*?}*/.getInstance().getSearchTextField())) {
                return Movement.FORCE_DISABLE;
            }
        } catch (Exception ignored) { }

        return super.shouldAllowMovement(screen);
    }
}

//?}