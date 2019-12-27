package input;

import angel.Angel;
import angel.AngelFactory;
import hero.Hero;
import hero.HeroFactory;
import map.GameMap;

import java.util.ArrayList;

public final class GameInput {
    private GameMap gameMap;
    private ArrayList<Hero> heroes;
    private int numOfRounds;
    private ArrayList<String> movements;
    private ArrayList<ArrayList<Angel>> angels;

    /**
     * Turns input data into object types further used inside the application.
     * @param height
     * @param width
     * @param terrain
     * @param heroesData
     * @param rounds
     * @param movements
     * @param angelDataArray
     */
    public GameInput(final int height, final int width, final char[][] terrain,
                     final ArrayList<HeroInputData> heroesData, final int rounds,
                     final ArrayList<String> movements, final ArrayList<ArrayList<AngelInputData>> angelDataArray) {
        GameMap.provideData(height, width, terrain);
        this.gameMap = GameMap.getInstance();
        HeroFactory heroFactory = HeroFactory.getInstance();
        heroes = heroFactory.createAllHeroes(heroesData);
        AngelFactory angelFactory = AngelFactory.getInstance();
        angels = angelFactory.createAllAngels(angelDataArray);
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
