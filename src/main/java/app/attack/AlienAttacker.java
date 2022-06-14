package app.attack;

import app.attack.algo.AlienRaceAttackingAlgo;
import app.environment.Galaxy;
import app.environment.MotherShip;
import app.environment.SolarSystem;

public class AlienAttacker {
    private AlienRaceAttackingAlgo attackingAlgo;

    public AlienAttacker(AlienRaceAttackingAlgo attackingAlgo) {
        this.attackingAlgo = attackingAlgo;
    }

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