package me.pieking1215.invmovecompats.forge;

import me.pieking1215.invmovecompats.InvMoveCompats18;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(InvMoveCompats18.MOD_ID)
public class InvMoveForge {
    public InvMoveForge() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::imEnqueue);
    }

    private void imEnqueue(InterModEnqueueEvent evt) {
        DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> InvMoveForgeClient::register);
    }
}
