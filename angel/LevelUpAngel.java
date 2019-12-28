package angel;

import common.AngelConstants;
import hero.Knight;
import hero.Pyromancer;
import hero.Rogue;
import hero.Wizard;

public final class LevelUpAngel extends Angel {
    public LevelUpAngel(int x, int y) {
        super(AngelType.Good, x, y);
    }

    @Override
    public boolean affect(final Knight knight) {
        if(!knight.isAlive()) {
            return false;
        }
        knight.levelUp();
        knight.addToAdditionalDamageModifiers(AngelConstants.LEVEL_UP_ANGEL_KNIGHT_MODIFIER);
        return true;
    }

    @Override
    public boolean affect(final Pyromancer pyromancer) {
        if(!pyromancer.isAlive()) {
            return false;
        }
        pyromancer.levelUp();
        pyromancer.addToAdditionalDamageModifiers(AngelConstants.LEVEL_UP_ANGEL_PYROMANCER_MODIFIER);
        return true;
    }

    @Override
    public boolean affect(final Rogue rogue) {
        if(!rogue.isAlive()) {
            return false;
        }
        rogue.levelUp();
        rogue.addToAdditionalDamageModifiers(AngelConstants.LEVEL_UP_ANGEL_ROGUE_MODIFIER);
        return true;
    }

    @Override
    public boolean affect(final Wizard wizard) {
        if(!wizard.isAlive()) {
            return false;
        }
        wizard.levelUp();
        wizard.addToAdditionalDamageModifiers(AngelConstants.LEVEL_UP_ANGEL_WIZARD_MODIFIER);
        return true;
    }
}
