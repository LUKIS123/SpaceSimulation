import java.util.Random;

public class AlienRaceTrader {

    private static final Random random = new Random();

    public static void trade(Galaxy galaxy, MotherShip alienOneShip, SolarSystem alienTwoSolarSystem) {
        int randomDelta = -10 + random.nextInt(20);
        galaxy.getAlienRelationships().changeRelationship(
                alienOneShip.getOwner().getName(), alienTwoSolarSystem.getOwner().getName(), randomDelta);
        alienTwoSolarSystem.addResourcesExtracted(alienOneShip.getRecourses());
        alienOneShip.getOwner().addMoney(alienOneShip.getRecourses());
        alienOneShip.setRecourses(0);
    }
}
