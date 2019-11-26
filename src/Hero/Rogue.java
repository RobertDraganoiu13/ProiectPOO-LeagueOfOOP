package Hero;

import Map.TerrainType;
import common.Constants;

public class Rogue extends Hero {
    public Rogue() {
        super(Constants.ROGUE_BASE_HP, Constants.ROGUE_BONUS_HP_PER_LEVEL, TerrainType.Woods, Constants.ROGUE_BONUS_TERRAIN_PERCENTAGE);
    }
}
