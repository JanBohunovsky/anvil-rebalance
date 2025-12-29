package dev.bohush.anvilRebalance.registry;

import net.fabricmc.fabric.api.item.v1.DefaultItemComponentEvents;
import net.minecraft.core.HolderSet;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Repairable;

import java.util.Arrays;

public class RepairMaterialsManager {

    public static void init() {
        DefaultItemComponentEvents.MODIFY.register(RepairMaterialsManager::applyCustomRepairMaterials);
    }

    private static void applyCustomRepairMaterials(DefaultItemComponentEvents.ModifyContext context) {
        applyMaterial(context, Items.PRISMARINE_SHARD, Items.TRIDENT);
        applyMaterial(context, Items.FLINT, Items.FLINT_AND_STEEL);
        applyMaterial(context, Items.FEATHER, Items.BRUSH);
        applyMaterial(context, Items.IRON_INGOT, Items.SHEARS);

        applyMaterial(context, Items.STRING,
            Items.BOW,
            Items.CROSSBOW,
            Items.FISHING_ROD,
            Items.CARROT_ON_A_STICK,
            Items.WARPED_FUNGUS_ON_A_STICK);

        applyMaterial(context, Items.DIAMOND,
            Items.NETHERITE_SWORD,
            Items.NETHERITE_SPEAR,
            Items.NETHERITE_AXE,
            Items.NETHERITE_PICKAXE,
            Items.NETHERITE_SHOVEL,
            Items.NETHERITE_HOE,
            Items.NETHERITE_HELMET,
            Items.NETHERITE_CHESTPLATE,
            Items.NETHERITE_LEGGINGS,
            Items.NETHERITE_BOOTS);
    }

    private static void applyMaterial(DefaultItemComponentEvents.ModifyContext context, Item material, Item... items) {
        context.modify(Arrays.stream(items).toList(), (builder, item) -> {
            var holder = BuiltInRegistries.ITEM.wrapAsHolder(material);
            var repairable = new Repairable(HolderSet.direct(holder));
            builder.set(DataComponents.REPAIRABLE, repairable);
        });
    }
}