package HeroClasses;

import Map.TerrainType;

public class Hero {
    protected int x;
    protected int y;
    protected int hp;
    protected int bonusHpPerLevel;
    protected int xp;
    protected int level;
    protected TerrainType preferredTerrain;
    protected float bonusPercentageOnPreferredTerrain;

    public Hero(int x, int y, int hp, int bonusHpPerLevel, TerrainType preferredTerrain, float bonusPercentageOnPreferredTerrain) {
        this.x = x;
        this.y = y;
        this.hp = hp;
        this.bonusHpPerLevel = bonusHpPerLevel;
        this.xp = 0;
        this.level = 0;
        this.preferredTerrain = preferredTerrain;
        this.bonusPercentageOnPreferredTerrain = bonusPercentageOnPreferredTerrain;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
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
}
