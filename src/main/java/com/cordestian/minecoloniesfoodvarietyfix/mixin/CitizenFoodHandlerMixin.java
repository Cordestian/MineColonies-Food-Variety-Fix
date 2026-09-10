package com.cordestian.minecoloniesfoodvarietyfix.mixin;

import com.google.common.collect.EvictingQueue;
import com.minecolonies.core.entity.citizen.citizenhandlers.CitizenFoodHandler;
import net.minecraft.world.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CitizenFoodHandler.class)
public abstract class CitizenFoodHandlerMixin
{
    @Accessor("lastEatenFoods")
    public abstract EvictingQueue<Item> minecoloniesFoodVarietyFix$getLastEatenFoods();

    @Inject(
            method = "getLastEaten",
            at = @At("HEAD"),
            cancellable = true
    )
    private void minecoloniesFoodVarietyFix$returnActualLastEaten(
            final CallbackInfoReturnable<Item> cir)
    {
        Item newest = null;

        for (final Item item : minecoloniesFoodVarietyFix$getLastEatenFoods())
        {
            newest = item;
        }

        cir.setReturnValue(newest);
    }
}