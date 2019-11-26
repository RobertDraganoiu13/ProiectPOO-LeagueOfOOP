package HeroClasses;

import Map.TerrainType;

public abstract class Hero {
    protected boolean isAlive;
    protected int x;
    protected int y;
    protected int hp;
    protected int bonusHpPerLevel;
    protected int xp;
    protected int level;
    protected TerrainType preferredTerrain;
    protected int roundsLeftOfDamageOverTime;
    protected int roundsLeftOfOverTimeEffect;
    protected OverTimeEffects overTimeEffect;

    public Hero(int x, int y, int hp, int bonusHpPerLevel, TerrainType preferredTerrain) {
        this.isAlive = true;
        this.x = x;
        this.y = y;
        this.hp = hp;
        this.bonusHpPerLevel = bonusHpPerLevel;
        this.xp = 0;
        this.level = 0;
        this.preferredTerrain = preferredTerrain;
        this.roundsLeftOfDamageOverTime = 0;
        this.overTimeEffect = OverTimeEffects.None;
    }

    public int getHp() {
        return hp;
    }

    public void takeDamage(int dmg) {
        this.hp = Math.max(this.hp - dmg, 0);
        if(this.hp == 0) {
            isAlive = false;
        }
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public OverTimeEffects getOverTimeEffect() {
        return this.overTimeEffect;
    }

    public void addOverTimeEffect(OverTimeEffects effect, int duration) {
        this.overTimeEffect = effect;
        this.roundsLeftOfOverTimeEffect = duration;
    }


    // double dispatch "accept" methods
    public abstract void hitByFirstAbility(Hero enemyHero, TerrainType terrain);
    public abstract void hitBySecondAbility(Hero enemyHero, TerrainType terrain);

    // generic Hero methods used by double dispatch methods
    public abstract void useFirstAbilityGeneric(Hero enemyHero, TerrainType terrain, float raceModifier);
    public abstract void useSecondAbilityGeneric(Hero enemyHero, TerrainType terrain, float raceModifier);

    // double dispatch "interact with" methods
    public abstract void useFirstAbility(Knight enemyHero, TerrainType terrain);
    public abstract void useFirstAbility(Pyromancer enemyHero, TerrainType terrain);
    public abstract void useFirstAbility(Rogue enemyHero, TerrainType terrain);
    public abstract void useFirstAbility(Wizard enemyHero, TerrainType terrain);


    public abstract void useSecondAbility(Knight enemyHero, TerrainType terrain);
    public abstract void useSecondAbility(Pyromancer enemyHero, TerrainType terrain);
    public abstract void useSecondAbility(Rogue enemyHero, TerrainType terrain);
    public abstract void useSecondAbility(Wizard enemyHero, TerrainType terrain);

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
        res += ("Current over time effect: " + overTimeEffect + " for " + roundsLeftOfOverTimeEffect + " rounds\n\n");
        return res;
    }
}
