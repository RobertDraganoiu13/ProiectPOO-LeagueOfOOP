package strategy;

import hero.Hero;

public class StrategyManager {
    private Strategy strategy;

    public StrategyManager(final Strategy strategy) {
        this.strategy = strategy;
    }

    public final void applyStrategy(final Hero hero) {
        strategy.apply(hero);
    }
}
