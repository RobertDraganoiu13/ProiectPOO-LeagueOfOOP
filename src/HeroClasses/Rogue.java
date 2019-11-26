package HeroClasses;

import Map.TerrainType;
import common.RogueConstants;

public class Rogue extends Hero {
    public Rogue(int x, int y) {
        super(x, y, RogueConstants.ROGUE_BASE_HP, RogueConstants.ROGUE_BONUS_HP_PER_LEVEL, TerrainType.Woods, RogueConstants.ROGUE_BONUS_TERRAIN_PERCENTAGE);
    }

    @Override
    public void hitByFirstAbility(Hero enemyHero, TerrainType terrain) {
        enemyHero.useFirstAbility(this, terrain);
    }

    @Override
    public void hitBySecondAbility(Hero enemyHero, TerrainType terrain) {
        enemyHero.useSecondAbility(this, terrain);
    }

    @Override
    public void useFirstAbility(Knight enemyHero, TerrainType terrain) {

    }

    @Override
    public void useFirstAbility(Pyromancer enemyHero, TerrainType terrain) {

    }

    @Override
    public void useFirstAbility(Rogue enemyHero, TerrainType terrain) {

    }

    @Override
    public void useFirstAbility(Wizard enemyHero, TerrainType terrain) {

    }

    @Override
    public void useSecondAbility(Knight enemyHero, TerrainType terrainType) {

    }

    @Override
    public void useSecondAbility(Pyromancer enemyHero, TerrainType terrain) {

    }

    @Override
    public void useSecondAbility(Rogue enemyHero, TerrainType terrain) {

    }

    @Override
    public void useSecondAbility(Wizard enemyHero, TerrainType terrain) {

    }
}
