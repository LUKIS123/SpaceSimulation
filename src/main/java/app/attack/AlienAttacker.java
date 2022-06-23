package app.attack;

import app.attack.algo.AlienRaceAttackingAlgo;
import app.environment.Galaxy;
import app.environment.MotherShip;
import app.environment.SolarSystem;

/**
 * A wrapper for the attacking algorithm interface.
 */
public class AlienAttacker {
    private final AlienRaceAttackingAlgo attackingAlgo;

    /**
     * @param attackingAlgo Attacking algorithm to be initialized with.
     */
    public AlienAttacker(AlienRaceAttackingAlgo attackingAlgo) {
        this.attackingAlgo = attackingAlgo;
    }

    /**
     * Determine the winner of the war. If attacking side win they take over the planet. If defending side win they
     * destroy the mother ship and take over its resources.
     * @param galaxy Galaxy in which its happening.
     * @param attackingShip Mother ship that is attacking the solar system.
     * @param attackedSolarSystem Solar system that is on the defending side.
     */
    public void attack(Galaxy galaxy, MotherShip attackingShip, SolarSystem attackedSolarSystem) {
        if (attackingAlgo.attack(galaxy, attackingShip, attackedSolarSystem)) {
            System.out.println("\t\tAttackers win and take over the planet");
            attackedSolarSystem.setOwner(attackingShip.getOwner());
        } else {
            System.out.println("\t\tDefenders win and destroy the mother ship");
            attackedSolarSystem.addResourcesExtracted(attackingShip.getResources());
            attackingShip.destroyAndRespawn(galaxy);
        }
    }
}