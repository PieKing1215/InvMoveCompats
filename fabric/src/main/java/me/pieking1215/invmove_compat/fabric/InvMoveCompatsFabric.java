package me.pieking1215.invmove_compat.fabric;

import me.pieking1215.invmove.fabric.InvMoveInitializer;
import me.pieking1215.invmove_compat.InvMoveCompats;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;

import java.util.Optional;

public class InvMoveCompatsFabric implements InvMoveInitializer {
    @Override
    public void init() {
        InvMoveCompats.isModLoaded = s -> FabricLoader.getInstance().isModLoaded(s);
        InvMoveCompats.init();
    }
}
