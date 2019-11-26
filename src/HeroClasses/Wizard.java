package HeroClasses;

import Map.TerrainType;
import common.Constants;

public class Wizard extends Hero {
    public Wizard(int x, int y) {
        super(x, y, Constants.WIZARD_BASE_HP, Constants.WIZARD_BONUS_HP_PER_LEVEL, TerrainType.Desert, Constants.WIZARD_BONUS_TERRAIN_PERCENTAGE);
    }
}
