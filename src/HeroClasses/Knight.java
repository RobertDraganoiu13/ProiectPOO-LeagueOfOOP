package HeroClasses;

import Map.TerrainType;
import common.Constants;

public class Knight extends Hero {
    public Knight(int x, int y) {
        super(x, y, Constants.KNIGHT_BASE_HP, Constants.KNIGHT_BONUS_HP_PER_LEVEL, TerrainType.Land, Constants.KNIGHT_BONUS_TERRAIN_PERCENTAGE);
    }
}
