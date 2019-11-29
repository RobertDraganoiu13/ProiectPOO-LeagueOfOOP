package map;

public final class GameMap {
    private int height;
    private int width;
    private TerrainType[][] cells;

    public GameMap(final int height, final int width, final char[][] terrain) {
        this.height = height;
        this.width = width;
        cells = new TerrainType[height][width];
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                setCellAt(i, j, terrain[i][j]);
            }
        }
    }

    public void setCellAt(final int x, final int y, final char terrain) {
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
