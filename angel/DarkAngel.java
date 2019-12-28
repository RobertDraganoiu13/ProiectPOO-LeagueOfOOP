package angel;

import common.AngelConstants;
import hero.Knight;
import hero.Pyromancer;
import hero.Rogue;
import hero.Wizard;

public final class DarkAngel extends Angel {
    public DarkAngel(String name, int x, int y) {
        super(name, x, y);
    }

    @Override
    public void affect(final Knight knight) {
        if(knight.isAlive() == false) {
            return;
        }
        knight.takeUnmonitoredDamage(AngelConstants.DARK_ANGEL_KNIGHT_DMG);
    }

    @Override
    public void affect(final Pyromancer pyromancer) {
        if(pyromancer.isAlive() == false) {
            return;
        }
        pyromancer.takeUnmonitoredDamage(AngelConstants.DARK_ANGEL_PYROMANCER_DMG);
    }

    @Override
    public void affect(final Rogue rogue) {
        if(rogue.isAlive() == false) {
            return;
        }
        rogue.takeUnmonitoredDamage(AngelConstants.DARK_ANGEL_ROGUE_DMG);
    }

    @Override
    public void affect(final Wizard wizard) {
        if(wizard.isAlive() == false) {
            return;
        }
        wizard.takeUnmonitoredDamage(AngelConstants.DARK_ANGEL_WIZARD_DMG);
    }
}
