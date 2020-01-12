package map;

public final class GameMap {
    private static int height;
    private static int width;
    private static TerrainType[][] cells;

    private static GameMap instance = null;

    public static GameMap getInstance() {
        if (instance == null) {
            instance = new GameMap();
        }
        return instance;
    }

    private GameMap() { }

    public static void provideData(final int height1, final int width1, final char[][] terrain) {
        GameMap.height = height1;
        GameMap.width = width1;
        cells = new TerrainType[height][width];
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                setCellAt(i, j, terrain[i][j]);
            }
        }
    }

    /**
     * Transforms map cell into terrain type.
     * @param x
     * @param y
     * @param terrain
     */
    private static void setCellAt(final int x, final int y, final char terrain) {
        switch (terrain) {
            case 'W':
                cells[x][y] = TerrainType.Woods;
                break;
            case 'L':
                cells[x][y] = TerrainType.Land;
                break;
            case 'D':
                cells[x][y] = TerrainType.Desert;
                break;
            case 'V':
                cells[x][y] = TerrainType.Volcanic;
                break;
            default:
                break;
        }
    }

    public TerrainType getCellAt(final int x, final int y) {
        return cells[x][y];
    }
}
