package angel;

import common.AngelConstants;
import hero.Knight;
import hero.Pyromancer;
import hero.Rogue;
import hero.Wizard;

public final class GoodBoy extends Angel {
    public GoodBoy(int x, int y) {
        super(x, y);
    }

    @Override
    public void affect(final Knight knight) {
        if(knight.isAlive() == false) {
            return;
        }
        knight.addToAdditionalDamageModifiers(AngelConstants.GOOD_BOY_KNIGHT_MODIFIER);
        knight.addHp(AngelConstants.GOOD_BOY_KNIGHT_BONUS_HP);
    }

    @Override
    public void affect(final Pyromancer pyromancer) {
        if(pyromancer.isAlive() == false) {
            return;
        }
        pyromancer.addToAdditionalDamageModifiers(AngelConstants.GOOD_BOY_PYROMANCER_MODIFIER);
        pyromancer.addHp(AngelConstants.GOOD_BOY_PYROMANCER_BONUS_HP);
    }

    @Override
    public void affect(final Rogue rogue) {
        if(rogue.isAlive() == false) {
            return;
        }
        rogue.addToAdditionalDamageModifiers(AngelConstants.GOOD_BOY_ROGUE_MODIFIER);
        rogue.addHp(AngelConstants.GOOD_BOY_ROGUE_BONUS_HP);
    }

    @Override
    public void affect(final Wizard wizard) {
        if(wizard.isAlive() == false) {
            return;
        }
        wizard.addToAdditionalDamageModifiers(AngelConstants.GOOD_BOY_WIZARD_MODIFIER);
        wizard.addHp(AngelConstants.GOOD_BOY_WIZARD_BONUS_HP);
    }
}
