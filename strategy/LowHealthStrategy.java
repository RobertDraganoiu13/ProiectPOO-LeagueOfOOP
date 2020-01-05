package strategy;

import hero.Hero;

public final class LowHealthStrategy implements Strategy {
    protected int healthDivisor;
    protected float damageModifier;

    public LowHealthStrategy(final float damageModifier, final int healthDivisor) {
        this.damageModifier = damageModifier;
        this.healthDivisor = healthDivisor;
    }

    @Override
    public void apply(final Hero hero) {
        hero.addHp(hero.getHp() / healthDivisor);
        hero.addToAdditionalDamageModifiers(damageModifier);
    }
}
