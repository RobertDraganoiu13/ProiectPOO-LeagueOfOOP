package angel;

import common.AngelConstants;
import hero.Knight;
import hero.Pyromancer;
import hero.Rogue;
import hero.Wizard;

public final class DamageAngel extends Angel {
    public DamageAngel(final int x, final int y) {
        super(AngelType.Good, x, y);
    }

    @Override
    public boolean affect(final Knight knight) {
        if (!knight.isAlive()) {
            return false;
        }
        knight.addToAdditionalDamageModifiers(AngelConstants.DAMAGE_ANGEL_KNIGHT_MODIFIER);
        return true;
    }

    @Override
    public boolean affect(final Pyromancer pyromancer) {
        if (!pyromancer.isAlive()) {
            return false;
        }
        pyromancer.addToAdditionalDamageModifiers(AngelConstants.DAMAGE_ANGEL_PYROMANCER_MODIFIER);
        return true;
    }

    @Override
    public boolean affect(final Rogue rogue) {
        if (!rogue.isAlive()) {
            return false;
        }
        rogue.addToAdditionalDamageModifiers(AngelConstants.DAMAGE_ANGEL_ROGUE_MODIFIER);
        return true;
    }

    @Override
    public boolean affect(final Wizard wizard) {
        if (!wizard.isAlive()) {
            return false;
        }
        wizard.addToAdditionalDamageModifiers(AngelConstants.DAMAGE_ANGEL_WIZARD_MODIFIER);
        return true;
    }
}
