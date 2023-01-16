package me.pieking1215.invmovecompats.forge;

import me.pieking1215.invmovecompats.InvMoveCompats16;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(InvMoveCompats16.MOD_ID)
public class InvMoveCompatsForge {
    public InvMoveCompatsForge() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::imEnqueue);
    }

    private void imEnqueue(InterModEnqueueEvent evt) {
        DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> InvMoveCompatsClient::register);
    }
}
