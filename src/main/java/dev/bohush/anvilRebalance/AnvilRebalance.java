package dev.bohush.anvilRebalance;

import dev.bohush.anvilRebalance.tags.ModItemTags;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.mixin.item.ItemAccessor;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Repairable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AnvilRebalance implements ModInitializer {
    public static final String MOD_ID = "anvil-rebalance";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static Identifier createIdentifier(String id) {
        return Identifier.fromNamespaceAndPath(MOD_ID, id);
    }

    @Override
    public void onInitialize() {
        ServerLifecycleEvents.SERVER_STARTED.register(server -> refreshRepairMaterials());
        ServerLifecycleEvents.END_DATA_PACK_RELOAD.register((server, resourceManager, success) -> refreshRepairMaterials());
    }

    private void refreshRepairMaterials() {
        LOGGER.info("Setting repair materials");
        setRepairMaterials(ModItemTags.LEATHER_TOOLS, ModItemTags.REPAIRS_LEATHER_TOOLS);
        setRepairMaterials(ModItemTags.WOODEN_TOOLS, ModItemTags.REPAIRS_WOODEN_TOOLS);
        setRepairMaterials(ModItemTags.STONE_TOOLS, ModItemTags.REPAIRS_STONE_TOOLS);
        setRepairMaterials(ModItemTags.COPPER_TOOLS, ModItemTags.REPAIRS_COPPER_TOOLS);
        setRepairMaterials(ModItemTags.IRON_TOOLS, ModItemTags.REPAIRS_IRON_TOOLS);
        setRepairMaterials(ModItemTags.GOLD_TOOLS, ModItemTags.REPAIRS_GOLD_TOOLS);
        setRepairMaterials(ModItemTags.DIAMOND_TOOLS, ModItemTags.REPAIRS_DIAMOND_TOOLS);
        setRepairMaterials(ModItemTags.NETHERITE_TOOLS, ModItemTags.REPAIRS_NETHERITE_TOOLS);
        setRepairMaterials(ModItemTags.ARMADILLO_TOOLS, ModItemTags.REPAIRS_ARMADILLO_TOOLS);
        setRepairMaterials(ModItemTags.BREEZE_TOOLS, ModItemTags.REPAIRS_BREEZE_TOOLS);
        setRepairMaterials(ModItemTags.FEATHER_TOOLS, ModItemTags.REPAIRS_FEATHER_TOOLS);
        setRepairMaterials(ModItemTags.FLINT_TOOLS, ModItemTags.REPAIRS_FLINT_TOOLS);
        setRepairMaterials(ModItemTags.PHANTOM_TOOLS, ModItemTags.REPAIRS_PHANTOM_TOOLS);
        setRepairMaterials(ModItemTags.PRISMARINE_TOOLS, ModItemTags.REPAIRS_PRISMARINE_TOOLS);
        setRepairMaterials(ModItemTags.STRING_TOOLS, ModItemTags.REPAIRS_STRING_TOOLS);
        setRepairMaterials(ModItemTags.TURTLE_TOOLS, ModItemTags.REPAIRS_TURTLE_TOOLS);
    }

    private void setRepairMaterials(TagKey<Item> toolTag, TagKey<Item> materialTag) {
        var toolItemHolderSet = BuiltInRegistries.ITEM.get(toolTag);
        var materialItemHolderSet = BuiltInRegistries.ITEM.get(materialTag);

        if (toolItemHolderSet.isEmpty() || materialItemHolderSet.isEmpty()) {
            return;
        }

        for (var toolItemHolder : toolItemHolderSet.get()) {
            var toolItem = toolItemHolder.value();
            var components = DataComponentMap.builder().addAll(toolItem.components());
            components.set(DataComponents.REPAIRABLE, new Repairable(materialItemHolderSet.get()));
            ((ItemAccessor) toolItem).setComponents(components.build());
        }
    }
}