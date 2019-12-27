package angel;

import input.AngelInputData;

import java.util.ArrayList;

public final class AngelFactory {
    private static AngelFactory instance = null;

    private AngelFactory() { }

    public static AngelFactory getInstance() {
        if(instance == null) {
            instance = new AngelFactory();
        }
        return instance;
    }

    private Angel createAngel(AngelInputData data) {
        switch (data.getType()) {
            case "DamageAngel":
                return new DamageAngel(data.getX(), data.getY());
            case "DarkAngel":
                return new DarkAngel(data.getX(), data.getY());
            case "Dracula":
                return new Dracula(data.getX(), data.getY());
            case "GoodBoy":
                return new GoodBoy(data.getX(), data.getY());
            case "LevelUpAngel":
                return new LevelUpAngel(data.getX(), data.getY());
            case "LifeGiver":
                return new LifeGiver(data.getX(), data.getY());
            case "SmallAngel":
                return new SmallAngel(data.getX(), data.getY());
            case "Spawner":
                return new Spawner(data.getX(), data.getY());
            case "TheDoomer":
                return new TheDoomer(data.getX(), data.getY());
            default:
                break;
        }
        return new XPAngel(data.getX(), data.getY());
    }

    /**
     * Returns list of Angel objects created based on input data.
     */
    public ArrayList<ArrayList<Angel>> createAllAngels(final ArrayList<ArrayList<AngelInputData>> angeldataArray) {
        ArrayList<ArrayList<Angel>> angels = new ArrayList<ArrayList<Angel>>();
        for(int i = 0; i < angeldataArray.size(); ++i) {
            angels.add(new ArrayList<Angel>());
            for(var data : angeldataArray.get(i)) {
                angels.get(i).add(createAngel(data))
            }
        }
        return angels;
    }
}
