package HeroClasses;

import Map.TerrainType;
import common.PyromancerConstants;

public class Pyromancer extends Hero {
    public Pyromancer(int x, int y) {
        super(x, y, PyromancerConstants.PYROMANCER_BASE_HP, PyromancerConstants.PYROMANCER_BONUS_HP_PER_LEVEL, TerrainType.Volcanic);
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
        // base damage + level adds
        int abilityDamage = PyromancerConstants.PYROMANCER_ABILITY1_BASE_DAMAGE + this.getLevel() * PyromancerConstants.PYROMANCER_ABILITY1_LEVEL_BONUS_MODIFIER;

        // compute modifiers
        float terrainDamageModifier = 1.0f;
        if(terrain == this.preferredTerrain) {
            terrainDamageModifier = PyromancerConstants.PYROMANCER_BONUS_TERRAIN_PERCENTAGE;
        }

        // calculate and deal total damage
        int totalDamage = Math.round(abilityDamage * (terrainDamageModifier * raceModifier));
        enemyHero.takeDamage(totalDamage);
    }

    @Override
    public void useSecondAbilityGeneric(Hero enemyHero, TerrainType terrain, float raceModifier) {
        // base damage + level adds
        int abilityDamage = PyromancerConstants.PYROMANCER_ABILITY2_BASE_DAMAGE + this.getLevel() * PyromancerConstants.PYROMANCER_ABILITY2_LEVEL_BONUS_MODIFIER;

        // compute modifiers
        float terrainDamageModifier = 1.0f;
        if(terrain == this.preferredTerrain) {
            terrainDamageModifier = PyromancerConstants.PYROMANCER_BONUS_TERRAIN_PERCENTAGE;
        }

        // calculate and deal total damage
        int totalDamage = Math.round(abilityDamage * (terrainDamageModifier * raceModifier));
        enemyHero.takeDamage(totalDamage);

        // calculate per round damage
        int perRoundDamage = PyromancerConstants.PYROMANCER_ABILITY2_OVER_TIME_DAMAGE + this.getLevel() * PyromancerConstants.PYROMANCER_ABILITY2_OVER_TIME_LEVEL_BONUS_MODIFIER;

        // add ignition effect
        enemyHero.addOverTimeEffect(OverTimeEffects.Ignited, PyromancerConstants.PYROMANCER_ABILITY2_ROUNDS_IGNITED, perRoundDamage);
    }


    @Override
    public void useFirstAbility(Knight enemyHero, TerrainType terrain) {
        // get race modifier
        float raceModifier = PyromancerConstants.PYROMANCER_ABILITY1_KNIGHT_MODIFIER;

        // use ability
        useFirstAbilityGeneric(enemyHero, terrain, raceModifier);
    }

    @Override
    public void useFirstAbility(Pyromancer enemyHero, TerrainType terrain) {
        // get race modifier
        float raceModifier = PyromancerConstants.PYROMANCER_ABILITY1_PYROMANCER_MODIFIER;

        // use ability
        useFirstAbilityGeneric(enemyHero, terrain, raceModifier);
    }

    @Override
    public void useFirstAbility(Rogue enemyHero, TerrainType terrain) {
        // get race modifier
        float raceModifier = PyromancerConstants.PYROMANCER_ABILITY1_ROGUE_MODIFIER;

        // use ability
        useFirstAbilityGeneric(enemyHero, terrain, raceModifier);
    }

    @Override
    public void useFirstAbility(Wizard enemyHero, TerrainType terrain) {
        // get race modifier
        float raceModifier = PyromancerConstants.PYROMANCER_ABILITY1_WIZARD_MODIFIER;

        // use ability
        useFirstAbilityGeneric(enemyHero, terrain, raceModifier);
    }

    @Override
    public void useSecondAbility(Knight enemyHero, TerrainType terrain) {
        // get race modifier
        float raceModifier = PyromancerConstants.PYROMANCER_ABILITY2_KNIGHT_MODIFIER;

        // use ability
        useSecondAbilityGeneric(enemyHero, terrain, raceModifier);
    }

    @Override
    public void useSecondAbility(Pyromancer enemyHero, TerrainType terrain) {
        // get race modifier
        float raceModifier = PyromancerConstants.PYROMANCER_ABILITY2_PYROMANCER_MODIFIER;

        // use ability
        useSecondAbilityGeneric(enemyHero, terrain, raceModifier);
    }

    @Override
    public void useSecondAbility(Rogue enemyHero, TerrainType terrain) {
        // get race modifier
        float raceModifier = PyromancerConstants.PYROMANCER_ABILITY2_ROGUE_MODIFIER;

        // use ability
        useSecondAbilityGeneric(enemyHero, terrain, raceModifier);
    }

    @Override
    public void useSecondAbility(Wizard enemyHero, TerrainType terrain) {
        // get race modifier
        float raceModifier = PyromancerConstants.PYROMANCER_ABILITY2_WIZARD_MODIFIER;

        // use ability
        useSecondAbilityGeneric(enemyHero, terrain, raceModifier);
    }
}
