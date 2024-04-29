package me.pieking1215.invmovecompats.module;

import me.pieking1215.invmove.InvMove;
import me.pieking1215.invmove.InvMoveConfig;
import me.pieking1215.invmove.module.CVComponent;
import me.pieking1215.invmove.module.ModuleImpl;
import me.shedaniel.rei.api.client.REIRuntime;
import me.shedaniel.rei.api.client.gui.widgets.TextField;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.screens.Screen;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class REIModule20 extends ModuleImpl {

    Method isFocused;
    boolean attemptedToFind = false;

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
        if (!attemptedToFind) {
            // search for method with signature `bool isFocused()`
            // we have to do an ultra hack to find it since calling it directly results in NoSuchMethod exceptions
            // for some reason it maps TextField.isFocused wrong, so we have to find it based on name and signature
            // https://github.com/shedaniel/RoughlyEnoughItems/issues/1512
            // https://github.com/shedaniel/RoughlyEnoughItems/issues/1548
            // https://github.com/shedaniel/RoughlyEnoughItems/issues/1452
            for (Method declaredMethod : TextField.class.getDeclaredMethods()) {
                // comparing to fields in GuiEventListener since it also has isFocused with same mapping
                for (Method declaredMethod2 : GuiEventListener.class.getDeclaredMethods()) {
                    if (declaredMethod.getName().equals(declaredMethod2.getName())) {
                        if (declaredMethod.getReturnType().equals(Boolean.TYPE) && declaredMethod.getParameterCount() == 0) {
                            System.out.println("Found matching method for isFocused: " + declaredMethod.getName());
                            isFocused = declaredMethod;
                        }
                    }
                }
            }

            attemptedToFind = true;
        }

        if (isFocused == null) {
            return super.shouldAllowMovement(screen);
        }


        TextField sb = REIRuntime.getInstance().getSearchTextField();
        if (sb != null) {
            try {
                boolean focused = (boolean)isFocused.invoke(sb);

                if (InvMoveConfig.MOVEMENT.TEXT_FIELD_DISABLES.get() && focused) {
                    return Movement.SUGGEST_DISABLE;
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }

        return super.shouldAllowMovement(screen);
    }
}
