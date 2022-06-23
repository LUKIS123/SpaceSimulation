package app.utility;

import app.environment.Galaxy;
import app.environment.MotherShip;
import app.environment.SolarSystem;

import java.util.Random;

/**
 * A class that takes care of the trading done between races while visiting.
 */
public class AlienRaceTrader {

    private static final Random random = new Random();

    /**
     * Trade resources between two alien races.
     * @param galaxy Galaxy in which the trading is happening.
     * @param alienOneShip Visiting ship that wants to trade.
     * @param alienTwoSolarSystem Visited solar system that the ship trades with.
     */
    public void trade(Galaxy galaxy, MotherShip alienOneShip, SolarSystem alienTwoSolarSystem) {
        int randomDelta = -100 + random.nextInt(200);
        String name1 = alienOneShip.getOwner().getName();
        String name2 = alienTwoSolarSystem.getOwner().getName();

        int oldRel = galaxy.getAlienRelationships().getRelations().get(name1).get(name2).getRelationMeter();
        galaxy.getAlienRelationships().changeRelationship(name1, name2, randomDelta);

        int resources = alienOneShip.getResources();
        int rel = galaxy.getAlienRelationships().getRelations().get(name1).get(name2).getRelationMeter();
        int money = resources * (rel + 120) / 10;
        if (resources != 0)
            System.out.println("\t\tThey traded " + resources + " resources for " + money + " money");
        System.out.println("\t\tRelationship changed from: " + oldRel + " to: " + rel);

        alienTwoSolarSystem.addResourcesExtracted(resources);
        alienOneShip.getOwner().addMoney(money);
        alienOneShip.setResources(0);
    }
}