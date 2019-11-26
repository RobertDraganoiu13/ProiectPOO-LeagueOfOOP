package HeroClasses;

import Map.TerrainType;
import common.KnightConstants;
import common.PyromancerConstants;
import common.RogueConstants;
import common.WizardConstants;

public class Knight extends Hero {
    public Knight(int x, int y) {
        super(x, y, KnightConstants.KNIGHT_BASE_HP, KnightConstants.KNIGHT_BONUS_HP_PER_LEVEL, TerrainType.Land, KnightConstants.KNIGHT_BONUS_TERRAIN_PERCENTAGE);
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
        // execute if under 20% + 1% / level percentage of life; make sure percentage is <= 40%
        float executeHealthPercentage =
                Math.min(KnightConstants.KNIGHT_ABILITY1_EXECUTE_MAX_PERCENTAGE,
                        KnightConstants.KNIGHT_ABILITY1_EXECUTE_PERCENTAGE + this.getLevel() * KnightConstants.KNIGHT_ABILITY1_EXECUTE_PERCENTAGE_BONUS);
        if(enemyHero.getHp() < KnightConstants.KNIGHT_BASE_HP * executeHealthPercentage) {
            enemyHero.takeDamage(enemyHero.getHp());
        }

        // base damage + level adds
        int abilityDamage = KnightConstants.KNIGHT_ABILITY1_BASE_DAMAGE + this.getLevel() * KnightConstants.KNIGHT_ABILITY1_LEVEL_BONUS_MODIFIER;

        // compute modifiers
        float terrainDamageModifier = 1.0f;
        if(terrain == this.preferredTerrain) {
            terrainDamageModifier = KnightConstants.KNIGHT_BONUS_TERRAIN_PERCENTAGE;
        }
        float raceModifier = KnightConstants.KNIGHT_ABILITY1_KNIGHT_MODIFIER;

        // calculate and deal total damage
        int totalDamage = Math.round(abilityDamage * terrainDamageModifier * raceModifier);
        enemyHero.takeDamage(totalDamage);
    }

    @Override
    public void useFirstAbility(Pyromancer enemyHero, TerrainType terrain) {
        // execute if under 20% + 1% / level percentage of life; make sure percentage is <= 40%
        float executeHealthPercentage =
                Math.min(KnightConstants.KNIGHT_ABILITY1_EXECUTE_MAX_PERCENTAGE,
                        KnightConstants.KNIGHT_ABILITY1_EXECUTE_PERCENTAGE + this.getLevel() * KnightConstants.KNIGHT_ABILITY1_EXECUTE_PERCENTAGE_BONUS);
        if(enemyHero.getHp() < PyromancerConstants.PYROMANCER_BASE_HP * executeHealthPercentage) {
            enemyHero.takeDamage(enemyHero.getHp());
        }

        // base damage + level adds
        int abilityDamage = KnightConstants.KNIGHT_ABILITY1_BASE_DAMAGE + this.getLevel() * KnightConstants.KNIGHT_ABILITY1_LEVEL_BONUS_MODIFIER;

        // compute modifiers
        float terrainDamageModifier = 1.0f;
        if(terrain == this.preferredTerrain) {
            terrainDamageModifier = KnightConstants.KNIGHT_BONUS_TERRAIN_PERCENTAGE;
        }
        float raceModifier = KnightConstants.KNIGHT_ABILITY1_PYROMANCER_MODIFIER;

        // calculate and deal total damage
        int totalDamage = Math.round(abilityDamage * terrainDamageModifier * raceModifier);
        enemyHero.takeDamage(totalDamage);
    }

    @Override
    public void useFirstAbility(Rogue enemyHero, TerrainType terrain) {
        // execute if under 20% + 1% / level percentage of life; make sure percentage is <= 40%
        float executeHealthPercentage =
                Math.min(KnightConstants.KNIGHT_ABILITY1_EXECUTE_MAX_PERCENTAGE,
                        KnightConstants.KNIGHT_ABILITY1_EXECUTE_PERCENTAGE + this.getLevel() * KnightConstants.KNIGHT_ABILITY1_EXECUTE_PERCENTAGE_BONUS);
        if(enemyHero.getHp() < RogueConstants.ROGUE_BASE_HP * executeHealthPercentage) {
            enemyHero.takeDamage(enemyHero.getHp());
        }

        // base damage + level adds
        int abilityDamage = KnightConstants.KNIGHT_ABILITY1_BASE_DAMAGE + this.getLevel() * KnightConstants.KNIGHT_ABILITY1_LEVEL_BONUS_MODIFIER;

        // compute modifiers
        float terrainDamageModifier = 1.0f;
        if(terrain == this.preferredTerrain) {
            terrainDamageModifier = KnightConstants.KNIGHT_BONUS_TERRAIN_PERCENTAGE;
        }
        float raceModifier = KnightConstants.KNIGHT_ABILITY1_ROGUE_MODIFIER;

        // calculate and deal total damage
        int totalDamage = Math.round(abilityDamage * terrainDamageModifier * raceModifier);
        enemyHero.takeDamage(totalDamage);
    }

    @Override
    public void useFirstAbility(Wizard enemyHero, TerrainType terrain) {
        // execute if under 20% + 1% / level percentage of life; make sure percentage is <= 40%
        float executeHealthPercentage =
                Math.min(KnightConstants.KNIGHT_ABILITY1_EXECUTE_MAX_PERCENTAGE,
                        KnightConstants.KNIGHT_ABILITY1_EXECUTE_PERCENTAGE + this.getLevel() * KnightConstants.KNIGHT_ABILITY1_EXECUTE_PERCENTAGE_BONUS);
        if(enemyHero.getHp() < WizardConstants.WIZARD_BASE_HP * executeHealthPercentage) {
            enemyHero.takeDamage(enemyHero.getHp());
        }

        // base damage + level adds
        int abilityDamage = KnightConstants.KNIGHT_ABILITY1_BASE_DAMAGE + this.getLevel() * KnightConstants.KNIGHT_ABILITY1_LEVEL_BONUS_MODIFIER;

        // compute modifiers
        float terrainDamageModifier = 1.0f;
        if(terrain == this.preferredTerrain) {
            terrainDamageModifier = KnightConstants.KNIGHT_BONUS_TERRAIN_PERCENTAGE;
        }
        float raceModifier = KnightConstants.KNIGHT_ABILITY1_WIZARD_MODIFIER;

        // calculate and deal total damage
        int totalDamage = Math.round(abilityDamage * terrainDamageModifier * raceModifier);
        enemyHero.takeDamage(totalDamage);
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
