package angel;

import common.AngelConstants;
import hero.Knight;
import hero.Pyromancer;
import hero.Rogue;
import hero.Wizard;

public final class Spawner extends Angel {
    public Spawner(String name, int x, int y) {
        super(name, x, y);
    }

    @Override
    public void affect(final Knight knight) {
        if(knight.isAlive()) {
            return;
        }
        knight.revive(AngelConstants.SPAWNER_KNIGHT_SET_HP);
    }

    @Override
    public void affect(final Pyromancer pyromancer) {
        if(pyromancer.isAlive()) {
            return;
        }
        pyromancer.revive(AngelConstants.SPAWNER_PYROMANCER_SET_HP);
    }

    @Override
    public void affect(final Rogue rogue) {
        if(rogue.isAlive()) {
            return;
        }
        rogue.revive(AngelConstants.SPAWNER_ROGUE_SET_HP);
    }

    @Override
    public void affect(final Wizard wizard) {
        if(wizard.isAlive()) {
            return;
        }
        wizard.revive(AngelConstants.SPAWNER_WIZARD_SET_HP);
    }
}
