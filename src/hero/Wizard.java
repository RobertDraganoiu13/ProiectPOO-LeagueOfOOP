package hero;

import map.TerrainType;
import common.WizardConstants;

public final class Wizard extends Hero {
    public Wizard(final int x, final int y) {
        super(x, y, WizardConstants.WIZARD_BASE_HP,
                WizardConstants.WIZARD_BONUS_HP_PER_LEVEL, TerrainType.Desert);
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
    public void useFirstAbility(final Hero enemyHero, final TerrainType terrain) {
        // base damage percentage + level adds
        float abilityDamagePercentage = WizardConstants.WIZARD_ABILITY1_BASE_PERCENTAGE
                + this.getLevel() * WizardConstants.WIZARD_ABILITY1_LEVEL_BONUS_PERCENTAGE;

        // compute terrain modifier
        float terrainDamageModifier = 1.0f;
        if (terrain == this.preferredTerrain) {
            terrainDamageModifier = WizardConstants.WIZARD_BONUS_TERRAIN_PERCENTAGE_MODIFIER;
        }

        // apply modifiers on percentage
        float totalPercent = abilityDamagePercentage * terrainDamageModifier;
        int damage = Math.round(enemyHero.provideFirstAbilityRaceModifier(this)
                * totalPercent * Math.min(WizardConstants.WIZARD_ABILITY1_MIN_DAMAGE_PERCENTAGE
                * enemyHero.getMaxHp(), enemyHero.getHp()));

        // deal damage
        enemyHero.takeDamage(damage, 1.0f);
    }

    @SuppressWarnings("checkstyle:WhitespaceAfter")
    @Override
    public void useSecondAbility(final Hero enemyHero, final TerrainType terrain) {
        // deal 0 damage and return if enemy hero is a wizard
        if (enemyHero.provideSecondAbilityRaceModifier(this) == 0.0f) {
            enemyHero.takeDamage(0, 0);
            return;
        }

        // base damage percentage + level adds
        float baseDamagePercentage
                = Math.min(WizardConstants.WIZARD_ABILITY2_MAX_PERCENTAGE,
                    WizardConstants.WIZARD_ABILITY2_BASE_PERCENTAGE
                        + this.getLevel() * WizardConstants.WIZARD_ABILITY2_LEVEL_BONUS_PERCENTAGE);

        // compute terrain modifier
        float terrainDamageModifier = 1.0f;
        if (terrain == this.preferredTerrain) {
            terrainDamageModifier = WizardConstants.WIZARD_BONUS_TERRAIN_PERCENTAGE_MODIFIER;
        }

        // apply modifier on percentage
        float totalPercent = baseDamagePercentage * terrainDamageModifier;

        // calculate and deal total damage
        int damageTaken = this.getLastDamageTaken();
        int damage = Math.round(enemyHero.provideSecondAbilityRaceModifier(this)
                                    * totalPercent * damageTaken);
        enemyHero.takeDamage(damage, 1.0f);
    }

    @Override
    public float getFirstAbilityRaceModifier(final Knight enemyHero) {
        return WizardConstants.WIZARD_ABILITY1_KNIGHT_MODIFIER;
    }

    @Override
    public float getFirstAbilityRaceModifier(final Pyromancer enemyHero) {
        return WizardConstants.WIZARD_ABILITY1_PYROMANCER_MODIFIER;
    }

    @Override
    public float getFirstAbilityRaceModifier(final Rogue enemyHero) {
        return WizardConstants.WIZARD_ABILITY1_ROGUE_MODIFIER;
    }

    @Override
    public float getFirstAbilityRaceModifier(final Wizard enemyHero) {
        return WizardConstants.WIZARD_ABILITY1_WIZARD_MODIFIER;
    }

    @Override
    public float getSecondAbilityRaceModifier(final Knight enemyHero) {
        return WizardConstants.WIZARD_ABILITY2_KNIGHT_MODIFIER;
    }

    @Override
    public float getSecondAbilityRaceModifier(final Pyromancer enemyHero) {
        return WizardConstants.WIZARD_ABILITY2_PYROMANCER_MODIFIER;
    }

    @Override
    public float getSecondAbilityRaceModifier(final Rogue enemyHero) {
        return WizardConstants.WIZARD_ABILITY2_ROGUE_MODIFIER;
    }

    @Override
    public float getSecondAbilityRaceModifier(final Wizard enemyHero) {
        return 0.0f; // no effect on wizard
    }
}
