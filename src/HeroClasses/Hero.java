package HeroClasses;

import Map.TerrainType;
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

    public Hero(int x, int y, int hp, int bonusHpPerLevel, TerrainType preferredTerrain) {
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

    public boolean isAlive() {
        return isAlive;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean hasSameCoordsAs(Hero enemyHero) {
        if(this.x == enemyHero.getX() && this.y == enemyHero.getY()) {
            return true;
        }
        return false;
    }

    public void applyOverTimeEffects() {
        // return if does not have damage effect
        if(overTimeEffect == OverTimeEffects.None) {
            return;
        }

        takeUnmonitoredDamage(this.overTimeDamage);
        roundsLeftOfOverTimeEffect--;

        // remove over time effect if rounds passed
        if(overTimeEffect != OverTimeEffects.None && roundsLeftOfOverTimeEffect == 0) {
            overTimeEffect = OverTimeEffects.None;
            overTimeDamage = 0;
        }
    }

    public void moveUp() {
        // move only if not incapacitated
        if(overTimeEffect != OverTimeEffects.Incapacitated) {
            x--;
        }
    }
    public void moveDown() {
        // move only if not incapacitated
        if(overTimeEffect != OverTimeEffects.Incapacitated) {
            x++;
        }
    }

    public void moveLeft() {
        // move only if not incapacitated
        if(overTimeEffect != OverTimeEffects.Incapacitated) {
            y--;
        }
    }

    public void moveRight() {
        // move only if not incapacitated
        if(overTimeEffect != OverTimeEffects.Incapacitated) {
            y++;
            return;
        }
    }

    public int getHp() {
        return hp;
    }

    public int getMaxHp() { return maxHp; }

    private void takeUnmonitoredDamage(int dmg) {
        this.hp -= dmg;

        // update status if hp goes to 0 or below
        if(this.hp <= 0) {
            isAlive = false;
        }
    }

    public void takeDamage(int dmg, float raceModifier) {
        if(lastDamageTakenCounter == Constants.ABILITIES_PER_ROUND) {
            lastDamageTaken = 0;
            lastDamageTakenCounter = 0;
        }

        // add dmg taken without race modifier
        lastDamageTaken += dmg;
        lastDamageTakenCounter++;

        // compute dmg with race modifier and subtract it from hp
        dmg = Math.round(dmg * raceModifier);
        this.hp -= dmg;

        // update status if hp goes to 0 or below
        if(this.hp <= 0) {
            isAlive = false;
        }
    }

    public int getXp() {
        return this.xp;
    }

    public void addXp(int enemyLevel) {
        // compute temp xp based on enemyLevel
        int tempExp = Math.max(0, Constants.XP_CONSTANT1 - (this.level - enemyLevel) * Constants.XP_CONSTANT2);
        this.xp += tempExp;

        // update level based on total xp
        while(this.xp >= Constants.LEVEL_UP_CONSTANT1 + this.level * Constants.LEVEL_UP_CONSTANT2) {
            this.level++;
            this.maxHp += this.bonusHpPerLevel;
            this.hp = this.maxHp;
        }
    }

    public int getLevel() {
        return level;
    }

    public OverTimeEffects getOverTimeEffect() {
        return this.overTimeEffect;
    }

    public int getLastDamageTaken() {
        return lastDamageTaken;
    }

    public void addOverTimeEffect(OverTimeEffects effect, int duration, int damage) {
        this.overTimeEffect = effect;
        this.roundsLeftOfOverTimeEffect = duration;
        this.overTimeDamage = damage;
    }


    // return damage dealt without race modifiers, also applying over time effects
    public abstract void useFirstAbility(Hero enemyHero, TerrainType terrain);
    public abstract void useSecondAbility(Hero enemyHero, TerrainType terrain);

    // double dispatch "accept" methods
    public abstract float provideFirstAbilityRaceModifier(Hero enemyHero);
    public abstract float provideSecondAbilityRaceModifier(Hero enemyHero);



    // double dispatch "interact with" methods
    public abstract float getFirstAbilityRaceModifier(Knight enemyHero);
    public abstract float getFirstAbilityRaceModifier(Pyromancer enemyHero);
    public abstract float getFirstAbilityRaceModifier(Rogue enemyHero);
    public abstract float getFirstAbilityRaceModifier(Wizard enemyHero);


    public abstract float getSecondAbilityRaceModifier(Knight enemyHero);
    public abstract float getSecondAbilityRaceModifier(Pyromancer enemyHero);
    public abstract float getSecondAbilityRaceModifier(Rogue enemyHero);
    public abstract float getSecondAbilityRaceModifier(Wizard enemyHero);

    @Override
    public String toString() {
        String res = "";
        res += ("Class: " + this.getClass().getName() + "\n");
        res += ("IsAlive: " + isAlive + "\n");
        res += ("Coords " + x + " " + y) + "\n";
        res += ("Hp: " + hp + "\n");
        res += ("BonuHpPerLevel: " + bonusHpPerLevel + "\n");
        res += ("Level: " + level + "\n");
        res += ("Xp: " + xp + "\n");
        res += ("Preffered terrain: " + preferredTerrain + "\n");
        res += ("Current over time effect: " + overTimeEffect + " for " + roundsLeftOfOverTimeEffect + " rounds\n");
        res += ("Current over time damage: " + overTimeDamage + " \n");
        res += ("Damage taken(without race modifier): " + lastDamageTaken + "\n\n");
        return res;
    }
}
