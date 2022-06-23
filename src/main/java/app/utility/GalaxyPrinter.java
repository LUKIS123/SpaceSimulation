package app.utility;

import java.util.List;

import app.alien.AlienRace;
import app.environment.Galaxy;

/**
 * A class that prints the state of the aliens occupying a given galaxy.
 */
public class GalaxyPrinter {
    /**
     * @param galaxy Galaxy to print the aliens of.
     */
    public static void printAliens(Galaxy galaxy) {
        List<AlienRace> alienRaces = galaxy.getAlienRaces();
        for (AlienRace race : alienRaces) {
            printAlien(race);
        }
    }

    /**
     * Print information about a one given alien race.
     * @param race Alien race to print the information of.
     */
    public static void printAlien(AlienRace race) {
        System.out.println(race.getName() + ": ");
        System.out.println("\tmoney: " + race.getMoney());
        System.out.println("\tShip x: " + race.getMotherShip().getPositionX());
        System.out.println("\tShip y: " + race.getMotherShip().getPositionY());
        System.out.println("\tSolar systems: " + race.getSolarSystems().size());
    }
}