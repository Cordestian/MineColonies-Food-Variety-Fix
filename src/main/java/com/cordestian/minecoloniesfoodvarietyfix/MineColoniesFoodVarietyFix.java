package com.cordestian.minecoloniesfoodvarietyfix;

import com.mojang.logging.LogUtils;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

@Mod(MineColoniesFoodVarietyFix.MOD_ID)
public final class MineColoniesFoodVarietyFix
{
    public static final String MOD_ID = "minecolonies_food_variety_fix";
    public static final Logger LOGGER = LogUtils.getLogger();

    public MineColoniesFoodVarietyFix()
    {
        LOGGER.info("MineColonies Food Variety Fix loaded.");
    }
}