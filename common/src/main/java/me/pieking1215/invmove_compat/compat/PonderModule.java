package me.pieking1215.invmove_compat.compat;

//? if ponder {

import me.pieking1215.invmove.InvMove;
import me.pieking1215.invmove.InvMoveConfig;
import me.pieking1215.invmove.module.CVComponent;
import me.pieking1215.invmove.module.ModuleImpl;
import me.pieking1215.invmove.module.config.ConfigBool;
import me.pieking1215.invmove_compat.InvMoveCompats;
import net.createmod.ponder.enums.PonderKeybinds;
import net.createmod.ponder.foundation.PonderTooltipHandler;
import net.createmod.ponder.foundation.ui.PonderTagIndexScreen;
import net.createmod.ponder.foundation.ui.PonderTagScreen;
import net.createmod.ponder.foundation.ui.PonderUI;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;

public class PonderModule extends ModuleImpl {
    private long lastPonderTime = 0;

    protected ConfigBool holdPonderAllowMovement;

    public PonderModule() {
        try {
            PonderTooltipHandler.registerHoveredPonderStackCallback(is -> {
                if (Minecraft.getInstance().level != null) {
                    lastPonderTime = Minecraft.getInstance().level.getGameTime();
                }
            });

            // this setting only works on newer Ponder, so put it after the part that throws
            holdPonderAllowMovement = m_config.bool("holdPonderAllowMovement", false).textFn(InvMoveConfig.MOVEMENT_YES_NO_TEXT);
        } catch(NoSuchMethodError e) {
            // Error expected for older versions of Ponder (before Create 6.0.7)
            InvMoveCompats.LOGGER.warn("Full Ponder support requires Create 6.0.7+. Some features (Hold To Ponder option) are disabled.");
            m_config.label("holdPonderAllowMovement.notAvailable");
        }

        register(PonderUI.class).cfg("ponder").setDefaults(false, false).submit();
        register(PonderTagScreen.class).cfg("tag").setDefaults(true, true).submit();
        register(PonderTagIndexScreen.class).cfg("index").setDefaults(true, true).submit();
    }

    @Override
    public String getId() {
        return "ponder";
    }

    @Override
    public CVComponent getTitle() {
        return CVComponent.literal(InvMove.instance().modNameFromModid("ponder"));
    }


    @Override
    public Movement shouldAllowMovement(Screen screen) {
        // disable movement if:
        // - holdPonderAllowMovement is false (Disallow Movement)
        // - AND you're in a level
        // - AND the ponder key is pressed this tick
        // - AND the ponder key is a movement key
        if (holdPonderAllowMovement != null
                && !holdPonderAllowMovement.get()
                && Minecraft.getInstance().level != null
                && Minecraft.getInstance().level.getGameTime() == lastPonderTime
                && PonderKeybinds.PONDER.isDown()) {
            return Movement.SUGGEST_DISABLE;
        }

        return super.shouldAllowMovement(screen);
    }
}

//?}