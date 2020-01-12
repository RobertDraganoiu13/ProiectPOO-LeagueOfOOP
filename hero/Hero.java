package hero;

import angel.Angel;
import main.GreatMagician;
import map.TerrainType;
import common.Constants;

public abstract class Hero {
    protected int id;
    protected boolean isAlive;
    protected int x;
    protected int y;
    protected int maxHp;
    protected int hp;
    protected int bonusHpPerLevel;
    protected int xp;
    protected int level;
    protected TerrainType preferredTerrain;
    protected float additionalDamageModifier;

    // over time damage management
    protected int roundsLeftOfDamageOverTime;
    protected int roundsLeftOfOverTimeEffect;
    protected OverTimeEffects overTimeEffect;
    protected int overTimeDamage;
    protected int lastDamageTaken;
    protected int lastDamageTakenCounter;

    public Hero(final int id, final int x, final int y, final int hp,
                final int bonusHpPerLevel, final TerrainType preferredTerrain) {
        this.id = id;
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
        this.additionalDamageModifier = 0;
    }

    public int getId() {
        return id;
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

    /**
     * Checks collision on map with another player.
     * @param enemyHero
     * @return
     */
    public final boolean hasSameCoordsAs(final Hero enemyHero) {
        if (this.x == enemyHero.getX() && this.y == enemyHero.getY()) {
            return true;
        }
        return false;
    }

    /**
     * Checks collision on map with an angel.
     * @param angel
     * @return
     */
    public final boolean hasSameCoordsAs(final Angel angel) {
        if (this.x == angel.getX() && this.y == angel.getY()) {
            return true;
        }
        return false;
    }

    /**
     * Applies damage from over time effects.
     */
    public final void applyOverTimeEffects() {
        // return if does not have damage effect
        if (overTimeEffect == OverTimeEffects.None) {
            return;
        }

        takeUnmonitoredDamage(this.overTimeDamage);
        roundsLeftOfOverTimeEffect--;
    }

    public void checkOverTimeEffects() {
        // remove over time effect if rounds passed
        if (overTimeEffect != OverTimeEffects.None && roundsLeftOfOverTimeEffect == 0) {
            overTimeEffect = OverTimeEffects.None;
            overTimeDamage = 0;
        }
    }

    /**
     * Move functions, also checking for paralysis/stun.
     */
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

    public final void addHp(int bonus) {
        hp += bonus;
        if(hp > maxHp) {
            hp = maxHp;
        }
    }

    public final void revive(int hp) {
        this.isAlive = true;
        this.hp = hp;
    }

    public final int getMaxHp() {
        return maxHp;
    }

    /**
     * Apply damage without adding race modifier and without saving last damage taken.
     * Used for over time dmg and angel dmg.
     * @param dmg
     */
    public void takeUnmonitoredDamage(final int dmg) {
        this.hp -= dmg;

        // update status if hp goes to 0 or below
        if (this.hp <= 0) {
            isAlive = false;
        }
    }

    /**
     * Apply damage after adding race modifier and save last damage taken (witout race modifier).
     * @param dmg
     * @param raceModifier
     */
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

    /**
     * Add xp and level up if next threshold is reached.
     * @param enemyLevel
     */
    public final void addXp(final int enemyLevel) {
        // compute temp xp based on enemyLevel
        int tempExp = Math.max(0, Constants.XP_CONSTANT1
                - (this.level - enemyLevel) * Constants.XP_CONSTANT2);
        this.xp += tempExp;

        // update level based on total xp
        while (this.xp >= Constants.LEVEL_UP_CONSTANT1
                + this.level * Constants.LEVEL_UP_CONSTANT2) {
            this.level++;

            // notify great magician
            var greatMagician = GreatMagician.getInstance();
            greatMagician.notifyLevelUp(this);

            this.maxHp += this.bonusHpPerLevel;
            this.hp = this.maxHp;
        }
    }

    public final void addXpOutsideBattle(final int xp) {
        this.xp += xp;

        // update level based on total xp
        while (this.xp >= Constants.LEVEL_UP_CONSTANT1
                + this.level * Constants.LEVEL_UP_CONSTANT2) {
            this.level++;

            // notify great magician
            var greatMagician = GreatMagician.getInstance();
            greatMagician.notifyLevelUp(this);

            this.maxHp += this.bonusHpPerLevel;
            this.hp = this.maxHp;
        }
    }

    public final void levelUp() {
        this.level++;

        // notify great magician
        var greatMagician = GreatMagician.getInstance();
        greatMagician.notifyLevelUp(this);

        this.xp = Constants.LEVEL_UP_CONSTANT1 + (this.level - 1) * Constants.LEVEL_UP_CONSTANT2;
        this.maxHp += this.bonusHpPerLevel;
        this.hp = this.maxHp;
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

    public void addToAdditionalDamageModifiers(float angelDamageModifiers) {
        this.additionalDamageModifier += angelDamageModifiers;
    }

    /**
     * Use abilities implemented by all hero types.
     * @param enemyHero
     * @param terrain
     */
    public abstract void useFirstAbility(Hero enemyHero, TerrainType terrain);
    public abstract void useSecondAbility(Hero enemyHero, TerrainType terrain);

    /**
     * Double dispatch "accept" methods which provide race modifiers for enemy hero.
     * @param enemyHero
     * @return
     */
    public abstract float provideFirstAbilityRaceModifier(Hero enemyHero);
    public abstract float provideSecondAbilityRaceModifier(Hero enemyHero);

    /**
     * Double dispatch "interact with" methods which return current race modifier for enemy hero.
     * @param enemyHero
     * @return
     */
    public abstract float getFirstAbilityRaceModifier(Knight enemyHero);
    public abstract float getFirstAbilityRaceModifier(Pyromancer enemyHero);
    public abstract float getFirstAbilityRaceModifier(Rogue enemyHero);
    public abstract float getFirstAbilityRaceModifier(Wizard enemyHero);

    public abstract float getSecondAbilityRaceModifier(Knight enemyHero);
    public abstract float getSecondAbilityRaceModifier(Pyromancer enemyHero);
    public abstract float getSecondAbilityRaceModifier(Rogue enemyHero);
    public abstract float getSecondAbilityRaceModifier(Wizard enemyHero);

    /**
     * Apply strategy using strategy pattern.
     */
    public abstract void applyStrategy();

    /**
     * Accept angel using visitor pattern.
     * @param angel
     */
    public abstract boolean acceptAngel(Angel angel);

}
