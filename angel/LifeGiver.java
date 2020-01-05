package angel;

import common.AngelConstants;
import hero.Knight;
import hero.Pyromancer;
import hero.Rogue;
import hero.Wizard;

public final class LifeGiver extends Angel {
    public LifeGiver(final int x, final int y) {
        super(AngelType.Good, x, y);
    }

    @Override
    public boolean affect(final Knight knight) {
        if (!knight.isAlive()) {
            return false;
        }
        knight.addHp(AngelConstants.LIFE_GIVER_KNIGHT_BONUS_HP);
        return true;
    }

    @Override
    public boolean affect(final Pyromancer pyromancer) {
        if (!pyromancer.isAlive()) {
            return false;
        }
        pyromancer.addHp(AngelConstants.LIFE_GIVER_PYROMANCER_BONUS_HP);
        return true;
    }

    @Override
    public boolean affect(final Rogue rogue) {
        if (!rogue.isAlive()) {
            return false;
        }
        rogue.addHp(AngelConstants.LIFE_GIVER_ROGUE_BONUS_HP);
        return true;
    }

    @Override
    public boolean affect(final Wizard wizard) {
        if (!wizard.isAlive()) {
            return false;
        }
        wizard.addHp(AngelConstants.LIFE_GIVER_WIZARD_BONUS_HP);
        return true;
    }
}
