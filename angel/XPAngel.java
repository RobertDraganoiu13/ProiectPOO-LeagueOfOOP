package angel;

import common.AngelConstants;
import hero.Knight;
import hero.Pyromancer;
import hero.Rogue;
import hero.Wizard;
import observer.GreatMagician;

public final class XPAngel extends Angel {
    public XPAngel(final int x, final int y) {
        super(AngelType.Good, x, y);
    }

    @Override
    public boolean affect(final Knight knight) {
        if (!knight.isAlive()) {
            return false;
        }

        // notify great magician of help
        var greatMagician = GreatMagician.getInstance();
        greatMagician.notifyAngelHelp(this, knight);

        knight.addXpOutsideBattle(AngelConstants.XPANGEL_KNIGHT_BONUS_XP);
        return false;
    }

    @Override
    public boolean affect(final Pyromancer pyromancer) {
        if (!pyromancer.isAlive()) {
            return false;
        }

        // notify great magician of help
        var greatMagician = GreatMagician.getInstance();
        greatMagician.notifyAngelHelp(this, pyromancer);

        pyromancer.addXpOutsideBattle(AngelConstants.XPANGEL_PYROMANCER_BONUS_XP);
        return false;
    }

    @Override
    public boolean affect(final Rogue rogue) {
        if (!rogue.isAlive()) {
            return false;
        }

        // notify great magician of help
        var greatMagician = GreatMagician.getInstance();
        greatMagician.notifyAngelHelp(this, rogue);

        rogue.addXpOutsideBattle(AngelConstants.XPANGEL_ROGUE_BONUS_XP);
        return false;
    }

    @Override
    public boolean affect(final Wizard wizard) {
        if (!wizard.isAlive()) {
            return false;
        }

        // notify great magician of help
        var greatMagician = GreatMagician.getInstance();
        greatMagician.notifyAngelHelp(this, wizard);

        wizard.addXpOutsideBattle(AngelConstants.XPANGEL_WIZARD_BONUS_XP);
        return false;
    }
}
