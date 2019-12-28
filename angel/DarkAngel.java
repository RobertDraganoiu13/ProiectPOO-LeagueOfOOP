package angel;

import common.AngelConstants;
import hero.Knight;
import hero.Pyromancer;
import hero.Rogue;
import hero.Wizard;
import main.GreatMagician;

public final class DarkAngel extends Angel {
    public DarkAngel(int x, int y) {
        super(AngelType.Bad, x, y);
    }

    @Override
    public boolean affect(final Knight knight) {
        if(!knight.isAlive()) {
            return false;
        }
        knight.takeUnmonitoredDamage(AngelConstants.DARK_ANGEL_KNIGHT_DMG);
        return true;
    }

    @Override
    public boolean affect(final Pyromancer pyromancer) {
        if(!pyromancer.isAlive()) {
            return false;
        }
        pyromancer.takeUnmonitoredDamage(AngelConstants.DARK_ANGEL_PYROMANCER_DMG);
        return true;
    }

    @Override
    public boolean affect(final Rogue rogue) {
        if(!rogue.isAlive()) {
            return false;
        }
        rogue.takeUnmonitoredDamage(AngelConstants.DARK_ANGEL_ROGUE_DMG);
        return true;
    }

    @Override
    public boolean affect(final Wizard wizard) {
        if(!wizard.isAlive()) {
            return false;
        }
        wizard.takeUnmonitoredDamage(AngelConstants.DARK_ANGEL_WIZARD_DMG);
        return true;
    }
}
