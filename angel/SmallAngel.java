package angel;

import common.AngelConstants;
import hero.Knight;
import hero.Pyromancer;
import hero.Rogue;
import hero.Wizard;

public final class SmallAngel extends Angel {
    public SmallAngel(int x, int y) {
        super(x, y);
    }

    @Override
    public void affect(final Knight knight) {
        if(knight.isAlive() == false) {
            return;
        }
        knight.addToAngelDamageModifiers(AngelConstants.SMALL_ANGEL_KNIGHT_BONUS_HP);
        knight.addHp(AngelConstants.SMALL_ANGEL_KNIGHT_BONUS_HP);
    }

    @Override
    public void affect(final Pyromancer pyromancer) {
        if(pyromancer.isAlive() == false) {
            return;
        }
        pyromancer.addToAngelDamageModifiers(AngelConstants.SMALL_ANGEL_PYROMANCER_MODIFIER);
        pyromancer.addHp(AngelConstants.SMALL_ANGEL_PYROMANCER_BONUS_HP);
    }

    @Override
    public void affect(final Rogue rogue) {
        if(rogue.isAlive() == false) {
            return;
        }
        rogue.addToAngelDamageModifiers(AngelConstants.SMALL_ANGEL_ROGUE_MODIFIER);
        rogue.addHp(AngelConstants.SMALL_ANGEL_ROGUE_BONUS_HP);
    }

    @Override
    public void affect(final Wizard wizard) {
        if(wizard.isAlive() == false) {
            return;
        }
        wizard.addToAngelDamageModifiers(AngelConstants.SMALL_ANGEL_WIZARD_MODIFIER);
        wizard.addHp(AngelConstants.SMALL_ANGEL_WIZARD_BONUS_HP);
    }
}
