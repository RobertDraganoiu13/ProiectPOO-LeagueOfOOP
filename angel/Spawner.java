package angel;

import common.AngelConstants;
import hero.Knight;
import hero.Pyromancer;
import hero.Rogue;
import hero.Wizard;

public final class Spawner extends Angel {
    public Spawner(int x, int y) {
        super(AngelType.Good, x, y);
    }

    @Override
    public boolean affect(final Knight knight) {
        if(knight.isAlive()) {
            return false;
        }
        knight.revive(AngelConstants.SPAWNER_KNIGHT_SET_HP);
        return true;
    }

    @Override
    public boolean affect(final Pyromancer pyromancer) {
        if(pyromancer.isAlive()) {
            return false;
        }
        pyromancer.revive(AngelConstants.SPAWNER_PYROMANCER_SET_HP);
        return true;
    }

    @Override
    public boolean affect(final Rogue rogue) {
        if(rogue.isAlive()) {
            return false;
        }
        rogue.revive(AngelConstants.SPAWNER_ROGUE_SET_HP);
        return true;
    }

    @Override
    public boolean affect(final Wizard wizard) {
        if(wizard.isAlive()) {
            return false;
        }
        wizard.revive(AngelConstants.SPAWNER_WIZARD_SET_HP);
        return true;
    }
}
