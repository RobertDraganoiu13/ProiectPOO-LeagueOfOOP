package input;

import hero.Hero;
import hero.HeroFactory;
import map.GameMap;

import java.util.ArrayList;

public final class GameInput {
    private GameMap gameMap;
    private ArrayList<Hero> heroes;
    private int numOfRounds;
    private ArrayList<String> movements;

    /**
     * Turns input data into object types further used inside the application.
     * @param height
     * @param width
     * @param terrain
     * @param heroesData
     * @param rounds
     * @param movements
     */
    public GameInput(final int height, final int width, final char[][] terrain,
                     final ArrayList<HeroInputData> heroesData, final int rounds,
                     final ArrayList<String> movements) {
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
