package angel;

import common.AngelConstants;
import hero.Knight;
import hero.Pyromancer;
import hero.Rogue;
import hero.Wizard;

public final class XPAngel extends Angel {
    public XPAngel(int x, int y) {
        super(x, y);
    }

    @Override
    public void affect(final Knight knight) {
        if(knight.isAlive() == false) {
            return;
        }
        knight.addXpOutsideBattle(AngelConstants.XPANGEL_KNIGHT_BONUS_XP);
    }

    @Override
    public void affect(final Pyromancer pyromancer) {
        if(pyromancer.isAlive() == false) {
            return;
        }
        pyromancer.addXpOutsideBattle(AngelConstants.XPANGEL_PYROMANCER_BONUS_XP);
    }

    @Override
    public void affect(final Rogue rogue) {
        if(rogue.isAlive() == false) {
            return;
        }
        rogue.addXpOutsideBattle(AngelConstants.XPANGEL_ROGUE_BONUS_XP);
    }

    @Override
    public void affect(final Wizard wizard) {
        if(wizard.isAlive() == false) {
            return;
        }
        wizard.addXpOutsideBattle(AngelConstants.XPANGEL_WIZARD_BONUS_XP);
    }
}
