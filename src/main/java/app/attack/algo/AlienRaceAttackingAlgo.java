package app.attack.algo;

import app.environment.Galaxy;
import app.environment.MotherShip;
import app.environment.SolarSystem;

public interface AlienRaceAttackingAlgo {
    public boolean attack(Galaxy galaxy, MotherShip attackingShip, SolarSystem attackedSolarSystem);
}
