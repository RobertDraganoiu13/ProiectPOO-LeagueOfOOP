package HeroClasses;

import InputOutput.HeroInputData;

import java.util.ArrayList;

public class HeroFactory {
    private static HeroFactory instance = null;

    private HeroFactory() { }

    public static HeroFactory getInstance() {
        if(instance == null) {
            instance = new HeroFactory();
        }
        return instance;
    }

    private Hero createHero(HeroInputData data) {
        switch(data.type) {
            case 'K':
                return new Knight(data.x, data.y);
            case 'P':
                return new Pyromancer(data.x, data.y);
            case 'R':
                return new Rogue(data.x, data.y);
        }
        return new Wizard(data.x, data.y);
    }

    public ArrayList<Hero> createAllHeroes(ArrayList<HeroInputData> heroesData) {
        ArrayList<Hero> heroes = new ArrayList<Hero>();
        // create players using heroesData
        for(var data : heroesData) {
            heroes.add(createHero(data));
        }
        return heroes;
    }





}
