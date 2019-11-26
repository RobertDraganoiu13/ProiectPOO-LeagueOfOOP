package InputOutput;

import Map.GameMap;
import fileio.FileSystem;
import java.io.IOException;
import java.util.ArrayList;

public class GameInputLoader {
    private FileSystem fileSystem;

    public GameInputLoader(String inputPath) {
        try {
            fileSystem = new FileSystem(inputPath, inputPath);
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }

    public GameInput load() throws IOException {
        int height = fileSystem.nextInt();
        int width = fileSystem.nextInt();
        char[][] charMap = new char[height][width];

        // add chars to charMap
        for(int i = 0; i < height; ++i) {
            String line = fileSystem.nextWord();
            for(int j = 0; j < width; ++j) {
                charMap[i][j] = line.charAt(j);
            }
        }

        int numOfHeroes = fileSystem.nextInt();
        ArrayList<HeroInputData> heroesData = new ArrayList<HeroInputData>();
        for(int i = 0; i < numOfHeroes; ++i) {
            char type = fileSystem.nextWord().charAt(0);
            int x = fileSystem.nextInt();
            int y = fileSystem.nextInt();
            heroesData.add(new HeroInputData(type, x, y));
        }
        return new GameInput(height, width, charMap, heroesData);
    }
}
