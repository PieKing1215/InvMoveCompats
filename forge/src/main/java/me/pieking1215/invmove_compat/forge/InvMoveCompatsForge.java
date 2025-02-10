package me.pieking1215.invmove_compat.forge;

import me.pieking1215.invmove_compat.InvMoveCompats;
import net.minecraftforge.api.distmarker.Dist;

//? if >=1.17 {
import net.minecraftforge.fml.IExtensionPoint;
//?} else {
/*import net.minecraftforge.fml.ExtensionPoint;
import org.apache.commons.lang3.tuple.Pair;
*///?}

import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;

@Mod(InvMoveCompats.MOD_ID)
public class InvMoveCompatsForge {
    public InvMoveCompatsForge() {
        //? if >= 1.17 {
        ModLoadingContext.get().registerExtensionPoint(IExtensionPoint.DisplayTest.class,
                () -> new IExtensionPoint.DisplayTest(() -> "", (a, b) -> true));
        //?} else {
        /*ModLoadingContext.get().registerExtensionPoint(ExtensionPoint.DISPLAYTEST,
                () -> Pair.of(() -> "", (a, b) -> true));
        *///?}
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::imEnqueue);
    }

    private void imEnqueue(InterModEnqueueEvent evt) {
        if (FMLEnvironment.dist == Dist.CLIENT) {
            InvMoveCompatsForgeInit.init();
        }
    }
}
