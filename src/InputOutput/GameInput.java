package InputOutput;

import HeroClasses.Hero;
import HeroClasses.HeroFactory;
import Map.GameMap;

import java.util.ArrayList;

public class GameInput {
    private GameMap gameMap;
    private ArrayList<Hero> heroes;
    private int numOfRounds;
    private ArrayList<String> movements;

    public GameInput(int height, int width, char[][] terrain, ArrayList<HeroInputData> heroesData, int rounds, ArrayList<String> movements) {
        this.gameMap = new GameMap(height, width, terrain);
        HeroFactory factory = HeroFactory.getInstance();
        heroes = factory.createAllHeroes(heroesData);
        this.numOfRounds = rounds;
        this.movements = movements;
    }

    public GameMap getGameMap() {
        return gameMap;
    }

    public ArrayList<Hero> getHeroes() {
        return heroes;
    }

    public int getNumOfRounds() {
        return numOfRounds;
    }

    public ArrayList<String> getMovements() {
        return movements;
    }
}
