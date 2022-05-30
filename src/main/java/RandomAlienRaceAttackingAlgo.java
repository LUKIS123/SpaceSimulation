import java.util.Random;

public class RandomAlienRaceAttackingAlgo implements AlienRaceAttackingAlgo {

    private static final Random random = new Random();
    @Override
    public void attack(Galaxy galaxy, MotherShip attackingShip, SolarSystem attackedSolarSystem) {
        if (random.nextInt(2) == 0) {
            attackedSolarSystem.addResourcesExtracted(attackingShip.getResources());
            attackingShip.destroyAndRespawn();
        } else {
            attackedSolarSystem.setOwner(attackingShip.getOwner());
        }
    }
}
