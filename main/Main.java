package main;

import input.GameInput;
import input.GameInputLoader;

import java.io.IOException;

public final class  Main {
    private Main() { }
    public static void main(final String[] args) throws IOException {
        // load input
        GameInputLoader loader = new GameInputLoader(args[0], args[1]);
        GameInput input = loader.load();

        // start game
        Game game = new Game(input.getNumOfRounds(), input.getHeroes(),
                                input.getMovements(), input.getGameMap(),
                                    input.getAngels(), args[1]);
        game.start();
    }
}
