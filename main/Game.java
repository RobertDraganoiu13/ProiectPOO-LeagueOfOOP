package main;

import angel.Angel;
import angel.AngelType;
import hero.Hero;
import hero.Knight;
import hero.Pyromancer;
import hero.Rogue;
import hero.Wizard;
import map.GameMap;
import map.TerrainType;
import fileio.implementations.FileWriter;

import java.io.IOException;
import java.util.ArrayList;

public class Game {
    private int rounds;
    private ArrayList<Hero> heroes;
    private ArrayList<ArrayList<Angel>> angels;
    private ArrayList<String> movements;
    private GameMap gameMap;
    private FileWriter fileWriter;
    private GreatMagician greatMagician;

    public Game(final int rounds, final ArrayList<Hero> heroes, final ArrayList<String> movements,
                final GameMap gameMap, final ArrayList<ArrayList<Angel>> angels, final String outputPath) throws IOException {
        this.rounds = rounds;
        this.heroes = heroes;
        this.angels = angels;
        this.movements = movements;
        this.gameMap = gameMap;
        this.fileWriter = new FileWriter(outputPath);
        greatMagician = GreatMagician.getInstance(fileWriter);
    }

    /**
     * Runs all rounds of the game.
     * @throws IOException
     */
    public final void start() throws IOException {
        for (int i = 0; i < rounds; ++i) {
            // notify start round
            greatMagician.notifyStartRound(i + 1);
            // apply over time effects
            applyAllOverTimeEffects();
            // apply strategy if not incapacitated
            applyStrategies();
            // move heroes if not incapacitated
            moveHeroes(movements.get(i));
            // remove over time effects if rounds passed
            checkOverTimeEffects();
            // battle
            sustainAllBattles();
            // spawn angels and apply angel effects
            applyAngelEffects(angels.get(i));
            // notify end round
            greatMagician.notifyEndRound();
            greatMagician.writeLog();
        }
        printHeroStats();
    }

    private final void applyAllOverTimeEffects() {
        for (var hero : heroes) {
            if(!hero.isAlive()) {
                continue;
            }
            hero.applyOverTimeEffects();
        }
    }

    private void applyStrategies() {
        for (var hero : heroes) {
            if(!hero.isAlive()) {
                continue;
            }
            hero.applyStrategy();
        }
    }

    private void moveHeroes(final String moves) {
        for (int i = 0; i < moves.length(); ++i) {
            char movement = moves.charAt(i);
            switch (movement) {
                case 'U':
                    heroes.get(i).moveUp();
                    break;
                case 'D':
                    heroes.get(i).moveDown();
                    break;
                case 'L':
                    heroes.get(i).moveLeft();
                    break;
                case 'R':
                    heroes.get(i).moveRight();
                    break;
                default:
                    break;
            }
        }
    }

    private void checkOverTimeEffects() {
        for(var hero : heroes) {
            hero.checkOverTimeEffects();
        }
    }

    private void battle(final Hero hero1, final Hero hero2) {
        Hero combatant1;
        Hero combatant2;

        // ensure wizard hits second so he can use deflect
        if (hero1 instanceof Wizard) {
            combatant1 = hero2;
            combatant2 = hero1;
        } else {
            combatant1 = hero1;
            combatant2 = hero2;
        }

        // get terrain type
        int x = combatant1.getX();
        int y = combatant1.getY();
        TerrainType terrain = gameMap.getCellAt(x, y);

        // use abilities
        combatant1.useFirstAbility(combatant2, terrain);
        combatant1.useSecondAbility(combatant2, terrain);
        combatant2.useFirstAbility(combatant1, terrain);
        combatant2.useSecondAbility(combatant1, terrain);

        // add xp if any player died
        int levelCombatant1 = combatant1.getLevel();
        int levelCombatant2 = combatant2.getLevel();

        // no xp if both dead
        if(!combatant1.isAlive() && !combatant2.isAlive()) {
            greatMagician.notifyKill(combatant1, combatant2);
            greatMagician.notifyKill(combatant2, combatant1);
            return;
        }

        if (!combatant2.isAlive()) {
            greatMagician.notifyKill(combatant1, combatant2);
            combatant1.addXp(levelCombatant2);
        }

        if (!combatant1.isAlive()) {
            greatMagician.notifyKill(combatant2, combatant1);
            combatant2.addXp(levelCombatant1);
        }
    }

    private void sustainAllBattles() throws IOException {
        // make battled array, only battle if boolean from hero index is false
        ArrayList<Boolean> battled = new ArrayList<>();
        for (int i = 0; i < heroes.size(); ++i) {
            battled.add(false);
        }

        // check for all collisions
        for (int i = 0; i < heroes.size(); ++i) {
            for (int j = 0; j < heroes.size(); ++j) {
                if (i == j) {
                    continue;
                }
                if (heroes.get(i).hasSameCoordsAs(heroes.get(j))
                        && heroes.get(i).isAlive() && heroes.get(j).isAlive()
                        && !battled.get(i) && !battled.get(j)) {
                    battled.set(i, true);
                    battled.set(i, true);
                    battle(heroes.get(i), heroes.get(j));
                }
            }
        }
    }

    private void applyAngelEffects(ArrayList<Angel> angels) {
        for(var angel : angels) {
            greatMagician.notifyAngelSpawn(angel);
            for(var hero : heroes) {
                boolean oldStatus = hero.isAlive();
                if(hero.hasSameCoordsAs(angel)) {
                    boolean accepted = hero.acceptAngel(angel);

                    // notify gm if angel had effect on hero based on angel type
                    if(accepted) {
                        if(angel.getType() == AngelType.Good) {
                            greatMagician.notifyAngelHelp(angel, hero);
                        } else {
                            greatMagician.notifyAngelHit(angel, hero);
                        }
                    }

                    // notify gm if angel killed or revived hero
                    boolean newStatus = hero.isAlive();
                    if(oldStatus != newStatus) {
                        if(newStatus == false) {
                            greatMagician.notifyKill(hero);
                        } else {
                            greatMagician.notifyRevive(hero);
                        }
                    }
                }
            }
        }
    }

    private void printHeroStats() throws IOException {
        fileWriter.writeWord("~~ Results ~~");
        fileWriter.writeNewLine();
        for (var hero: heroes) {
            char type;
            if (hero instanceof Knight) {
                type = 'K';
            } else if (hero instanceof Pyromancer) {
                type = 'P';
            } else if (hero instanceof Rogue) {
                type = 'R';
            } else {
                type = 'W';
            }

            fileWriter.writeCharacter(type);
            if (!hero.isAlive()) {
                fileWriter.writeWord(" dead");
                fileWriter.writeNewLine();
            } else {
                fileWriter.writeWord(" " + hero.getLevel() + " "
                        + hero.getXp() + " " + hero.getHp() + " " + hero.getX()
                        + " " + hero.getY());
                fileWriter.writeNewLine();
            }
        }
        fileWriter.close();
    }
}
