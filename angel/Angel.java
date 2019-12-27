package angel;

import hero.Knight;
import hero.Pyromancer;
import hero.Rogue;
import hero.Wizard;

public interface Angel {
    void affect(Knight knight);
    void affect(Pyromancer pyromancer);
    void affect(Rogue rogue);
    void affect(Wizard wizard);
}
