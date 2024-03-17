package me.pieking1215.invmovecompats.module;

import me.pieking1215.invmove.InvMove;
import me.pieking1215.invmove.InvMoveConfig;
import me.pieking1215.invmove.module.CVComponent;
import me.pieking1215.invmove.module.ModuleImpl;
import me.shedaniel.rei.api.client.REIRuntime;
import me.shedaniel.rei.api.client.gui.widgets.TextField;
import net.minecraft.client.gui.screens.Screen;

import java.lang.reflect.Method;

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
//        System.out.println(sb);
//        if (sb != null) {
//            for (Method declaredMethod : sb.getClass().getDeclaredMethods()) {
//                System.out.println(declaredMethod.getName());
//            }
//            System.out.println("=== TextField " + TextField.class.getSuperclass());
//            for (Method declaredMethod : TextField.class.getDeclaredMethods()) {
//                System.out.println(declaredMethod.getName());
//            }
//        }
        // calling isFocused results in NoSuchMethodError at runtime on forge
        // my guess is it doesn't remap because TextField is the name of a vanilla class
//        System.out.println(sb.isFocused());
//        if (InvMoveConfig.MOVEMENT.TEXT_FIELD_DISABLES.get()
//                && sb != null
//                && sb.isFocused()) {
//            return Movement.SUGGEST_DISABLE;
//        }

        return super.shouldAllowMovement(screen);
    }
}
