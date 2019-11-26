package main;


import InputOutput.GameInput;
import InputOutput.GameInputLoader;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        GameInputLoader loader = new GameInputLoader(args[0], args[1]);
        GameInput input = loader.load();

        System.out.println(input.getHeroes());
        System.out.println(input.getGameMap());
        System.out.println(input.getMovements());
    }
}
