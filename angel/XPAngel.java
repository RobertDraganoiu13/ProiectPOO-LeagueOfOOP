package angel;

import common.AngelConstants;
import hero.Knight;
import hero.Pyromancer;
import hero.Rogue;
import hero.Wizard;

public final class XPAngel extends Angel {
    public XPAngel(int x, int y) {
        super(AngelType.Good, x, y);
    }

    @Override
    public boolean affect(final Knight knight) {
        if(!knight.isAlive()) {
            return false;
        }
        knight.addXpOutsideBattle(AngelConstants.XPANGEL_KNIGHT_BONUS_XP);
        return true;
    }

    @Override
    public boolean affect(final Pyromancer pyromancer) {
        if(!pyromancer.isAlive()) {
            return false;
        }
        pyromancer.addXpOutsideBattle(AngelConstants.XPANGEL_PYROMANCER_BONUS_XP);
        return true;
    }

    @Override
    public boolean affect(final Rogue rogue) {
        if(!rogue.isAlive()) {
            return false;
        }
        rogue.addXpOutsideBattle(AngelConstants.XPANGEL_ROGUE_BONUS_XP);
        return true;
    }

    @Override
    public boolean affect(final Wizard wizard) {
        if(!wizard.isAlive()) {
            return false;
        }
        wizard.addXpOutsideBattle(AngelConstants.XPANGEL_WIZARD_BONUS_XP);
        return true;
    }
}
