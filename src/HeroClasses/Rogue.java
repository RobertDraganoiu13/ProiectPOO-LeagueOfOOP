package HeroClasses;

import Map.TerrainType;
import common.RogueConstants;

public class Rogue extends Hero {
    private int backstabHits;

    public Rogue(int x, int y) {
        super(x, y, RogueConstants.ROGUE_BASE_HP, RogueConstants.ROGUE_BONUS_HP_PER_LEVEL, TerrainType.Woods);
        this.backstabHits = 0;
    }

    @Override
    public void useFirstAbility(Hero enemyHero, TerrainType terrain) {
        // base damage + level adds
        int abilityDamage = RogueConstants.ROGUE_ABILITY1_BASE_DAMAGE + this.getLevel() * RogueConstants.ROGUE_ABILITY1_LEVEL_BONUS_MODIFIER;

        // compute modifiers
        float terrainDamageModifier = 1.0f;
        float critDamageModifier = 1.0f;
        if(terrain == this.preferredTerrain) {
            if(backstabHits == RogueConstants.ROGUE_ABILITY1_BACKSTAB_ROUNDS - 1) {
                critDamageModifier = RogueConstants.ROGUE_ABILITY1_CRIT_MODIFIER;
            }
            terrainDamageModifier = RogueConstants.ROGUE_BONUS_TERRAIN_PERCENTAGE_MODIFIER;
        }

        // increment backstab hits
        backstabHits = (backstabHits + 1) % RogueConstants.ROGUE_ABILITY1_BACKSTAB_ROUNDS;

        // calculate and deal total damage
        int totalDamage = Math.round(abilityDamage * (terrainDamageModifier * critDamageModifier));
        enemyHero.takeDamage(totalDamage, enemyHero.provideFirstAbilityRaceModifier(this));
    }

    @Override
    public void useSecondAbility(Hero enemyHero, TerrainType terrain) {
        // base damage + level adds
        int abilityDamage = RogueConstants.ROGUE_ABILITY2_BASE_DAMAGE + this.getLevel() * RogueConstants.ROGUE_ABILITY2_LEVEL_BONUS_MODIFIER;

        // compute modifiers
        float terrainDamageModifier = 1.0f;
        int roundsIncapacitatedModifier = 1;
        if(terrain == this.preferredTerrain) {
            terrainDamageModifier = RogueConstants.ROGUE_BONUS_TERRAIN_PERCENTAGE_MODIFIER;
            roundsIncapacitatedModifier += roundsIncapacitatedModifier;
        }

        // apply modifiers
        int damage = Math.round(abilityDamage * terrainDamageModifier);
        int overTimeDamage = Math.round(damage * enemyHero.provideSecondAbilityRaceModifier(this));

        // apply over time effect and deal damage
        enemyHero.addOverTimeEffect(OverTimeEffects.Incapacitated, RogueConstants.ROGUE_ABILITY2_ROUNDS_INCAPACITATED * roundsIncapacitatedModifier, overTimeDamage);
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
        return RogueConstants.ROGUE_ABILITY1_KNIGHT_MODIFIER;
    }

    @Override
    public float getFirstAbilityRaceModifier(Pyromancer enemyHero) {
        return RogueConstants.ROGUE_ABILITY1_PYROMANCER_MODIFIER;
    }

    @Override
    public float getFirstAbilityRaceModifier(Rogue enemyHero) {
        return RogueConstants.ROGUE_ABILITY1_ROGUE_MODIFIER;
    }

    @Override
    public float getFirstAbilityRaceModifier(Wizard enemyHero) {
        return RogueConstants.ROGUE_ABILITY1_WIZARD_MODIFIER;
    }

    @Override
    public float getSecondAbilityRaceModifier(Knight enemyHero) {
        return RogueConstants.ROGUE_ABILITY2_KNIGHT_MODIFIER;
    }

    @Override
    public float getSecondAbilityRaceModifier(Pyromancer enemyHero) {
        return RogueConstants.ROGUE_ABILITY2_PYROMANCER_MODIFIER;
    }

    @Override
    public float getSecondAbilityRaceModifier(Rogue enemyHero) {
        return RogueConstants.ROGUE_ABILITY2_ROGUE_MODIFIER;
    }

    @Override
    public float getSecondAbilityRaceModifier(Wizard enemyHero) {
        return RogueConstants.ROGUE_ABILITY2_WIZARD_MODIFIER;
    }
}
