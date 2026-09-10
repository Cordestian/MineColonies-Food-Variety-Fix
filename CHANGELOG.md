# Changelog

## 1.0.0

Initial release.

### Fixed

* Corrected `CitizenFoodHandler#getLastEaten()` returning the oldest entry in MineColonies' recent-food queue instead of the newest entry.
* Prevents incorrect recent-food bookkeeping from contributing to repeated meal selection and Dining Hall food-variety complaints.

### Compatibility

* Minecraft 1.21.1
* NeoForge 21.1.249
* MineColonies 1.1.1374
