package angel;

import common.AngelConstants;
import hero.Knight;
import hero.Pyromancer;
import hero.Rogue;
import hero.Wizard;

public final class GoodBoy extends Angel {
    public GoodBoy(final int x, final int y) {
        super(AngelType.Good, x, y);
    }

    @Override
    public boolean affect(final Knight knight) {
        if (!knight.isAlive()) {
            return false;
        }
        knight.addToAdditionalDamageModifiers(AngelConstants.GOOD_BOY_KNIGHT_MODIFIER);
        knight.addHp(AngelConstants.GOOD_BOY_KNIGHT_BONUS_HP);
        return true;
    }

    @Override
    public boolean affect(final Pyromancer pyromancer) {
        if (!pyromancer.isAlive()) {
            return false;
        }
        pyromancer.addToAdditionalDamageModifiers(AngelConstants.GOOD_BOY_PYROMANCER_MODIFIER);
        pyromancer.addHp(AngelConstants.GOOD_BOY_PYROMANCER_BONUS_HP);
        return true;
    }

    @Override
    public boolean affect(final Rogue rogue) {
        if (!rogue.isAlive()) {
            return false;
        }
        rogue.addToAdditionalDamageModifiers(AngelConstants.GOOD_BOY_ROGUE_MODIFIER);
        rogue.addHp(AngelConstants.GOOD_BOY_ROGUE_BONUS_HP);
        return true;
    }

    @Override
    public boolean affect(final Wizard wizard) {
        if (!wizard.isAlive()) {
            return false;
        }
        wizard.addToAdditionalDamageModifiers(AngelConstants.GOOD_BOY_WIZARD_MODIFIER);
        wizard.addHp(AngelConstants.GOOD_BOY_WIZARD_BONUS_HP);
        return true;
    }
}
