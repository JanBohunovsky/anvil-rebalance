package dev.bohush.anvilRebalance.util;

import net.fabricmc.fabric.api.item.v1.DefaultItemComponentEvents;
import net.minecraft.core.HolderSet;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Repairable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UnitRepairManager {
    private static final int DEFAULT_BASE_UNIT_COST = 4;
    private static final int DEFAULT_MULTIPLIER_UNIT_COST = 1;
    private static final int NETHERITE_MULTIPLIER_UNIT_COST = 2;

    private static final ArrayList<Item> NETHERITE_ITEMS = new ArrayList<>();
    private static HolderSet<Item> NETHERITE_ITEM_HOLDER_SET;

    public static void init() {
        DefaultItemComponentEvents.MODIFY.register(UnitRepairManager::applyCustomRepairMaterials);

        NETHERITE_ITEMS.add(Items.NETHERITE_SWORD);
        NETHERITE_ITEMS.add(Items.NETHERITE_SPEAR);
        NETHERITE_ITEMS.add(Items.NETHERITE_AXE);
        NETHERITE_ITEMS.add(Items.NETHERITE_PICKAXE);
        NETHERITE_ITEMS.add(Items.NETHERITE_SHOVEL);
        NETHERITE_ITEMS.add(Items.NETHERITE_HOE);
        NETHERITE_ITEMS.add(Items.NETHERITE_HELMET);
        NETHERITE_ITEMS.add(Items.NETHERITE_CHESTPLATE);
        NETHERITE_ITEMS.add(Items.NETHERITE_LEGGINGS);
        NETHERITE_ITEMS.add(Items.NETHERITE_BOOTS);

        NETHERITE_ITEM_HOLDER_SET = HolderSet.direct(NETHERITE_ITEMS.stream()
            .map(BuiltInRegistries.ITEM::wrapAsHolder)
            .toList());
    }

    public static int determineUnitCost(ItemStack itemStack) {
        return determineBaseUnitCost(itemStack) * determineMultiplierUnitCost(itemStack);
    }

    private static int determineBaseUnitCost(ItemStack itemStack) {
        if (itemStack.is(ItemTags.HEAD_ARMOR))
            return 5;
        if (itemStack.is(ItemTags.CHEST_ARMOR))
            return 8;
        if (itemStack.is(ItemTags.LEG_ARMOR))
            return 6;
        if (itemStack.is(ItemTags.FOOT_ARMOR))
            return 4;
        if (itemStack.is(Items.WOLF_ARMOR))
            return 6;

        if (itemStack.is(ItemTags.SWORDS))
            return 2;
        if (itemStack.is(ItemTags.SPEARS))
            return 1;
        if (itemStack.is(ItemTags.AXES))
            return 3;
        if (itemStack.is(ItemTags.PICKAXES))
            return 3;
        if (itemStack.is(ItemTags.SHOVELS))
            return 1;
        if (itemStack.is(ItemTags.HOES))
            return 2;

        if (itemStack.is(Items.TRIDENT))
            return 3;
        if (itemStack.is(Items.FLINT_AND_STEEL))
            return 1;
        if (itemStack.is(Items.BRUSH))
            return 1;
        if (itemStack.is(Items.SHEARS))
            return 2;
        if (itemStack.is(Items.BOW))
            return 3;
        if (itemStack.is(Items.CROSSBOW))
            return 3;
        if (itemStack.is(Items.FISHING_ROD))
            return 2;
        if (itemStack.is(Items.CARROT_ON_A_STICK))
            return 2;
        if (itemStack.is(Items.WARPED_FUNGUS_ON_A_STICK))
            return 2;

        if (itemStack.is(Items.ELYTRA))
            return 4;
        if (itemStack.is(Items.MACE))
            return 2;
        if (itemStack.is(Items.SHIELD))
            return 6;

        return DEFAULT_BASE_UNIT_COST;
    }

    private static int determineMultiplierUnitCost(ItemStack itemStack) {
        if (itemStack.is(NETHERITE_ITEM_HOLDER_SET))
            return NETHERITE_MULTIPLIER_UNIT_COST;

        return DEFAULT_MULTIPLIER_UNIT_COST;
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

        applyMaterial(context, Items.DIAMOND, NETHERITE_ITEMS);
    }

    private static void applyMaterial(DefaultItemComponentEvents.ModifyContext context, Item material, Item... items) {
        applyMaterial(context, material, Arrays.asList(items));
    }

    private static void applyMaterial(DefaultItemComponentEvents.ModifyContext context, Item material, List<Item> items) {
        context.modify(items, (builder, item) -> {
            var holder = BuiltInRegistries.ITEM.wrapAsHolder(material);
            var repairable = new Repairable(HolderSet.direct(holder));
            builder.set(DataComponents.REPAIRABLE, repairable);
        });
    }
}