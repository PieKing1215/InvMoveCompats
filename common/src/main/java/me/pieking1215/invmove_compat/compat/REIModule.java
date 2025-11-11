package me.pieking1215.invmove_compat.compat;

//? if rei {

import me.pieking1215.invmove.InvMove;
import me.pieking1215.invmove.InvMoveConfig;
import me.pieking1215.invmove.module.CVComponent;
import me.pieking1215.invmove.module.ModuleImpl;
import me.pieking1215.invmove_compat.InvMoveCompats;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.screens.Screen;

//? if rei: >= 6 {
import me.shedaniel.rei.api.client.REIRuntime;
import me.shedaniel.rei.api.client.gui.widgets.TextField;
//?} else {
/*import me.shedaniel.rei.api.REIHelper;
import me.shedaniel.rei.gui.widget.TextFieldWidget;
*///?}

import java.lang.reflect.Method;
import java.util.Arrays;

public class REIModule extends ModuleImpl {
    private final Method isFocused;

    @Override
    public String getId() {
        return "rei";
    }

    @Override
    public CVComponent getTitle() {
        return CVComponent.literal(InvMove.instance().modNameFromModid("roughlyenoughitems"));
    }

    public REIModule() {
        super();

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
            InvMoveCompats.LOGGER.error("Couldn't find REI's isFocused Method");
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