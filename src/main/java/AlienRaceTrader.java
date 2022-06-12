import java.util.Random;

public class AlienRaceTrader {

    private static final Random random = new Random();

    public void trade(Galaxy galaxy, MotherShip alienOneShip, SolarSystem alienTwoSolarSystem) {
        int randomDelta = -10 + random.nextInt(20);
        String name1 = alienOneShip.getOwner().getName();
        String name2 = alienTwoSolarSystem.getOwner().getName();

        galaxy.getAlienRelationships().changeRelationship(name1, name2, randomDelta);

        int resources = alienOneShip.getResources();
        int rel = galaxy.getAlienRelationships().getRelations().get(name1).get(name2).getRelationMeter();
        int money = resources * (rel + 120)/10;

        System.out.println("\t\tThey traded " + resources + " resources for " + money + " money");
        alienTwoSolarSystem.addResourcesExtracted(resources);
        alienOneShip.getOwner().addMoney(money);
        alienOneShip.setResources(0);
    }
}
