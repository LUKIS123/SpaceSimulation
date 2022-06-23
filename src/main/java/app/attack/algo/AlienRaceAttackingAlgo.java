package app.attack.algo;

import app.environment.Galaxy;
import app.environment.MotherShip;
import app.environment.SolarSystem;

/**
 * An interface for creating algorithms to determine the win condition of a war between two races on a solar system.
 */
public interface AlienRaceAttackingAlgo {
    /**
     * Check who should win the fight.
     * @param galaxy Galaxy in which its happening.
     * @param attackingShip Mother ship that is attacking the solar system.
     * @param attackedSolarSystem Solar system that is on the defending side.
     * @return returns if the attacking ship won or not.
     */
    public boolean attack(Galaxy galaxy, MotherShip attackingShip, SolarSystem attackedSolarSystem);
}