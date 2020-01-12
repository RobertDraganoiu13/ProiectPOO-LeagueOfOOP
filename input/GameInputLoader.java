package input;

import fileio.FileSystem;
import java.io.IOException;
import java.util.ArrayList;

public final class GameInputLoader {
    private FileSystem fileSystem;

    public GameInputLoader(final String inputPath, final String outputPath) {
        try {
            fileSystem = new FileSystem(inputPath, outputPath);
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reads and adds content from input file into raw data types, returns GameInput instance,
     * which transforms it into objects further used by the application.
     * @return
     * @throws IOException
     */
    public GameInput load() throws IOException {
        int height = fileSystem.nextInt();
        int width = fileSystem.nextInt();
        char[][] charMap = new char[height][width];

        // add chars to charMap
        for (int i = 0; i < height; ++i) {
            String line = fileSystem.nextWord();
            for (int j = 0; j < width; ++j) {
                charMap[i][j] = line.charAt(j);
            }
        }

         // add heroes data to input data array
        int numOfHeroes = fileSystem.nextInt();
        ArrayList<HeroInputData> heroesData = new ArrayList<HeroInputData>();
        for (int i = 0; i < numOfHeroes; ++i) {
            char type = fileSystem.nextWord().charAt(0);
            int x = fileSystem.nextInt();
            int y = fileSystem.nextInt();
            heroesData.add(new HeroInputData(type, x, y));
        }

        // add movements to movements array
        int rounds = fileSystem.nextInt();
        ArrayList<String> movements = new ArrayList<String>();
        for (int i = 0; i < rounds; ++i) {
            movements.add(fileSystem.nextWord());
        }

        // add angel types to angel types array
        ArrayList<ArrayList<AngelInputData>> angelDataArray
                = new ArrayList<ArrayList<AngelInputData>>();
        for (int i = 0; i < rounds; ++i) {
            angelDataArray.add(new ArrayList<AngelInputData>());
            int count = fileSystem.nextInt();
            for (int j = 0; j < count; ++j) {
                String data = fileSystem.nextWord();
                angelDataArray.get(i).add(new AngelInputData(data));
            }

        }
        return new GameInput(height, width, charMap, heroesData, rounds, movements, angelDataArray);
    }
}
