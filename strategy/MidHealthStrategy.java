package strategy;

import hero.Hero;

public class MidHealthStrategy implements Strategy {
    protected int healthDivisor;
    protected float damageModifier;

    public MidHealthStrategy(final float damageModifier, final int healthDivisor) {
        this.damageModifier = damageModifier;
        this.healthDivisor = healthDivisor;
    }

    @Override
    public final void apply(final Hero hero) {
        hero.takeUnmonitoredDamage(hero.getHp() / healthDivisor);
        hero.addToAdditionalDamageModifiers(damageModifier);
    }
}
