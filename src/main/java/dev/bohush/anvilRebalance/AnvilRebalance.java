package dev.bohush.anvilRebalance;

import dev.bohush.anvilRebalance.registry.RepairMaterialsManager;
import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AnvilRebalance implements ModInitializer {
    public static final String MOD_ID = "anvil-rebalance";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        RepairMaterialsManager.init();
    }

    public static Identifier createIdentifier(String id) {
        return Identifier.fromNamespaceAndPath(MOD_ID, id);
    }
}