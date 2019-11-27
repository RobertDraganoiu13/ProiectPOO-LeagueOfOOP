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
        int abilityDamage = RogueConstants.ROGUE_ABILITY1_BASE_DAMAGE + this.getLevel() * RogueConstants.ROGUE_ABILITY1_LEVEL_BONUS_MODIFIER;

        // compute modifiers
        float terrainDamageModifier = 1.0f;
        float critDamageModifier = 1.0f;
        if(terrain == this.preferredTerrain) {
            if(backstabHits == RogueConstants.ROGUE_ABILITY1_BACKSTAB_ROUNDS - 1) {
                critDamageModifier = RogueConstants.ROGUE_ABILITY1_CRIT_MODIFIER;
            }
            terrainDamageModifier = RogueConstants.ROGUE_BONUS_TERRAIN_PERCENTAGE;
        }

        // increment backstab hits
        backstabHits = (backstabHits + 1) % RogueConstants.ROGUE_ABILITY1_BACKSTAB_ROUNDS;

        // calculate and deal total damage
        int totalDamage = Math.round(abilityDamage * (terrainDamageModifier * raceModifier * critDamageModifier));
        enemyHero.takeDamage(totalDamage);
    }

    @Override
    public void useSecondAbilityGeneric(Hero enemyHero, TerrainType terrain, float raceModifier) {
        // base damage + level adds
        int abilityDamage = RogueConstants.ROGUE_ABILITY2_BASE_DAMAGE + this.getLevel() * RogueConstants.ROGUE_ABILITY2_LEVEL_BONUS_MODIFIER;

        // compute modifiers
        float terrainDamageModifier = 1.0f;
        float critDamageModifier = 1.0f;
        if(terrain == this.preferredTerrain) {
            terrainDamageModifier = RogueConstants.ROGUE_BONUS_TERRAIN_PERCENTAGE;
        }

        // TODO: complete second ability

        // calculate and deal total damage
        int totalDamage = Math.round(abilityDamage * (terrainDamageModifier * raceModifier * critDamageModifier));
        enemyHero.takeDamage(totalDamage);
    }

    @Override
    public void useFirstAbility(Knight enemyHero, TerrainType terrain) {
        // get race modifier
        float raceModifier = RogueConstants.ROGUE_ABILITY1_KNIGHT_MODIFIER;

        // use ability
        useFirstAbilityGeneric(enemyHero, terrain, raceModifier);
    }

    @Override
    public void useFirstAbility(Pyromancer enemyHero, TerrainType terrain) {
        // get race modifier
        float raceModifier = RogueConstants.ROGUE_ABILITY1_PYROMANCER_MODIFIER;

        // use ability
        useFirstAbilityGeneric(enemyHero, terrain, raceModifier);
    }

    @Override
    public void useFirstAbility(Rogue enemyHero, TerrainType terrain) {
        // get race modifier
        float raceModifier = RogueConstants.ROGUE_ABILITY1_ROGUE_MODIFIER;

        // use ability
        useFirstAbilityGeneric(enemyHero, terrain, raceModifier);
    }

    @Override
    public void useFirstAbility(Wizard enemyHero, TerrainType terrain) {
        // get race modifier
        float raceModifier = RogueConstants.ROGUE_ABILITY1_WIZARD_MODIFIER;

        // use ability
        useFirstAbilityGeneric(enemyHero, terrain, raceModifier);
    }

    @Override
    public void useSecondAbility(Knight enemyHero, TerrainType terrain) {
        // get race modifier
        float raceModifier = RogueConstants.ROGUE_ABILITY2_KNIGHT_MODIFIER;

        // use ability
        useSecondAbilityGeneric(enemyHero, terrain, raceModifier);
    }

    @Override
    public void useSecondAbility(Pyromancer enemyHero, TerrainType terrain) {
        // get race modifier
        float raceModifier = RogueConstants.ROGUE_ABILITY2_PYROMANCER_MODIFIER;

        // use ability
        useSecondAbilityGeneric(enemyHero, terrain, raceModifier);
    }

    @Override
    public void useSecondAbility(Rogue enemyHero, TerrainType terrain) {
        // get race modifier
        float raceModifier = RogueConstants.ROGUE_ABILITY2_ROGUE_MODIFIER;

        // use ability
        useSecondAbilityGeneric(enemyHero, terrain, raceModifier);
    }

    @Override
    public void useSecondAbility(Wizard enemyHero, TerrainType terrain) {
        // get race modifier
        float raceModifier = RogueConstants.ROGUE_ABILITY2_WIZARD_MODIFIER;

        // use ability
        useSecondAbilityGeneric(enemyHero, terrain, raceModifier);
    }
}
