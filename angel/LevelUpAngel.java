package angel;

import common.AngelConstants;
import hero.Knight;
import hero.Pyromancer;
import hero.Rogue;
import hero.Wizard;

public final class LevelUpAngel extends Angel {
    public LevelUpAngel(int x, int y) {
        super(x, y);
    }

    @Override
    public void affect(final Knight knight) {
        if(knight.isAlive() == false) {
            return;
        }
        knight.levelUp();
        knight.addToAdditionalDamageModifiers(AngelConstants.LEVEL_UP_ANGEL_KNIGHT_MODIFIER);
    }

    @Override
    public void affect(final Pyromancer pyromancer) {
        if(pyromancer.isAlive() == false) {
            return;
        }
        pyromancer.levelUp();
        pyromancer.addToAdditionalDamageModifiers(AngelConstants.LEVEL_UP_ANGEL_PYROMANCER_MODIFIER);
    }

    @Override
    public void affect(final Rogue rogue) {
        if(rogue.isAlive() == false) {
            return;
        }
        rogue.levelUp();
        rogue.addToAdditionalDamageModifiers(AngelConstants.LEVEL_UP_ANGEL_ROGUE_MODIFIER);
    }

    @Override
    public void affect(final Wizard wizard) {
        if(wizard.isAlive() == false) {
            return;
        }
        wizard.levelUp();
        wizard.addToAdditionalDamageModifiers(AngelConstants.LEVEL_UP_ANGEL_WIZARD_MODIFIER);
    }
}
