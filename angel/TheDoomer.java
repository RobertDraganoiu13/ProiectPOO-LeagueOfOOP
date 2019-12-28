package angel;

import hero.Knight;
import hero.Pyromancer;
import hero.Rogue;
import hero.Wizard;

public final class TheDoomer extends Angel {
    public TheDoomer(String name, int x, int y) {
        super(name, x, y);
    }

    @Override
    public void affect(final Knight knight) {
        if(knight.isAlive() == false) {
            return;
        }
        knight.takeUnmonitoredDamage(knight.getHp());
    }

    @Override
    public void affect(final Pyromancer pyromancer) {
        if(pyromancer.isAlive() == false) {
            return;
        }
        pyromancer.takeUnmonitoredDamage(pyromancer.getHp());
    }

    @Override
    public void affect(final Rogue rogue) {
        if(rogue.isAlive() == false) {
            return;
        }
        rogue.takeUnmonitoredDamage(rogue.getHp());
    }

    @Override
    public void affect(final Wizard wizard) {
        if(wizard.isAlive() == false) {
            return;
        }
        wizard.takeUnmonitoredDamage(wizard.getHp());
    }
}
