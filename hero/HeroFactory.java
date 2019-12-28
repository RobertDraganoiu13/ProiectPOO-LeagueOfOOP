package hero;

import input.HeroInputData;

import java.util.ArrayList;

public final class HeroFactory {
    private static HeroFactory instance = null;

    private HeroFactory() { }

    /**
     * Return instance of singleton.
     * @return
     */
    public static HeroFactory getInstance() {
        if (instance == null) {
            instance = new HeroFactory();
        }
        return instance;
    }

    /**
     * Creates a hero based on input data.
     * @param data
     * @return
     */
    private Hero createHero(final HeroInputData data, int id) {
        switch (data.getType()) {
            case 'K':
                return new Knight(id, data.getX(), data.getY());
            case 'P':
                return new Pyromancer(id, data.getX(), data.getY());
            case 'R':
                return new Rogue(id, data.getX(), data.getY());
            default:
                break;
        }
        return new Wizard(id, data.getX(), data.getY());
    }

    /**
     * Returns list of Hero objects created based on input data.
     * @param heroesData
     * @return
     */
    public ArrayList<Hero> createAllHeroes(final ArrayList<HeroInputData> heroesData) {
        ArrayList<Hero> heroes = new ArrayList<Hero>();
        // create players using heroesData
        for (int i = 0; i < heroesData.size(); ++i) {
            heroes.add(createHero(heroesData.get(i), i));
        }
        return heroes;
    }
}
