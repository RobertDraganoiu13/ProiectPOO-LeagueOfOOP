package hero;

import map.TerrainType;
import common.KnightConstants;

public final class Knight extends Hero {
    private float ability1_KnightModifier;
    private float ability1_PyromancerModifier;
    private float ability1_RogueModifier;
    private float ability1_WizardModifier;

    private float ability2_KnightModifier;
    private float ability2_PyromancerModifier;
    private float ability2_RogueModifier;
    private float ability2_WizardModifier;

    public Knight(final int x, final int y) {
        super(x, y, KnightConstants.KNIGHT_BASE_HP,
                KnightConstants.KNIGHT_BONUS_HP_PER_LEVEL, TerrainType.Land);
    }

    @Override
    public void useFirstAbility(final Hero enemyHero, final TerrainType terrain) {
        // return player hp if execute conditions are met
        float executeHealthPercentage =
                Math.min(KnightConstants.KNIGHT_ABILITY1_EXECUTE_MAX_PERCENTAGE,
                        KnightConstants.KNIGHT_ABILITY1_EXECUTE_PERCENTAGE
                                + this.getLevel()
                                    * KnightConstants.KNIGHT_ABILITY1_EXECUTE_PERCENTAGE_BONUS);
        if (enemyHero.getHp() < enemyHero.getMaxHp() * executeHealthPercentage) {
            enemyHero.takeDamage(enemyHero.getHp(), 0);
        }

        // base damage + level adds
        int abilityDamage = KnightConstants.KNIGHT_ABILITY1_BASE_DAMAGE
                + this.getLevel() * KnightConstants.KNIGHT_ABILITY1_LEVEL_BONUS_MODIFIER;

        // compute terrain modifier
        float terrainDamageModifier = 1.0f;
        if (terrain == this.preferredTerrain) {
            terrainDamageModifier = KnightConstants.KNIGHT_BONUS_TERRAIN_PERCENTAGE_MODIFIER;
        }

        // calculate and deal total damage
        int damage = Math.round(abilityDamage * terrainDamageModifier);
        enemyHero.takeDamage(damage, enemyHero.provideFirstAbilityRaceModifier(this) + angelDamageModifiers);
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
        enemyHero.takeDamage(damage, enemyHero.provideSecondAbilityRaceModifier(this));
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
}
