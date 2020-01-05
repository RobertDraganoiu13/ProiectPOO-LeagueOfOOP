package angel;

import hero.Knight;
import hero.Pyromancer;
import hero.Rogue;
import hero.Wizard;

public final class TheDoomer extends Angel {
    public TheDoomer(final int x, final int y) {
        super(AngelType.Bad, x, y);
    }

    @Override
    public boolean affect(final Knight knight) {
        if (!knight.isAlive()) {
            return false;
        }
        knight.takeUnmonitoredDamage(knight.getHp());
        return true;
    }

    @Override
    public boolean affect(final Pyromancer pyromancer) {
        if (!pyromancer.isAlive()) {
            return false;
        }
        pyromancer.takeUnmonitoredDamage(pyromancer.getHp());
        return true;
    }

    @Override
    public boolean affect(final Rogue rogue) {
        if (!rogue.isAlive()) {
            return false;
        }
        rogue.takeUnmonitoredDamage(rogue.getHp());
        return true;
    }

    @Override
    public boolean affect(final Wizard wizard) {
        if (!wizard.isAlive()) {
            return false;
        }
        wizard.takeUnmonitoredDamage(wizard.getHp());
        return true;
    }
}
