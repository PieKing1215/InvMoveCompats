package me.pieking1215.invmove_compat.forge;

import me.pieking1215.invmove_compat.InvMoveCompats;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.IExtensionPoint;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(InvMoveCompats.MOD_ID)
public class InvMoveCompatsForge {
    public InvMoveCompatsForge() {
        ModLoadingContext.get().registerExtensionPoint(IExtensionPoint.DisplayTest.class,
                () -> new IExtensionPoint.DisplayTest(() -> "", (a, b) -> true));
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::imEnqueue);
        InvMoveCompats.isModLoaded = s -> ModList.get().isLoaded(s);
    }

    private void imEnqueue(InterModEnqueueEvent evt) {
        DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> InvMoveCompatsForgeInit::init);
    }
}
