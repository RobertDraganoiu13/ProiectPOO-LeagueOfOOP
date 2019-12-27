package angel;

import common.AngelConstants;
import hero.Knight;
import hero.Pyromancer;
import hero.Rogue;
import hero.Wizard;

public final class DamageAngel extends Angel {
    public DamageAngel(int x, int y) {
        super(x, y);
    }

    @Override
    public void affect(final Knight knight) {
        if(knight.isAlive() == false) {
            return;
        }
        knight.addToAdditionalDamageModifiers(AngelConstants.DAMAGE_ANGEL_KNIGHT_MODIFIER);
    }

    @Override
    public void affect(final Pyromancer pyromancer) {
        if(pyromancer.isAlive() == false) {
            return;
        }
        pyromancer.addToAdditionalDamageModifiers(AngelConstants.DAMAGE_ANGEL_PYROMANCER_MODIFIER);
    }

    @Override
    public void affect(final Rogue rogue) {
        if(rogue.isAlive() == false) {
            return;
        }
        rogue.addToAdditionalDamageModifiers(AngelConstants.DAMAGE_ANGEL_ROGUE_MODIFIER);
    }

    @Override
    public void affect(final Wizard wizard) {
        if(wizard.isAlive() == false) {
            return;
        }
        wizard.addToAdditionalDamageModifiers(AngelConstants.DAMAGE_ANGEL_WIZARD_MODIFIER);
    }
}
