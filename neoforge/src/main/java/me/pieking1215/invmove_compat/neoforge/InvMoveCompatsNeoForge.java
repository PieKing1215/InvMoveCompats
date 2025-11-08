package me.pieking1215.invmove_compat.neoforge;

import me.pieking1215.invmove_compat.InvMoveCompats;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.InterModEnqueueEvent;
import net.neoforged.fml.loading.FMLEnvironment;

@Mod(InvMoveCompats.MOD_ID)
public class InvMoveCompatsNeoForge {
    public InvMoveCompatsNeoForge(IEventBus mod_bus) {
        mod_bus.addListener(this::imEnqueue);
    }

    private void imEnqueue(InterModEnqueueEvent evt) {
        if (/*? if >= 1.21.9 {*/FMLEnvironment.getDist()/*?} else {*//*FMLEnvironment.dist*//*?}*/ == Dist.CLIENT) {
            InvMoveCompatsNeoForgeInit.init();
        }
    }
}
