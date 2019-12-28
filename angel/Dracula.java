package angel;

import common.AngelConstants;
import hero.Knight;
import hero.Pyromancer;
import hero.Rogue;
import hero.Wizard;

public final class Dracula extends Angel {
    public Dracula(int x, int y) {
        super(AngelType.Bad, x, y);
    }

    @Override
    public boolean affect(final Knight knight) {
        if(!knight.isAlive()) {
            return false;
        }
        knight.addToAdditionalDamageModifiers(AngelConstants.DRACULA_KNIGHT_MODIFIER);
        knight.takeUnmonitoredDamage(AngelConstants.DRACULA_KNIGHT_DMG);
        return true;
    }

    @Override
    public boolean affect(final Pyromancer pyromancer) {
        if(!pyromancer.isAlive()) {
            return false;
        }
        pyromancer.addToAdditionalDamageModifiers(AngelConstants.DRACULA_PYROMANCER_MODIFIER);
        pyromancer.takeUnmonitoredDamage(AngelConstants.DRACULA_PYROMANCER_DMG);
        return true;
    }

    @Override
    public boolean affect(final Rogue rogue) {
        if(!rogue.isAlive()) {
            return false;
        }
        rogue.addToAdditionalDamageModifiers(AngelConstants.DRACULA_ROGUE_MODIFIER);
        rogue.takeUnmonitoredDamage(AngelConstants.DRACULA_ROGUE_DMG);
        return true;
    }

    @Override
    public boolean affect(final Wizard wizard) {
        if(!wizard.isAlive()) {
            return false;
        }
        wizard.addToAdditionalDamageModifiers(AngelConstants.DRACULA_WIZARD_MODIFIER);
        wizard.takeUnmonitoredDamage(AngelConstants.DRACULA_WIZARD_DMG);
        return true;
    }
}
