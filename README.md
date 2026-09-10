# MineColonies Food Variety Fix

A small NeoForge addon for MineColonies that fixes incorrect food-history bookkeeping which can cause citizens to repeatedly eat the same foods and complain about insufficient meal variety.

## What It Fixes

MineColonies tracks each citizen's recent food history using an `EvictingQueue`.

In MineColonies 1.1.1374, `CitizenFoodHandler#getLastEaten()` returns the head of that queue instead of the newest entry.

As a result, MineColonies can treat an older food as the citizen's most recently eaten food when updating food history. This addon corrects `getLastEaten()` so it returns the newest entry.

## Behavior

The fix does not replace or redesign MineColonies' food system. Dining Hall logistics, food requests, chef behavior, batching, food selection, and diversity calculations remain handled by MineColonies.

The addon only corrects which existing food-history entry is considered the most recently eaten food.

It adds no ticking logic, polling, inventory scanning, networking, configuration, or additional persistent data.

## Testing

The issue was reproduced in a survival colony where citizens developed food histories heavily dominated by the same meal and complained about food variety despite multiple foods being available.

One affected citizen had a 10-meal history containing only 3 unique foods, including 7 consecutive servings of Spicy Eggplant.

After applying the fix and allowing the citizen's entire 10-meal history to cycle, the same citizen had 8 unique foods in the history.

Multiple other citizens throughout the colony were subsequently checked and also had a diversity of 8 with no observed Dining Hall food-variety complaints.

The addon was then removed for comparison while leaving the available food recipes unchanged. Historical behavior confirmed that the fix was necessary.

## Compatibility

Version 1.0.0 has been tested with:

* Minecraft 1.21.1
* NeoForge 21.1.249
* MineColonies 1.1.1374
* All the Mods 10 8.1

Version 1.0.0 intentionally requires MineColonies 1.1.1374 because the addon modifies an internal MineColonies class with a Mixin.

Compatibility with other MineColonies versions should not be assumed until tested.

## Requirements

* Minecraft 1.21.1
* NeoForge
* MineColonies 1.1.1374
* MineColonies' normal dependencies

## Installation

1. Install MineColonies 1.1.1374 and its required dependencies.
2. Place the MineColonies Food Variety Fix JAR in your `mods` folder.
3. Start the game normally.

No configuration is required.

## Upstream Issue

This addon addresses the repeated-meal and food-diversity behavior reported in MineColonies issue #11726:

https://github.com/ldtteam/minecolonies/issues/11726

## License

CC0 1.0 Universal.
