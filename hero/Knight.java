package hero;

import angel.Angel;
import map.TerrainType;
import common.KnightConstants;
import strategy.HighHealthStrategy;
import strategy.LowHealthStrategy;
import strategy.MidHealthStrategy;
import strategy.StrategyManager;

public final class Knight extends Hero {
    public Knight(final int id, final int x, final int y) {
        super(id, x, y, KnightConstants.KNIGHT_BASE_HP,
                KnightConstants.KNIGHT_BONUS_HP_PER_LEVEL, TerrainType.Land);
    }

    @Override
    public void useFirstAbility(final Hero enemyHero, final TerrainType terrain) {
        // verify execute conditions
        boolean isExecuted = false;
        float executeHealthPercentage =
                Math.min(KnightConstants.KNIGHT_ABILITY1_EXECUTE_MAX_PERCENTAGE,
                        KnightConstants.KNIGHT_ABILITY1_EXECUTE_PERCENTAGE
                                + this.getLevel()
                                    * KnightConstants.KNIGHT_ABILITY1_EXECUTE_PERCENTAGE_BONUS);
        if (enemyHero.getHp() < enemyHero.getMaxHp() * executeHealthPercentage) {
            isExecuted = true;
        }

        // base damage + level adds
        int abilityDamage = KnightConstants.KNIGHT_ABILITY1_BASE_DAMAGE
                + this.getLevel() * KnightConstants.KNIGHT_ABILITY1_LEVEL_BONUS_MODIFIER;

        // compute terrain modifier
        float terrainDamageModifier = 1.0f;
        if (terrain == this.preferredTerrain) {
            terrainDamageModifier = KnightConstants.KNIGHT_BONUS_TERRAIN_PERCENTAGE_MODIFIER;
        }

        // calculate damage with terrain modifier
        int damage = Math.round(abilityDamage * terrainDamageModifier);

        System.out.println("knight damage1: " +damage);

        // calculate additional damage modifier
        float bonusModifier = 0f;
        if (enemyHero.provideFirstAbilityRaceModifier(this) != 1.0f) {
            bonusModifier = additionalDamageModifier;
        }

        // execute if damage is not enough to kill and execute conditions are met
        if (damage * (enemyHero.provideFirstAbilityRaceModifier(this) + bonusModifier) < enemyHero.getHp() && isExecuted) {
            enemyHero.takeDamage(enemyHero.getHp(), 0);
        }

        // deal damage
        enemyHero.takeDamage(damage, enemyHero.provideFirstAbilityRaceModifier(this) + bonusModifier);
    }

    @Override
    public void useSecondAbility(final Hero enemyHero, final TerrainType terrain) {
        // base damage + level adds
        int abilityDamage = KnightConstants.KNIGHT_ABILITY2_BASE_DAMAGE
                + this.getLevel() * KnightConstants.KNIGHT_ABILITY2_LEVEL_BONUS_MODIFIER;

        // compute terrain modifier
        float terrainDamageModifier = 1.0f;
        if (terrain == this.preferredTerrain) {
            terrainDamageModifier = KnightConstants.KNIGHT_BONUS_TERRAIN_PERCENTAGE_MODIFIER;
        }

        // add incapacity effect for 1 round
        enemyHero.addOverTimeEffect(OverTimeEffects.Incapacitated,
                KnightConstants.KNIGHT_ABILITY2_ROUNDS_INCAPACITATED, 0);

        // calculate and deal damage
        int damage = Math.round(abilityDamage * terrainDamageModifier);

        System.out.println("knight damage2: " +damage);

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
        return KnightConstants.KNIGHT_ABILITY1_KNIGHT_MODIFIER;
    }

    @Override
    public float getFirstAbilityRaceModifier(final Pyromancer enemyHero) {
        return KnightConstants.KNIGHT_ABILITY1_PYROMANCER_MODIFIER;
    }

    @Override
    public float getFirstAbilityRaceModifier(final Rogue enemyHero) {
        return KnightConstants.KNIGHT_ABILITY1_ROGUE_MODIFIER;
    }

    @Override
    public float getFirstAbilityRaceModifier(final Wizard enemyHero) {
        return KnightConstants.KNIGHT_ABILITY1_WIZARD_MODIFIER;
    }

    @Override
    public float getSecondAbilityRaceModifier(final Knight enemyHero) {
        return KnightConstants.KNIGHT_ABILITY2_KNIGHT_MODIFIER;
    }

    @Override
    public float getSecondAbilityRaceModifier(final Pyromancer enemyHero) {
        return KnightConstants.KNIGHT_ABILITY2_PYROMANCER_MODIFIER;
    }

    @Override
    public float getSecondAbilityRaceModifier(final Rogue enemyHero) {
        return KnightConstants.KNIGHT_ABILITY2_ROGUE_MODIFIER;
    }

    @Override
    public float getSecondAbilityRaceModifier(final Wizard enemyHero) {
        return KnightConstants.KNIGHT_ABILITY2_WIZARD_MODIFIER;
    }

    /**
     * Apply strategy based on current hp, using strategy pattern.
     */
    @Override
    public void applyStrategy() {
        // only apply to non incapacitated targets
        System.out.println(overTimeEffect);
        if(overTimeEffect == OverTimeEffects.Incapacitated) {
            return;
        }

        // select and apply strategy
        StrategyManager strategyManager;
        if(hp < maxHp / KnightConstants.KNIGHT_SMALL_LIFE_DIVISOR) {
            strategyManager = new StrategyManager(new LowHealthStrategy(KnightConstants.KNIGHT_STRATEGY2_DAMAGE_MODIFIER, KnightConstants.KNIGHT_STRATEGY2_DIVISOR_FOR_WON_HP));
        } else if(hp < maxHp / KnightConstants.KNIGHT_BIG_LIFE_DIVISOR) {
            strategyManager = new StrategyManager(new MidHealthStrategy(KnightConstants.KNIGHT_STRATEGY1_DAMAGE_MODIFIER, KnightConstants.KNIGHT_STRATEGY1_DIVISOR_FOR_LOST_HP));
        } else {
            strategyManager = new StrategyManager(new HighHealthStrategy());
        }

        System.out.println(strategyManager);
        strategyManager.applyStrategy(this);
    }

    @Override
    public boolean acceptAngel(Angel angel) {
        return angel.affect(this);
    }
}
