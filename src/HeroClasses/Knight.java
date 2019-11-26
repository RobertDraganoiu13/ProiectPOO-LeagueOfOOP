package HeroClasses;

import Map.TerrainType;
import common.KnightConstants;
import common.PyromancerConstants;
import common.RogueConstants;
import common.WizardConstants;

public class Knight extends Hero {
    public Knight(int x, int y) {
        super(x, y, KnightConstants.KNIGHT_BASE_HP, KnightConstants.KNIGHT_BONUS_HP_PER_LEVEL, TerrainType.Land);
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
    public void useFirstAbilityGeneric(Hero enemyHero, TerrainType terrain, float raceModifier) {
        // execute if under 20% + 1% / level percentage of life; make sure percentage is <= 40%
        float executeHealthPercentage =
                Math.min(KnightConstants.KNIGHT_ABILITY1_EXECUTE_MAX_PERCENTAGE,
                        KnightConstants.KNIGHT_ABILITY1_EXECUTE_PERCENTAGE + this.getLevel() * KnightConstants.KNIGHT_ABILITY1_EXECUTE_PERCENTAGE_BONUS);
        if(enemyHero.getHp() < KnightConstants.KNIGHT_BASE_HP * executeHealthPercentage) {
            enemyHero.takeDamage(enemyHero.getHp());
        }

        // compute terrain modifier
        float terrainDamageModifier = 1.0f;
        if(terrain == this.preferredTerrain) {
            terrainDamageModifier = KnightConstants.KNIGHT_BONUS_TERRAIN_PERCENTAGE;
        }

        // base damage + level adds
        int abilityDamage = KnightConstants.KNIGHT_ABILITY1_BASE_DAMAGE + this.getLevel() * KnightConstants.KNIGHT_ABILITY1_LEVEL_BONUS_MODIFIER;

        // calculate and deal total damage
        int totalDamage = Math.round(abilityDamage * (terrainDamageModifier * raceModifier));
        enemyHero.takeDamage(totalDamage);
    }

    @Override
    public void useSecondAbilityGeneric(Hero enemyHero, TerrainType terrain, float raceModifier) {
        // base damage + level adds
        int abilityDamage = KnightConstants.KNIGHT_ABILITY2_BASE_DAMAGE + this.getLevel() * KnightConstants.KNIGHT_ABILITY2_LEVEL_BONUS_MODIFIER;

        // compute modifiers
        float terrainDamageModifier = 1.0f;
        if(terrain == this.preferredTerrain) {
            terrainDamageModifier = KnightConstants.KNIGHT_BONUS_TERRAIN_PERCENTAGE;
        }

        // calculate and deal total damage
        int totalDamage = Math.round(abilityDamage * (terrainDamageModifier * raceModifier));
        enemyHero.takeDamage(totalDamage);

        // add incapacity effect for 1 round
        enemyHero.addOverTimeEffect(OverTimeEffects.Incapacitated, KnightConstants.KNIGHT_ABILITY2_ROUNDS_INCAPACITATED);
    }

    @Override
    public void useFirstAbility(Knight enemyHero, TerrainType terrain) {
        // get race modifier
        float raceModifier = KnightConstants.KNIGHT_ABILITY1_KNIGHT_MODIFIER;

        // use ability
        useFirstAbilityGeneric(enemyHero, terrain, raceModifier);
    }

    @Override
    public void useFirstAbility(Pyromancer enemyHero, TerrainType terrain) {
        // get race modifier
        float raceModifier = KnightConstants.KNIGHT_ABILITY1_PYROMANCER_MODIFIER;

        // use ability
        useFirstAbilityGeneric(enemyHero, terrain, raceModifier);
    }

    @Override
    public void useFirstAbility(Rogue enemyHero, TerrainType terrain) {
        // get race modifier
        float raceModifier = KnightConstants.KNIGHT_ABILITY1_ROGUE_MODIFIER;

        // use ability
        useFirstAbilityGeneric(enemyHero, terrain, raceModifier);
    }

    @Override
    public void useFirstAbility(Wizard enemyHero, TerrainType terrain) {
        // get race modifier
        float raceModifier = KnightConstants.KNIGHT_ABILITY1_WIZARD_MODIFIER;

        // use ability
        useFirstAbilityGeneric(enemyHero, terrain, raceModifier);
    }

    @Override
    public void useSecondAbility(Knight enemyHero, TerrainType terrain) {
        // get race modifier
        float raceModifier = KnightConstants.KNIGHT_ABILITY2_KNIGHT_MODIFIER;

        // use ability
        useSecondAbilityGeneric(enemyHero, terrain, raceModifier);
    }

    @Override
    public void useSecondAbility(Pyromancer enemyHero, TerrainType terrain) {
        // get race modifier
        float raceModifier = KnightConstants.KNIGHT_ABILITY2_PYROMANCER_MODIFIER;

        // use ability
        useSecondAbilityGeneric(enemyHero, terrain, raceModifier);
    }

    @Override
    public void useSecondAbility(Rogue enemyHero, TerrainType terrain) {
        // get race modifier
        float raceModifier = KnightConstants.KNIGHT_ABILITY2_ROGUE_MODIFIER;

        // use ability
        useSecondAbilityGeneric(enemyHero, terrain, raceModifier);
    }

    @Override
    public void useSecondAbility(Wizard enemyHero, TerrainType terrain) {
        // get race modifier
        float raceModifier = KnightConstants.KNIGHT_ABILITY2_WIZARD_MODIFIER;

        // use ability
        useSecondAbilityGeneric(enemyHero, terrain, raceModifier);
    }
}
