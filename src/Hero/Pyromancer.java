package Hero;

import Map.TerrainType;
import common.Constants;

public class Pyromancer extends Hero {
    public Pyromancer() {
        super(Constants.PYROMANCER_BASE_HP, Constants.PYROMANCER_BONUS_HP_PER_LEVEL, TerrainType.Volcanic, Constants.PYROMANCER_BONUS_TERRAIN_PERCENTAGE);
    }
}
