package angel;

import common.AngelConstants;
import hero.Knight;
import hero.Pyromancer;
import hero.Rogue;
import hero.Wizard;
import observer.GreatMagician;

public final class LevelUpAngel extends Angel {
    public LevelUpAngel(final int x, final int y) {
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

        knight.levelUp();
        knight.addToAdditionalDamageModifiers(AngelConstants.LEVEL_UP_ANGEL_KNIGHT_MODIFIER);
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

        pyromancer.levelUp();
        pyromancer.addToAdditionalDamageModifiers(
                AngelConstants.LEVEL_UP_ANGEL_PYROMANCER_MODIFIER);
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

        rogue.levelUp();
        rogue.addToAdditionalDamageModifiers(AngelConstants.LEVEL_UP_ANGEL_ROGUE_MODIFIER);
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

        wizard.levelUp();
        wizard.addToAdditionalDamageModifiers(AngelConstants.LEVEL_UP_ANGEL_WIZARD_MODIFIER);
        return false;
    }
}
