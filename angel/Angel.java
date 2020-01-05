package angel;

import hero.Knight;
import hero.Pyromancer;
import hero.Rogue;
import hero.Wizard;

public abstract class Angel {
    private AngelType type;
    private int x;
    private int y;

    public Angel(final AngelType type, final int x, final int y) {
        this.type = type;
        this.x = x;
        this.y = y;
    }

    public final AngelType getType() {
        return type;
    }

    public final int getX() {
        return x;
    }

    public final int getY() {
        return y;
    }

    public abstract boolean affect(Knight knight);
    public abstract boolean affect(Pyromancer pyromancer);
    public abstract boolean affect(Rogue rogue);
    public abstract boolean affect(Wizard wizard);
}
