package main;

import angel.Angel;
import fileio.implementations.FileWriter;
import hero.Hero;

import java.io.IOException;

public class GreatMagician {
    private static GreatMagician instance = null;
    private static FileWriter fileWriter;
    private String info;

    private GreatMagician() { }

    public static GreatMagician getInstance(FileWriter fw) {
        if(instance == null) {
            instance = new GreatMagician();
            fileWriter = fw;
        }
        return instance;
    }

    public static GreatMagician getInstance() {
        if(instance == null) {
            return null;
        }
        return instance;
    }

    public void notifyStartRound(int round) {
        addToLog("~~ Round " + round + " ~~");
    }

    public void notifyEndRound() {
        addToLog("");
    }

    public void notifyKill(Hero killer, Hero killed) {
        addToLog("Player " + killed.getClass().getSimpleName() + " " + killed.getId() + " was killed by " + killer.getClass().getSimpleName() + " " + killer.getId());
    }

    public void notifyKill(Hero killed) {
        addToLog("Player " + killed.getClass().getSimpleName() + " " + killed.getId() + " was killed by an angel");
    }

    public void notifyAngelSpawn(Angel angel) {
        addToLog("Angel " + angel.getClass().getSimpleName() + " was spawned at " + angel.getX() + " " + angel.getY());
    }

    public void notifyAngelHelp(Angel angel, Hero hero) {
        addToLog(angel.getClass().getSimpleName() + " helped " + hero.getClass().getSimpleName() + " " + hero.getId());
    }

    public void notifyAngelHit(Angel angel, Hero hero) {
        addToLog(angel.getClass().getSimpleName() + " hit " + hero.getClass().getSimpleName() + " " + hero.getId());
    }

    public void notifyRevive(Hero hero) {
        addToLog("Player " + hero.getClass().getSimpleName() + " " + hero.getId() + " was brought to life by an angel");
    }

    public void notifyLevelUp(Hero hero) {
        addToLog(hero.getClass().getSimpleName() + " " + hero.getId() + " reached level " + hero.getLevel());
    }

    private void addToLog(String message) {
        info += message + "\n";
    }

    public void writeLog() throws IOException {
        fileWriter.writeWord(info);
        info = "";
    }
}
