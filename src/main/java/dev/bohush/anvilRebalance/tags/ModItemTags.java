package dev.bohush.anvilRebalance.tags;

import dev.bohush.anvilRebalance.AnvilRebalance;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModItemTags {

	public static final TagKey<Item> LEATHER_TOOLS = bind("leather_tools");
	public static final TagKey<Item> WOODEN_TOOLS = bind("wooden_tools");
	public static final TagKey<Item> STONE_TOOLS = bind("stone_tools");
	public static final TagKey<Item> COPPER_TOOLS = bind("copper_tools");
	public static final TagKey<Item> IRON_TOOLS = bind("iron_tools");
	public static final TagKey<Item> GOLD_TOOLS = bind("gold_tools");
	public static final TagKey<Item> DIAMOND_TOOLS = bind("diamond_tools");
	public static final TagKey<Item> NETHERITE_TOOLS = bind("netherite_tools");
	public static final TagKey<Item> ARMADILLO_TOOLS = bind("armadillo_tools");
	public static final TagKey<Item> BREEZE_TOOLS = bind("breeze_tools");
	public static final TagKey<Item> FEATHER_TOOLS = bind("feather_tools");
	public static final TagKey<Item> FLINT_TOOLS = bind("flint_tools");
	public static final TagKey<Item> PHANTOM_TOOLS = bind("phantom_tools");
	public static final TagKey<Item> PRISMARINE_TOOLS = bind("prismarine_tools");
	public static final TagKey<Item> STRING_TOOLS = bind("string_tools");
	public static final TagKey<Item> TURTLE_TOOLS = bind("turtle_tools");

	public static final TagKey<Item> REPAIRS_LEATHER_TOOLS = bind("repairs_leather_tools");
	public static final TagKey<Item> REPAIRS_WOODEN_TOOLS = bind("repairs_wooden_tools");
	public static final TagKey<Item> REPAIRS_STONE_TOOLS = bind("repairs_stone_tools");
	public static final TagKey<Item> REPAIRS_COPPER_TOOLS = bind("repairs_copper_tools");
	public static final TagKey<Item> REPAIRS_IRON_TOOLS = bind("repairs_iron_tools");
	public static final TagKey<Item> REPAIRS_GOLD_TOOLS = bind("repairs_gold_tools");
	public static final TagKey<Item> REPAIRS_DIAMOND_TOOLS = bind("repairs_diamond_tools");
	public static final TagKey<Item> REPAIRS_NETHERITE_TOOLS = bind("repairs_netherite_tools");
	public static final TagKey<Item> REPAIRS_ARMADILLO_TOOLS = bind("repairs_armadillo_tools");
	public static final TagKey<Item> REPAIRS_BREEZE_TOOLS = bind("repairs_breeze_tools");
	public static final TagKey<Item> REPAIRS_FEATHER_TOOLS = bind("repairs_feather_tools");
	public static final TagKey<Item> REPAIRS_FLINT_TOOLS = bind("repairs_flint_tools");
	public static final TagKey<Item> REPAIRS_PHANTOM_TOOLS = bind("repairs_phantom_tools");
	public static final TagKey<Item> REPAIRS_PRISMARINE_TOOLS = bind("repairs_prismarine_tools");
	public static final TagKey<Item> REPAIRS_STRING_TOOLS = bind("repairs_string_tools");
	public static final TagKey<Item> REPAIRS_TURTLE_TOOLS = bind("repairs_turtle_tools");

	private static TagKey<Item> bind(String id) {
		return TagKey.create(Registries.ITEM, AnvilRebalance.createIdentifier(id));
	}
}