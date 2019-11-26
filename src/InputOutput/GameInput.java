package InputOutput;

import HeroClasses.Hero;
import HeroClasses.HeroFactory;
import Map.GameMap;

import java.util.ArrayList;

public class GameInput {
    private GameMap gameMap;
    private ArrayList<Hero> heroes;

    public GameInput(int height, int width, char[][] terrain, ArrayList<HeroInputData> heroesData) {
        this.gameMap = new GameMap(height, width, terrain);
        HeroFactory factory = HeroFactory.getInstance();
        heroes = factory.createAllHeroes(heroesData);
    }

    public GameMap getGameMap() {
        return gameMap;
    }

    public ArrayList<Hero> getHeroes() {
        return heroes;
    }
}
