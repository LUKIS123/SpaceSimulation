package app.attack.algo;

import app.environment.Galaxy;
import app.environment.MotherShip;
import app.environment.SolarSystem;

import java.util.Random;

public class RandomAlienRaceAttackingAlgo implements AlienRaceAttackingAlgo {

    private static final Random random = new Random();

    @Override
    public boolean attack(Galaxy galaxy, MotherShip attackingShip, SolarSystem attackedSolarSystem) {
        if (random.nextInt(2) == 1) {
            return true;
        } else {
            return false;
        }
    }
}