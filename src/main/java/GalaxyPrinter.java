import java.util.List;

public class GalaxyPrinter {
    public static void printAliens(Galaxy galaxy) {
        List<AlienRace> alienRaces = galaxy.getAlienRaces();
        for (AlienRace race : alienRaces) {
            printAlien(race);
        }
    }

    public static void printAlien(AlienRace race) {
        System.out.println(race.getName() + ": ");
        System.out.println("\tmoney: " + race.getMoney());
        System.out.println("\tShip x: " + race.getMotherShip().getPositionX());
        System.out.println("\tShip y: " + race.getMotherShip().getPositionY());
        System.out.println("\tSolar systems: " + race.getSolarSystems().size());
    }
}
