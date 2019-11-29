package hero;

import map.TerrainType;
import common.Constants;

public abstract class Hero {
    protected boolean isAlive;
    protected int x;
    protected int y;
    protected int maxHp;
    protected int hp;
    protected int bonusHpPerLevel;
    protected int xp;
    protected int level;
    protected TerrainType preferredTerrain;
    protected int roundsLeftOfDamageOverTime;
    protected int roundsLeftOfOverTimeEffect;
    protected OverTimeEffects overTimeEffect;
    protected int overTimeDamage;
    protected int lastDamageTaken;
    protected int lastDamageTakenCounter;

    public Hero(final int x, final int y, final int hp,
                final int bonusHpPerLevel, final TerrainType preferredTerrain) {
        this.isAlive = true;
        this.x = x;
        this.y = y;
        this.maxHp = hp;
        this.hp = hp;
        this.bonusHpPerLevel = bonusHpPerLevel;
        this.xp = 0;
        this.level = 0;
        this.preferredTerrain = preferredTerrain;
        this.roundsLeftOfDamageOverTime = 0;
        this.overTimeEffect = OverTimeEffects.None;
        this.overTimeDamage = 0;
        this.lastDamageTaken = 0;
        this.lastDamageTakenCounter = 0;
    }

    public final boolean isAlive() {
        return isAlive;
    }

    public final int getX() {
        return x;
    }

    public final int getY() {
        return y;
    }

    public final boolean hasSameCoordsAs(final Hero enemyHero) {
        if (this.x == enemyHero.getX() && this.y == enemyHero.getY()) {
            return true;
        }
        return false;
    }

    public final void applyOverTimeEffects() {
        // return if does not have damage effect
        if (overTimeEffect == OverTimeEffects.None) {
            return;
        }

        takeOverTimeDamage(this.overTimeDamage);
        roundsLeftOfOverTimeEffect--;

        // remove over time effect if rounds passed
        if (overTimeEffect != OverTimeEffects.None && roundsLeftOfOverTimeEffect == 0) {
            overTimeEffect = OverTimeEffects.None;
            overTimeDamage = 0;
        }
    }

    public final void moveUp() {
        // move only if not incapacitated
        if (overTimeEffect != OverTimeEffects.Incapacitated) {
            x--;
        }
    }
    public final void moveDown() {
        // move only if not incapacitated
        if (overTimeEffect != OverTimeEffects.Incapacitated) {
            x++;
        }
    }

    public final void moveLeft() {
        // move only if not incapacitated
        if (overTimeEffect != OverTimeEffects.Incapacitated) {
            y--;
        }
    }

    public final void moveRight() {
        // move only if not incapacitated
        if (overTimeEffect != OverTimeEffects.Incapacitated) {
            y++;
        }
    }

    public final int getHp() {
        return hp;
    }

    public final int getMaxHp() {
        return maxHp;
    }

    private void takeOverTimeDamage(final int dmg) {
        this.hp -= dmg;

        // update status if hp goes to 0 or below
        if (this.hp <= 0) {
            isAlive = false;
        }
    }

    public final void takeDamage(final int dmg, final float raceModifier) {
        if (lastDamageTakenCounter == Constants.ABILITIES_PER_ROUND) {
            lastDamageTaken = 0;
            lastDamageTakenCounter = 0;
        }

        // add dmg taken without race modifier
        lastDamageTaken += dmg;
        lastDamageTakenCounter++;

        // compute dmg with race modifier and subtract it from hp
        int realdmg = Math.round(dmg * raceModifier);
        this.hp -= realdmg;

        // update status if hp goes to 0 or below
        if (this.hp <= 0) {
            isAlive = false;
        }
    }

    public final int getXp() {
        return this.xp;
    }

    public final void addXp(final int enemyLevel) {
        // compute temp xp based on enemyLevel
        int tempExp = Math.max(0, Constants.XP_CONSTANT1
                - (this.level - enemyLevel) * Constants.XP_CONSTANT2);
        this.xp += tempExp;

        // update level based on total xp
        while (this.xp >= Constants.LEVEL_UP_CONSTANT1
                + this.level * Constants.LEVEL_UP_CONSTANT2) {
            this.level++;
            this.maxHp += this.bonusHpPerLevel;
            this.hp = this.maxHp;
        }
    }

    public final int getLevel() {
        return level;
    }

    public final OverTimeEffects getOverTimeEffect() {
        return this.overTimeEffect;
    }

    public final int getLastDamageTaken() {
        return lastDamageTaken;
    }

    public final void addOverTimeEffect(final OverTimeEffects effect,
                                        final int duration, final int damage) {
        this.overTimeEffect = effect;
        this.roundsLeftOfOverTimeEffect = duration;
        this.overTimeDamage = damage;
    }

    // use abilities implemented by all hero types
    public abstract void useFirstAbility(Hero enemyHero, TerrainType terrain);
    public abstract void useSecondAbility(Hero enemyHero, TerrainType terrain);

    // double dispatch "accept" methods which provide race modifiers for enemy hero
    public abstract float provideFirstAbilityRaceModifier(Hero enemyHero);
    public abstract float provideSecondAbilityRaceModifier(Hero enemyHero);

    // double dispatch "interact with" methods which return current race modifier for enemy hero
    public abstract float getFirstAbilityRaceModifier(Knight enemyHero);
    public abstract float getFirstAbilityRaceModifier(Pyromancer enemyHero);
    public abstract float getFirstAbilityRaceModifier(Rogue enemyHero);
    public abstract float getFirstAbilityRaceModifier(Wizard enemyHero);

    public abstract float getSecondAbilityRaceModifier(Knight enemyHero);
    public abstract float getSecondAbilityRaceModifier(Pyromancer enemyHero);
    public abstract float getSecondAbilityRaceModifier(Rogue enemyHero);
    public abstract float getSecondAbilityRaceModifier(Wizard enemyHero);
}
