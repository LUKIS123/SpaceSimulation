package app.environment;

import app.alien.AlienRace;
import app.attack.AlienAttacker;
import app.config.ApplicationProperties;
import app.utility.AlienRaceTrader;

/**
 * Class for visiting a solar system by a mother ship. Visiting basically means interacting with the solar system.
 */
public class SolarSystemVisitor {

    private MotherShipMover motherShipMover = new MotherShipMover();
    private AlienRaceTrader alienRaceTrader = new AlienRaceTrader();
    private AlienAttacker alienAttacker;
    private ApplicationProperties config;

    /**
     * @param attacker Chosen attacking algorithm.
     * @param config Config of the current context.
     */
    public SolarSystemVisitor(AlienAttacker attacker, ApplicationProperties config) {
        this.alienAttacker = attacker;
        this.config = config;
    }

    /**
     * Take the extracted resources from the planet to the ship for later trading.
     * @param solarSystem Visited solar system.
     * @param motherShip Visiting mother ship.
     */
    private void extractResources(SolarSystem solarSystem, MotherShip motherShip) {
        int extracted = solarSystem.getResourcesExtracted();
        System.out.println("\t\tShip landed on its own planet and extracted " + extracted + " resources");
        motherShip.addResources(extracted);
        solarSystem.setResourcesExtracted(0);
    }

    /**
     * Colonize an empty solar system if possible (if enough money).
     * @param solarSystem Visited solar system.
     * @param motherShip Visiting mother ship.
     */
    private void colonizeSolarSystem(SolarSystem solarSystem, MotherShip motherShip) {
        AlienRace alienRace = motherShip.getOwner();
        System.out.println("\t\tShip landed on empty planet");
        if (alienRace.getMoney() >= config.getColonizationCost()) {
            System.out.println("\t\tEmpty planet became colonized");
            alienRace.addMoney(-1 * config.getColonizationCost());
            solarSystem.setOwner(alienRace);
        }
    }

    /**
     * Visit solar system that is already occupied by other race then decide if they should trade with each other
     * or go to war.
     * @param galaxy The galaxy in which the visiting is happening.
     * @param solarSystem Visited solar system.
     * @param motherShip visiting mother ship.
     */
    private void visitOtherRace(Galaxy galaxy, SolarSystem solarSystem, MotherShip motherShip) {
        String name1 = motherShip.getOwner().getName();
        String name2 = solarSystem.getOwner().getName();
        System.out.println("\t\tShip landed on a planet colonized by " + name2);

        // relationship exists
        boolean exists = galaxy.getAlienRelationships().relationExists(name1, name2);
        if (!exists) {
            System.out.println("\t\tIt's first time they meet");
            galaxy.getAlienRelationships().addRelationship(name1, name2, 0);
        }

        if (galaxy.getAlienRelationships().getRelations().get(name1).get(name2).getRelationMeter() > -100) {
            alienRaceTrader.trade(galaxy, motherShip, solarSystem);
        } else {
            System.out.println("\t\tThey fought with each other");
            alienAttacker.attack(galaxy, motherShip, solarSystem);
        }
    }

    /**
     * Visit given solar system by the given mother ship. Depending on various things the method decides what 'visiting'
     * actually means. If the solar system will be colonized etc.
     * @param galaxy The galaxy in which the visiting is happening.
     * @param solarSystem Visited solar system.
     * @param motherShip visiting mother ship.
     */
    public void visit(Galaxy galaxy, SolarSystem solarSystem, MotherShip motherShip) {
        // if empty square don't do anything
        if (solarSystem == null) {
            System.out.println("\t\tShip is on an empty square");
            return;
        }

        if (motherShip.getOwner() == solarSystem.getOwner()) {
            // if mother ship's race is the same as planet's owner extract resources
            extractResources(solarSystem, motherShip);
        } else if (!solarSystem.hasOwner()) {
            // if not colonized solar system try to colonize
            colonizeSolarSystem(solarSystem, motherShip);
        } else {
            // if solar system colonized by other race: visit and try to trade or fight
            visitOtherRace(galaxy, solarSystem, motherShip);
        }
    }
}