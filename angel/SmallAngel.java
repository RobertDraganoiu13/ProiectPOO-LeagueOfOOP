package angel;

import common.AngelConstants;
import hero.Knight;
import hero.Pyromancer;
import hero.Rogue;
import hero.Wizard;

public final class SmallAngel extends Angel {
    public SmallAngel(final int x, final int y) {
        super(AngelType.Good, x, y);
    }

    @Override
    public boolean affect(final Knight knight) {
        if (!knight.isAlive()) {
            return false;
        }
        knight.addToAdditionalDamageModifiers(AngelConstants.SMALL_ANGEL_KNIGHT_MODIFIER);
        knight.addHp(AngelConstants.SMALL_ANGEL_KNIGHT_BONUS_HP);
        return true;
    }

    @Override
    public boolean affect(final Pyromancer pyromancer) {
        if (!pyromancer.isAlive()) {
            return false;
        }
        pyromancer.addToAdditionalDamageModifiers(AngelConstants.SMALL_ANGEL_PYROMANCER_MODIFIER);
        pyromancer.addHp(AngelConstants.SMALL_ANGEL_PYROMANCER_BONUS_HP);
        return true;
    }

    @Override
    public boolean affect(final Rogue rogue) {
        if (!rogue.isAlive()) {
            return false;
        }
        rogue.addToAdditionalDamageModifiers(AngelConstants.SMALL_ANGEL_ROGUE_MODIFIER);
        rogue.addHp(AngelConstants.SMALL_ANGEL_ROGUE_BONUS_HP);
        return true;
    }

    @Override
    public boolean affect(final Wizard wizard) {
        if (!wizard.isAlive()) {
            return false;
        }
        wizard.addToAdditionalDamageModifiers(AngelConstants.SMALL_ANGEL_WIZARD_MODIFIER);
        wizard.addHp(AngelConstants.SMALL_ANGEL_WIZARD_BONUS_HP);
        return true;
    }
}
