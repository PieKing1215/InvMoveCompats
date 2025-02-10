package me.pieking1215.invmove_compat.compat;

//? if jei && >=1.17 {

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.runtime.IJeiRuntime;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

@JeiPlugin
public class JEIPlugin implements IModPlugin {
    @Override
    public @NotNull ResourceLocation getPluginUid() {
        //? if >=1.21 {
        return ResourceLocation.parse("invmove:jei_plugin");
        //?} else
        /*return new ResourceLocation("invmove:jei_plugin");*/
    }

    @Override
    public void onRuntimeAvailable(IJeiRuntime jeiRuntime) {
        JEIModule.runtime = jeiRuntime;
    }

    //? if jei: >=11 {
    @Override
    public void onRuntimeUnavailable() {
        JEIModule.runtime = null;
    }
    //?}
}

//?}