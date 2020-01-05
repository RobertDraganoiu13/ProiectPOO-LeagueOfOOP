package main;

import angel.Angel;
import fileio.implementations.FileWriter;
import hero.Hero;

import java.io.IOException;

public final class GreatMagician {
    private static GreatMagician instance = null;
    private static FileWriter fileWriter;
    private static String info;

    private GreatMagician() { }

    public static GreatMagician getInstance(final FileWriter fw) {
        if (instance == null) {
            instance = new GreatMagician();
            fileWriter = fw;
            info = "";
        }
        return instance;
    }

    public static GreatMagician getInstance() {
        if (instance == null) {
            return null;
        }
        return instance;
    }

    public void notifyStartRound(final int round) {
        addToLog("~~ Round " + round + " ~~");
    }

    public void notifyEndRound() {
        addToLog("");
    }

    public void notifyKill(final Hero killer, final Hero killed) {
        addToLog("Player " + killed.getClass().getSimpleName() + " " + killed.getId()
                + " was killed by " + killer.getClass().getSimpleName() + " " + killer.getId());
    }

    public void notifyKill(final Hero killed) {
        addToLog("Player " + killed.getClass().getSimpleName() + " " + killed.getId()
                + " was killed by an angel");
    }

    public void notifyAngelSpawn(final Angel angel) {
        addToLog("Angel " + angel.getClass().getSimpleName() + " was spawned at "
                + angel.getX() + " " + angel.getY());
    }

    public void notifyAngelHelp(final Angel angel, final Hero hero) {
        addToLog(angel.getClass().getSimpleName() + " helped " + hero.getClass().getSimpleName()
                + " " + hero.getId());
    }

    public void notifyAngelHit(final Angel angel, final Hero hero) {
        addToLog(angel.getClass().getSimpleName() + " hit " + hero.getClass().getSimpleName()
                + " " + hero.getId());
    }

    public void notifyRevive(final Hero hero) {
        addToLog("Player " + hero.getClass().getSimpleName() + " " + hero.getId()
                + " was brought to life by an angel");
    }

    public void notifyLevelUp(final Hero hero) {
        addToLog(hero.getClass().getSimpleName() + " " + hero.getId()
                + " reached level " + hero.getLevel());
    }

    private void addToLog(final String message) {
        info += message + "\n";
    }

    public void writeLog() throws IOException {
        fileWriter.writeWord(info);
        info = "";
    }
}
