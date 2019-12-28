package hero;

import angel.Angel;
import map.TerrainType;
import common.PyromancerConstants;
import strategy.HighHealthStrategy;
import strategy.LowHealthStrategy;
import strategy.StrategyManager;

public final class Pyromancer extends Hero {
    public Pyromancer(final int id, final int x, final int y) {
        super(id, x, y, PyromancerConstants.PYROMANCER_BASE_HP,
                PyromancerConstants.PYROMANCER_BONUS_HP_PER_LEVEL, TerrainType.Volcanic);
    }

    @Override
    public void useFirstAbility(final Hero enemyHero, final TerrainType terrain) {
        // base damage + level adds
        int abilityDamage = PyromancerConstants.PYROMANCER_ABILITY1_BASE_DAMAGE
                + this.getLevel() * PyromancerConstants.PYROMANCER_ABILITY1_LEVEL_BONUS_MODIFIER;

        // compute terrain modifier
        float terrainDamageModifier = 1.0f;
        if (terrain == this.preferredTerrain) {
            terrainDamageModifier
                    = PyromancerConstants.PYROMANCER_BONUS_TERRAIN_PERCENTAGE_MODIFIER;
        }

        // calculate and deal damage
        int damage = Math.round(abilityDamage * terrainDamageModifier);
        enemyHero.takeDamage(damage, enemyHero.provideFirstAbilityRaceModifier(this) + additionalDamageModifier);
    }

    @Override
    public void useSecondAbility(final Hero enemyHero, final TerrainType terrain) {
        // base damage + level adds
        int abilityDamage = PyromancerConstants.PYROMANCER_ABILITY2_BASE_DAMAGE
                + this.getLevel() * PyromancerConstants.PYROMANCER_ABILITY2_LEVEL_BONUS_MODIFIER;
        int abilityOverTimeDamage = PyromancerConstants.PYROMANCER_ABILITY2_OVER_TIME_BASE_DAMAGE
                + this.getLevel()
                    * PyromancerConstants.PYROMANCER_ABILITY2_OVER_TIME_LEVEL_BONUS_MODIFIER;

        // compute terrain modifier
        float terrainDamageModifier = 1.0f;
        if (terrain == this.preferredTerrain) {
            terrainDamageModifier =
                    PyromancerConstants.PYROMANCER_BONUS_TERRAIN_PERCENTAGE_MODIFIER;
        }

        // apply modifier
        int damage = Math.round(abilityDamage * terrainDamageModifier);
        int overTimeDamage = Math.round(Math.round(abilityOverTimeDamage * terrainDamageModifier)
                                * enemyHero.provideSecondAbilityRaceModifier(this) + additionalDamageModifier);

        // apply over time effect and deal damage
        enemyHero.addOverTimeEffect(OverTimeEffects.Damaged,
                PyromancerConstants.PYROMANCER_ABILITY2_ROUNDS_IGNITED, overTimeDamage);
        enemyHero.takeDamage(damage, enemyHero.provideSecondAbilityRaceModifier(this) + additionalDamageModifier);
    }

    @Override
    public float provideFirstAbilityRaceModifier(final Hero enemyHero) {
        return enemyHero.getFirstAbilityRaceModifier(this);
    }

    @Override
    public float provideSecondAbilityRaceModifier(final Hero enemyHero) {
        return enemyHero.getSecondAbilityRaceModifier(this);
    }

    @Override
    public float getFirstAbilityRaceModifier(final Knight enemyHero) {
        return PyromancerConstants.PYROMANCER_ABILITY1_KNIGHT_MODIFIER;
    }

    @Override
    public float getFirstAbilityRaceModifier(final Pyromancer enemyHero) {
        return PyromancerConstants.PYROMANCER_ABILITY1_PYROMANCER_MODIFIER;
    }

    @Override
    public float getFirstAbilityRaceModifier(final Rogue enemyHero) {
        return PyromancerConstants.PYROMANCER_ABILITY1_ROGUE_MODIFIER;
    }

    @Override
    public float getFirstAbilityRaceModifier(final Wizard enemyHero) {
        return PyromancerConstants.PYROMANCER_ABILITY1_WIZARD_MODIFIER;
    }

    @Override
    public float getSecondAbilityRaceModifier(final Knight enemyHero) {
        return PyromancerConstants.PYROMANCER_ABILITY2_KNIGHT_MODIFIER;
    }

    @Override
    public float getSecondAbilityRaceModifier(final Pyromancer enemyHero) {
        return PyromancerConstants.PYROMANCER_ABILITY2_PYROMANCER_MODIFIER;
    }

    @Override
    public float getSecondAbilityRaceModifier(final Rogue enemyHero) {
        return PyromancerConstants.PYROMANCER_ABILITY2_ROGUE_MODIFIER;
    }

    @Override
    public float getSecondAbilityRaceModifier(final Wizard enemyHero) {
        return PyromancerConstants.PYROMANCER_ABILITY2_WIZARD_MODIFIER;
    }

    /**
     * Apply strategy based on current hp, using strategy pattern.
     */
    @Override
    public void applyStrategy() {
        // only apply to non incapacitated targets
        if(overTimeEffect != OverTimeEffects.None) {
            return;
        }

        // select and apply strategy
        StrategyManager strategyManager;
        if(hp < maxHp / PyromancerConstants.PYROMANCER_SMALL_LIFE_DIVISOR) {
            strategyManager = new StrategyManager(new LowHealthStrategy(PyromancerConstants.PYROMANCER_STRATEGY1_DAMAGE_MODIFIER, PyromancerConstants.PYROMANCER_STRATEGY1_DIVISOR_FOR_LOST_HP));
        } else if(hp < maxHp / PyromancerConstants.PYROMANCER_BIG_LIFE_DIVISOR) {
            strategyManager = new StrategyManager(new LowHealthStrategy(PyromancerConstants.PYROMANCER_STRATEGY2_DAMAGE_MODIFIER, PyromancerConstants.PYROMANCER_STRATEGY2_DIVISOR_FOR_WON_HP));
        } else {
            strategyManager = new StrategyManager(new HighHealthStrategy());
        }
        strategyManager.applyStrategy(this);
    }

    @Override
    public boolean acceptAngel(Angel angel) {
        return angel.affect(this);
    }
}
