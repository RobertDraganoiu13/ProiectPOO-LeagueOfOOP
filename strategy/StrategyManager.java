package strategy;

import hero.Hero;

public class StrategyManager {
    private Strategy strategy;

    public StrategyManager(Strategy strategy) {
        this.strategy = strategy;
    }

    public void applyStrategy(Hero hero) {
        strategy.apply(hero);
    }
}
