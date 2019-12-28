package angel;

import common.AngelConstants;
import hero.Knight;
import hero.Pyromancer;
import hero.Rogue;
import hero.Wizard;

public final class SmallAngel extends Angel {
    public SmallAngel(String name, int x, int y) {
        super(name, x, y);
    }

    @Override
    public void affect(final Knight knight) {
        if(knight.isAlive() == false) {
            return;
        }
        knight.addToAdditionalDamageModifiers(AngelConstants.SMALL_ANGEL_KNIGHT_BONUS_HP);
        knight.addHp(AngelConstants.SMALL_ANGEL_KNIGHT_BONUS_HP);
    }

    @Override
    public void affect(final Pyromancer pyromancer) {
        if(pyromancer.isAlive() == false) {
            return;
        }
        pyromancer.addToAdditionalDamageModifiers(AngelConstants.SMALL_ANGEL_PYROMANCER_MODIFIER);
        pyromancer.addHp(AngelConstants.SMALL_ANGEL_PYROMANCER_BONUS_HP);
    }

    @Override
    public void affect(final Rogue rogue) {
        if(rogue.isAlive() == false) {
            return;
        }
        rogue.addToAdditionalDamageModifiers(AngelConstants.SMALL_ANGEL_ROGUE_MODIFIER);
        rogue.addHp(AngelConstants.SMALL_ANGEL_ROGUE_BONUS_HP);
    }

    @Override
    public void affect(final Wizard wizard) {
        if(wizard.isAlive() == false) {
            return;
        }
        wizard.addToAdditionalDamageModifiers(AngelConstants.SMALL_ANGEL_WIZARD_MODIFIER);
        wizard.addHp(AngelConstants.SMALL_ANGEL_WIZARD_BONUS_HP);
    }
}
