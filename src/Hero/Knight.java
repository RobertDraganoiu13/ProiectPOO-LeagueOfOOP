package Hero;

import Map.TerrainType;
import common.Constants;

public class Knight extends Hero {
    public Knight() {
        super(Constants.KNIGHT_BASE_HP, Constants.KNIGHT_BONUS_HP_PER_LEVEL, TerrainType.Land, Constants.KNIGHT_BONUS_TERRAIN_PERCENTAGE);
    }
}
