package Map;

public class GameMap {
    private final int height;
    private final int width;
    TerrainType[][] cells;

    public GameMap(int height, int width, char[][] terrain) {
        this.height = height;
        this.width = width;
        cells = new TerrainType[height][width];
        for(int i = 0; i < height; ++i) {
            for(int j = 0; j < width; ++j) {
                setCellAt(i, j, terrain[i][j]);
            }
        }
    }

    public void setCellAt(int x, int y, char terrain) {
        switch(terrain) {
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
        }
    }

    public TerrainType getCellAt(int x, int y) {
        return cells[x][y];
    }
}
