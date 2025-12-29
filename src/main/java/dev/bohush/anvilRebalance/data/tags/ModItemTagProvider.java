package dev.bohush.anvilRebalance.data.tags;

import dev.bohush.anvilRebalance.tags.ModItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.@NonNull Provider wrapperLookup) {
        addToolTags();
        addRepairTags();
    }

    private void addToolTags() {
        this.valueLookupBuilder(ModItemTags.LEATHER_TOOLS)
            .add(
                Items.LEATHER_HELMET,
                Items.LEATHER_CHESTPLATE,
                Items.LEATHER_LEGGINGS,
                Items.LEATHER_BOOTS
            );

        this.valueLookupBuilder(ModItemTags.WOODEN_TOOLS)
            .add(
                Items.WOODEN_SWORD,
                Items.WOODEN_SPEAR,
                Items.WOODEN_AXE,
                Items.WOODEN_PICKAXE,
                Items.WOODEN_SHOVEL,
                Items.WOODEN_HOE,
                Items.SHIELD
            );

        this.valueLookupBuilder(ModItemTags.STONE_TOOLS)
            .add(
                Items.STONE_SWORD,
                Items.STONE_SPEAR,
                Items.STONE_AXE,
                Items.STONE_PICKAXE,
                Items.STONE_SHOVEL,
                Items.STONE_HOE
            );

        this.valueLookupBuilder(ModItemTags.COPPER_TOOLS)
            .add(
                Items.COPPER_SWORD,
                Items.COPPER_SPEAR,
                Items.COPPER_AXE,
                Items.COPPER_PICKAXE,
                Items.COPPER_SHOVEL,
                Items.COPPER_HOE,
                Items.COPPER_HELMET,
                Items.COPPER_CHESTPLATE,
                Items.COPPER_LEGGINGS,
                Items.COPPER_BOOTS
            );

        this.valueLookupBuilder(ModItemTags.IRON_TOOLS)
            .add(
                Items.IRON_SWORD,
                Items.IRON_SPEAR,
                Items.IRON_AXE,
                Items.IRON_PICKAXE,
                Items.IRON_SHOVEL,
                Items.IRON_HOE,
                Items.IRON_HELMET,
                Items.IRON_CHESTPLATE,
                Items.IRON_LEGGINGS,
                Items.IRON_BOOTS,
                Items.CHAINMAIL_HELMET,
                Items.CHAINMAIL_CHESTPLATE,
                Items.CHAINMAIL_LEGGINGS,
                Items.CHAINMAIL_BOOTS,
                Items.SHEARS
            );

        this.valueLookupBuilder(ModItemTags.GOLD_TOOLS)
            .add(
                Items.GOLDEN_SWORD,
                Items.GOLDEN_SPEAR,
                Items.GOLDEN_AXE,
                Items.GOLDEN_PICKAXE,
                Items.GOLDEN_SHOVEL,
                Items.GOLDEN_HOE,
                Items.GOLDEN_HELMET,
                Items.GOLDEN_CHESTPLATE,
                Items.GOLDEN_LEGGINGS,
                Items.GOLDEN_BOOTS
            );

        this.valueLookupBuilder(ModItemTags.DIAMOND_TOOLS)
            .add(
                Items.DIAMOND_SWORD,
                Items.DIAMOND_SPEAR,
                Items.DIAMOND_AXE,
                Items.DIAMOND_PICKAXE,
                Items.DIAMOND_SHOVEL,
                Items.DIAMOND_HOE,
                Items.DIAMOND_HELMET,
                Items.DIAMOND_CHESTPLATE,
                Items.DIAMOND_LEGGINGS,
                Items.DIAMOND_BOOTS
            );

        this.valueLookupBuilder(ModItemTags.NETHERITE_TOOLS)
            .add(
                Items.NETHERITE_SWORD,
                Items.NETHERITE_SPEAR,
                Items.NETHERITE_AXE,
                Items.NETHERITE_PICKAXE,
                Items.NETHERITE_SHOVEL,
                Items.NETHERITE_HOE,
                Items.NETHERITE_HELMET,
                Items.NETHERITE_CHESTPLATE,
                Items.NETHERITE_LEGGINGS,
                Items.NETHERITE_BOOTS
            );

        this.valueLookupBuilder(ModItemTags.ARMADILLO_TOOLS)
            .add(Items.WOLF_ARMOR);

        this.valueLookupBuilder(ModItemTags.BREEZE_TOOLS)
            .add(Items.MACE);

        this.valueLookupBuilder(ModItemTags.FEATHER_TOOLS)
            .add(Items.BRUSH);

        this.valueLookupBuilder(ModItemTags.FLINT_TOOLS)
            .add(Items.FLINT_AND_STEEL);

        this.valueLookupBuilder(ModItemTags.PHANTOM_TOOLS)
            .add(Items.ELYTRA);

        this.valueLookupBuilder(ModItemTags.PRISMARINE_TOOLS)
            .add(Items.TRIDENT);

        this.valueLookupBuilder(ModItemTags.STRING_TOOLS)
            .add(
                Items.BOW,
                Items.CROSSBOW,
                Items.FISHING_ROD,
                Items.CARROT_ON_A_STICK,
                Items.WARPED_FUNGUS_ON_A_STICK
            );

        this.valueLookupBuilder(ModItemTags.TURTLE_TOOLS)
            .add(Items.TURTLE_HELMET);
    }

    private void addRepairTags() {
        this.valueLookupBuilder(ModItemTags.REPAIRS_LEATHER_TOOLS)
            .add(Items.LEATHER);

        this.valueLookupBuilder(ModItemTags.REPAIRS_WOODEN_TOOLS)
            .forceAddTag(ItemTags.PLANKS);

        this.valueLookupBuilder(ModItemTags.REPAIRS_STONE_TOOLS)
            .add(Items.COBBLESTONE, Items.BLACKSTONE, Items.COBBLED_DEEPSLATE);

        this.valueLookupBuilder(ModItemTags.REPAIRS_COPPER_TOOLS)
            .add(Items.COPPER_INGOT);

        this.valueLookupBuilder(ModItemTags.REPAIRS_IRON_TOOLS)
            .add(Items.IRON_INGOT);

        this.valueLookupBuilder(ModItemTags.REPAIRS_GOLD_TOOLS)
            .add(Items.GOLD_INGOT);

        this.valueLookupBuilder(ModItemTags.REPAIRS_DIAMOND_TOOLS)
            .add(Items.DIAMOND);

        this.valueLookupBuilder(ModItemTags.REPAIRS_NETHERITE_TOOLS)
            .add(Items.NETHERITE_INGOT);

        this.valueLookupBuilder(ModItemTags.REPAIRS_ARMADILLO_TOOLS)
            .add(Items.ARMADILLO_SCUTE);

        this.valueLookupBuilder(ModItemTags.REPAIRS_BREEZE_TOOLS)
            .add(Items.BREEZE_ROD);

        this.valueLookupBuilder(ModItemTags.REPAIRS_FEATHER_TOOLS)
            .add(Items.FEATHER);

        this.valueLookupBuilder(ModItemTags.REPAIRS_FLINT_TOOLS)
            .add(Items.FLINT);

        this.valueLookupBuilder(ModItemTags.REPAIRS_PHANTOM_TOOLS)
            .add(Items.PHANTOM_MEMBRANE);

        this.valueLookupBuilder(ModItemTags.REPAIRS_PRISMARINE_TOOLS)
            .add(Items.PRISMARINE_SHARD);

        this.valueLookupBuilder(ModItemTags.REPAIRS_STRING_TOOLS)
            .add(Items.STRING);

        this.valueLookupBuilder(ModItemTags.REPAIRS_TURTLE_TOOLS)
            .add(Items.TURTLE_SCUTE);
    }
}