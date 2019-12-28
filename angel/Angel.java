package angel;

import hero.Knight;
import hero.Pyromancer;
import hero.Rogue;
import hero.Wizard;

public abstract class Angel {
    private AngelType type;
    private int x;
    private int y;

    public Angel(AngelType type, int x, int y) {
        this.type = type;
        this.x = x;
        this.y = y;
    }

    public AngelType getType() { return type; }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public abstract boolean affect(Knight knight);
    public abstract boolean affect(Pyromancer pyromancer);
    public abstract boolean affect(Rogue rogue);
    public abstract boolean affect(Wizard wizard);
}
