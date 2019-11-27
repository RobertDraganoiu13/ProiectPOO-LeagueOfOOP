package HeroClasses;

import Map.TerrainType;
import common.PyromancerConstants;

public class Pyromancer extends Hero {
    public Pyromancer(int x, int y) {
        super(x, y, PyromancerConstants.PYROMANCER_BASE_HP, PyromancerConstants.PYROMANCER_BONUS_HP_PER_LEVEL, TerrainType.Volcanic);
    }

    @Override
    public void useFirstAbility(Hero enemyHero, TerrainType terrain) {
        // base damage + level adds
        int abilityDamage = PyromancerConstants.PYROMANCER_ABILITY1_BASE_DAMAGE + this.getLevel() * PyromancerConstants.PYROMANCER_ABILITY1_LEVEL_BONUS_MODIFIER;

        // compute terrain modifier
        float terrainDamageModifier = 1.0f;
        if(terrain == this.preferredTerrain) {
            terrainDamageModifier = PyromancerConstants.PYROMANCER_BONUS_TERRAIN_PERCENTAGE_MODIFIER;
        }

        // calculate and deal damage
        int damage = Math.round(abilityDamage * terrainDamageModifier);
        enemyHero.takeDamage(damage, enemyHero.provideFirstAbilityRaceModifier(this));
    }

    @Override
    public void useSecondAbility(Hero enemyHero, TerrainType terrain) {
        // base damage + level adds
        int abilityDamage = PyromancerConstants.PYROMANCER_ABILITY2_BASE_DAMAGE + this.getLevel() * PyromancerConstants.PYROMANCER_ABILITY2_LEVEL_BONUS_MODIFIER;
        int abilityOverTimeDamage = PyromancerConstants.PYROMANCER_ABILITY2_OVER_TIME_BASE_DAMAGE + this.getLevel() * PyromancerConstants.PYROMANCER_ABILITY2_OVER_TIME_LEVEL_BONUS_MODIFIER;

        // compute terrain modifier
        float terrainDamageModifier = 1.0f;
        if(terrain == this.preferredTerrain) {
            terrainDamageModifier = PyromancerConstants.PYROMANCER_BONUS_TERRAIN_PERCENTAGE_MODIFIER;
        }

        // apply modifier
        int damage = Math.round(abilityDamage * terrainDamageModifier);
        int overTimeDamage = Math.round(Math.round(abilityOverTimeDamage * terrainDamageModifier) * enemyHero.provideSecondAbilityRaceModifier(this));

        // apply over time effect and deal damage
        enemyHero.addOverTimeEffect(OverTimeEffects.Damaged, PyromancerConstants.PYROMANCER_ABILITY2_ROUNDS_IGNITED, overTimeDamage);
        enemyHero.takeDamage(damage, enemyHero.provideSecondAbilityRaceModifier(this));
    }

    @Override
    public float provideFirstAbilityRaceModifier(Hero enemyHero) {
        return enemyHero.getFirstAbilityRaceModifier(this);
    }

    @Override
    public float provideSecondAbilityRaceModifier(Hero enemyHero) {
        return enemyHero.getSecondAbilityRaceModifier(this);
    }

    @Override
    public float getFirstAbilityRaceModifier(Knight enemyHero) {
        return PyromancerConstants.PYROMANCER_ABILITY1_KNIGHT_MODIFIER;
    }

    @Override
    public float getFirstAbilityRaceModifier(Pyromancer enemyHero) {
        return PyromancerConstants.PYROMANCER_ABILITY1_PYROMANCER_MODIFIER;
    }

    @Override
    public float getFirstAbilityRaceModifier(Rogue enemyHero) {
        return PyromancerConstants.PYROMANCER_ABILITY1_ROGUE_MODIFIER;
    }

    @Override
    public float getFirstAbilityRaceModifier(Wizard enemyHero) {
        return PyromancerConstants.PYROMANCER_ABILITY1_WIZARD_MODIFIER;
    }

    @Override
    public float getSecondAbilityRaceModifier(Knight enemyHero) {
        return PyromancerConstants.PYROMANCER_ABILITY2_KNIGHT_MODIFIER;
    }

    @Override
    public float getSecondAbilityRaceModifier(Pyromancer enemyHero) {
        return PyromancerConstants.PYROMANCER_ABILITY2_PYROMANCER_MODIFIER;
    }

    @Override
    public float getSecondAbilityRaceModifier(Rogue enemyHero) {
        return PyromancerConstants.PYROMANCER_ABILITY2_ROGUE_MODIFIER;
    }

    @Override
    public float getSecondAbilityRaceModifier(Wizard enemyHero) {
        return PyromancerConstants.PYROMANCER_ABILITY2_WIZARD_MODIFIER;
    }
}
