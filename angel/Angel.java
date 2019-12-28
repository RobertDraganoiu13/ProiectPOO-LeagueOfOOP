package angel;

import hero.Knight;
import hero.Pyromancer;
import hero.Rogue;
import hero.Wizard;

public abstract class Angel {
    private String name;
    private int x;
    private int y;

    public Angel(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public abstract void affect(Knight knight);
    public abstract void affect(Pyromancer pyromancer);
    public abstract void affect(Rogue rogue);
    public abstract void affect(Wizard wizard);
}
