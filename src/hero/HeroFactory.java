package hero;

import input.HeroInputData;

import java.util.ArrayList;

public final class HeroFactory {
    private static HeroFactory instance = null;

    private HeroFactory() { }

    public static HeroFactory getInstance() {
        if (instance == null) {
            instance = new HeroFactory();
        }
        return instance;
    }

    private Hero createHero(final HeroInputData data) {
        switch (data.getType()) {
            case 'K':
                return new Knight(data.getX(), data.getY());
            case 'P':
                return new Pyromancer(data.getX(), data.getY());
            case 'R':
                return new Rogue(data.getX(), data.getY());
            default:
                break;
        }
        return new Wizard(data.getX(), data.getY());
    }

    public ArrayList<Hero> createAllHeroes(final ArrayList<HeroInputData> heroesData) {
        ArrayList<Hero> heroes = new ArrayList<Hero>();
        // create players using heroesData
        for (var data : heroesData) {
            heroes.add(createHero(data));
        }
        return heroes;
    }
}
