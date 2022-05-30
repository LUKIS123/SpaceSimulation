import java.util.Random;

public class AlienRaceTrader {

    private static final Random random = new Random();

    public void trade(Galaxy galaxy, MotherShip alienOneShip, SolarSystem alienTwoSolarSystem) {
        int randomDelta = -10 + random.nextInt(20);
        galaxy.getAlienRelationships().changeRelationship(
                alienOneShip.getOwner().getName(), alienTwoSolarSystem.getOwner().getName(), randomDelta);
        alienTwoSolarSystem.addResourcesExtracted(alienOneShip.getResources());
        alienOneShip.getOwner().addMoney(alienOneShip.getResources());
        alienOneShip.setResources(0);
    }
}
