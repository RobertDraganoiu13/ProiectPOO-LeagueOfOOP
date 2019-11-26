package HeroClasses;

import Map.TerrainType;
import common.WizardConstants;

public class Wizard extends Hero {
    public Wizard(int x, int y) {
        super(x, y, WizardConstants.WIZARD_BASE_HP, WizardConstants.WIZARD_BONUS_HP_PER_LEVEL, TerrainType.Desert);
    }

    @Override
    public void hitByFirstAbility(Hero enemyHero, TerrainType terrain) {
        enemyHero.useFirstAbility(this, terrain);
    }

    @Override
    public void useSecondAbilityGeneric(Hero enemyHero, TerrainType terrain, float raceModifier) {

    }

    @Override
    public void hitBySecondAbility(Hero enemyHero, TerrainType terrain) {
        enemyHero.useSecondAbility(this, terrain);
    }

    @Override
    public void useFirstAbilityGeneric(Hero enemyHero, TerrainType terrain, float raceModifier) {

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
    public void useSecondAbility(Knight enemyHero, TerrainType terrain) {

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
