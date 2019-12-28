package hero;

import angel.Angel;
import map.TerrainType;
import common.RogueConstants;
import strategy.HighHealthStrategy;
import strategy.LowHealthStrategy;
import strategy.StrategyManager;

public final class Rogue extends Hero {
    private int backstabHits;

    public Rogue(final int x, final int y) {
        super(x, y, RogueConstants.ROGUE_BASE_HP,
                RogueConstants.ROGUE_BONUS_HP_PER_LEVEL, TerrainType.Woods);
        this.backstabHits = 0;
    }

    @Override
    public void useFirstAbility(final Hero enemyHero, final TerrainType terrain) {
        // base damage + level adds
        int abilityDamage = RogueConstants.ROGUE_ABILITY1_BASE_DAMAGE
                + this.getLevel() * RogueConstants.ROGUE_ABILITY1_LEVEL_BONUS_MODIFIER;

        // compute modifiers
        float terrainDamageModifier = 1.0f;
        float critDamageModifier = 1.0f;
        if (terrain == this.preferredTerrain) {
            if (backstabHits % RogueConstants.ROGUE_ABILITY1_BACKSTAB_ROUNDS == 0) {
                critDamageModifier = RogueConstants.ROGUE_ABILITY1_CRIT_MODIFIER;
            }
            terrainDamageModifier = RogueConstants.ROGUE_BONUS_TERRAIN_PERCENTAGE_MODIFIER;
        }

        // increment backstab hits
        backstabHits = (backstabHits + 1) % RogueConstants.ROGUE_ABILITY1_BACKSTAB_ROUNDS;

        // calculate and deal total damage
        int totalDamage = Math.round(abilityDamage * (terrainDamageModifier * critDamageModifier));
        enemyHero.takeDamage(totalDamage, enemyHero.provideFirstAbilityRaceModifier(this) + additionalDamageModifier);
    }

    @Override
    public void useSecondAbility(final Hero enemyHero, final TerrainType terrain) {
        // base damage + level adds
        int abilityDamage = RogueConstants.ROGUE_ABILITY2_BASE_DAMAGE
                + this.getLevel() * RogueConstants.ROGUE_ABILITY2_LEVEL_BONUS_MODIFIER;

        // compute modifiers
        float terrainDamageModifier = 1.0f;
        int roundsIncapacitatedModifier = 1;
        if (terrain == this.preferredTerrain) {
            terrainDamageModifier = RogueConstants.ROGUE_BONUS_TERRAIN_PERCENTAGE_MODIFIER;
            roundsIncapacitatedModifier += roundsIncapacitatedModifier;
        }

        // apply modifiers
        int damage = Math.round(abilityDamage * terrainDamageModifier);
        int overTimeDamage = Math.round(damage * enemyHero.provideSecondAbilityRaceModifier(this) + additionalDamageModifier);

        // apply over time effect and deal damage
        enemyHero.addOverTimeEffect(OverTimeEffects.Incapacitated,
                RogueConstants.ROGUE_ABILITY2_ROUNDS_INCAPACITATED
                        * roundsIncapacitatedModifier, overTimeDamage);
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
        return RogueConstants.ROGUE_ABILITY1_KNIGHT_MODIFIER;
    }

    @Override
    public float getFirstAbilityRaceModifier(final Pyromancer enemyHero) {
        return RogueConstants.ROGUE_ABILITY1_PYROMANCER_MODIFIER;
    }

    @Override
    public float getFirstAbilityRaceModifier(final Rogue enemyHero) {
        return RogueConstants.ROGUE_ABILITY1_ROGUE_MODIFIER;
    }

    @Override
    public float getFirstAbilityRaceModifier(final Wizard enemyHero) {
        return RogueConstants.ROGUE_ABILITY1_WIZARD_MODIFIER;
    }

    @Override
    public float getSecondAbilityRaceModifier(final Knight enemyHero) {
        return RogueConstants.ROGUE_ABILITY2_KNIGHT_MODIFIER;
    }

    @Override
    public float getSecondAbilityRaceModifier(final Pyromancer enemyHero) {
        return RogueConstants.ROGUE_ABILITY2_PYROMANCER_MODIFIER;
    }

    @Override
    public float getSecondAbilityRaceModifier(final Rogue enemyHero) {
        return RogueConstants.ROGUE_ABILITY2_ROGUE_MODIFIER;
    }

    @Override
    public float getSecondAbilityRaceModifier(final Wizard enemyHero) {
        return RogueConstants.ROGUE_ABILITY2_WIZARD_MODIFIER;
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
        if(hp < maxHp / RogueConstants.ROGUE_SMALL_LIFE_DIVISOR) {
            strategyManager = new StrategyManager(new LowHealthStrategy(RogueConstants.ROGUE_STRATEGY1_DAMAGE_MODIFIER,RogueConstants.ROGUE_STRATEGY1_DIVISOR_FOR_LOST_HP));
        } else if(hp < maxHp / RogueConstants.ROGUE_BIG_LIFE_DIVISOR) {
            strategyManager = new StrategyManager(new LowHealthStrategy(RogueConstants.ROGUE_STRATEGY2_DAMAGE_MODIFIER, RogueConstants.ROGUE_STRATEGY2_DIVISOR_FOR_WON_HP));
        } else {
            strategyManager = new StrategyManager(new HighHealthStrategy());
        }
        strategyManager.applyStrategy(this);
    }

    @Override
    public void acceptAngel(Angel angel) {
        angel.affect(this);
    }
}
