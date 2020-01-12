package observer;

import angel.Angel;
import hero.Hero;

import java.io.IOException;

public interface Observer {
    void notifyStartRound(int round);
    void notifyEndRound();
    void notifyKill(Hero killer, Hero killed);
    void notifyKill(Hero killed);
    void notifyAngelSpawn(Angel angel);
    void notifyAngelHelp(Angel angel, Hero hero);
    void notifyAngelHit(Angel angel, Hero hero);
    void notifyRevive(Hero hero);
    void notifyLevelUp(Hero hero);
    void addToLog(String message);
    void writeLog() throws IOException;
}
