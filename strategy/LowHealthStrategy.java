package strategy;

import hero.Hero;

public class LowHealthStrategy implements Strategy {
    protected int healthDivisor;
    protected float damageModifier;

    public LowHealthStrategy(float damageModifier, int healthDivisor) {
        this.damageModifier = damageModifier;
        this.healthDivisor = healthDivisor;
    }

    @Override
    public void apply(Hero hero) {
        hero.addHp(hero.getHp() / healthDivisor);
        hero.addToAdditionalDamageModifiers(damageModifier);
    }
}
