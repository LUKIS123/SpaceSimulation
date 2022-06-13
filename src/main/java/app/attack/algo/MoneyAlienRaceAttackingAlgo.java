package app.attack.algo;

import app.environment.Galaxy;
import app.environment.MotherShip;
import app.environment.SolarSystem;

public class MoneyAlienRaceAttackingAlgo implements AlienRaceAttackingAlgo {
    @Override
    public boolean attack(Galaxy galaxy, MotherShip attackingShip, SolarSystem attackedSolarSystem) {
        if (attackingShip.getOwner().getMoney() > attackedSolarSystem.getOwner().getMoney()) {
            return true;
        } else {
            return false;
        }
    }
}