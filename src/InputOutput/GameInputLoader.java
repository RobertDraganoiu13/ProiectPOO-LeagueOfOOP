package InputOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class GameInputLoader {
    FileReader fileReader;

    public GameInputLoader(String inputPath) {
        try {
            fileReader = new FileReader(inputPath);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
    }

    public GameInput load() {

    }
}
