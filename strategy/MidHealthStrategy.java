package strategy;

import hero.Hero;

public class MidHealthStrategy implements Strategy {
    protected int healthDivisor;
    protected float damageModifier;

    public MidHealthStrategy(float damageModifier, int healthDivisor) {
        this.damageModifier = damageModifier;
        this.healthDivisor = healthDivisor;
    }

    @Override
    public void apply(Hero hero) {
        hero.takeUnmonitoredDamage(hero.getHp() / healthDivisor);
        hero.addToAdditionalDamageModifiers(damageModifier);
    }
}
