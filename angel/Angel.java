package angel;

import hero.Knight;
import hero.Pyromancer;
import hero.Rogue;
import hero.Wizard;

public abstract class Angel {
    int x;
    int y;

    public Angel(int x, int y) {
        this.x = x;
        this.y = y;
    }
    abstract void affect(Knight knight);
    abstract void affect(Pyromancer pyromancer);
    abstract void affect(Rogue rogue);
    abstract void affect(Wizard wizard);
}
