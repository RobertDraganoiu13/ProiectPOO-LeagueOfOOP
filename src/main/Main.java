package main;


import InputOutput.GameInput;
import InputOutput.GameInputLoader;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        GameInputLoader loader = new GameInputLoader(args[0], args[1]);
        GameInput input = loader.load();

        var heroes = input.getHeroes();
        System.out.println(heroes);
        heroes.get(1).setLevel(10);
        for(int i = 1; i < 4; ++i) {
            heroes.get(i).provideFirstAbilityRaceModifier(heroes.get(0));
        }
        System.out.println(heroes);



        //System.out.println(input.getGameMap());
        //System.out.println(input.getMovements());
    }
}
