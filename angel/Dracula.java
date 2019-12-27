package angel;

import common.AngelConstants;
import hero.Knight;
import hero.Pyromancer;
import hero.Rogue;
import hero.Wizard;

public final class Dracula extends Angel {
    public Dracula(int x, int y) {
        super(x, y);
    }

    @Override
    public void affect(final Knight knight) {
        if(knight.isAlive() == false) {
            return;
        }
        knight.addToAdditionalDamageModifiers(AngelConstants.DRACULA_KNIGHT_MODIFIER);
        knight.takeUnmonitoredDamage(AngelConstants.DRACULA_KNIGHT_DMG);
    }

    @Override
    public void affect(final Pyromancer pyromancer) {
        if(pyromancer.isAlive() == false) {
            return;
        }
        pyromancer.addToAdditionalDamageModifiers(AngelConstants.DRACULA_PYROMANCER_MODIFIER);
        pyromancer.takeUnmonitoredDamage(AngelConstants.DRACULA_PYROMANCER_DMG);
    }

    @Override
    public void affect(final Rogue rogue) {
        if(rogue.isAlive() == false) {
            return;
        }
        rogue.addToAdditionalDamageModifiers(AngelConstants.DRACULA_ROGUE_MODIFIER);
        rogue.takeUnmonitoredDamage(AngelConstants.DRACULA_ROGUE_DMG);
    }

    @Override
    public void affect(final Wizard wizard) {
        if(wizard.isAlive() == false) {
            return;
        }
        wizard.addToAdditionalDamageModifiers(AngelConstants.DRACULA_WIZARD_MODIFIER);
        wizard.takeUnmonitoredDamage(AngelConstants.DRACULA_WIZARD_DMG);
    }
}
