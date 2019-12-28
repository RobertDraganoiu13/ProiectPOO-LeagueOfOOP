package angel;

import common.AngelConstants;
import hero.Knight;
import hero.Pyromancer;
import hero.Rogue;
import hero.Wizard;

public final class LifeGiver extends Angel {
    public LifeGiver(String name, int x, int y) {
        super(name, x, y);
    }

    @Override
    public void affect(final Knight knight) {
        if(knight.isAlive() == false) {
            return;
        }
        knight.addHp(AngelConstants.LIFE_GIVER_KNIGHT_BONUS_HP);
    }

    @Override
    public void affect(final Pyromancer pyromancer) {
        if(pyromancer.isAlive() == false) {
            return;
        }
        pyromancer.addHp(AngelConstants.LIFE_GIVER_PYROMANCER_BONUS_HP);
    }

    @Override
    public void affect(final Rogue rogue) {
        if(rogue.isAlive() == false) {
            return;
        }
        rogue.addHp(AngelConstants.LIFE_GIVER_ROGUE_BONUS_HP);
    }

    @Override
    public void affect(final Wizard wizard) {
        if(wizard.isAlive() == false) {
            return;
        }
        wizard.addHp(AngelConstants.LIFE_GIVER_WIZARD_BONUS_HP);
    }
}
