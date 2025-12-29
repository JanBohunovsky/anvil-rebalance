package dev.bohush.anvilRebalance.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import dev.bohush.anvilRebalance.util.UnitRepairManager;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import org.jspecify.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(AnvilMenu.class)
public abstract class AnvilMenuMixin extends ItemCombinerMenu {

    public AnvilMenuMixin(@Nullable MenuType<?> menuType, int i, Inventory inventory, ContainerLevelAccess containerLevelAccess, ItemCombinerMenuSlotDefinition itemCombinerMenuSlotDefinition) {
        super(menuType, i, inventory, containerLevelAccess, itemCombinerMenuSlotDefinition);
    }

    @ModifyArg(
        method = "createResult",
        at = @At(
            value = "INVOKE",
            target = "Ljava/lang/Math;min(II)I"
        ),
        index = 1
    )
    private int useCustomRepairUnitCost(int original, @Local(ordinal = 1) ItemStack itemStack) {
        return Math.round((float) itemStack.getMaxDamage() / UnitRepairManager.determineUnitCost(itemStack));
    }
}