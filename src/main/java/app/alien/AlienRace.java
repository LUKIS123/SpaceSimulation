package app.alien;

import app.environment.MotherShip;
import app.environment.SolarSystem;

import java.util.ArrayList;
import java.util.List;

/**
 * A class for representing an alien race in the simulation.
 */
public class AlienRace {
    static private final List<String> usedNames = new ArrayList<>();
    private final List<SolarSystem> solarSystems = new ArrayList<>();
    private String name;
    private int money;
    private MotherShip motherShip;

    /**
     * @param name Name of the alien race.
     * @param money Starting money amount.
     */
    public AlienRace(String name, int money) {
        usedNames.add(name);
        this.name = name;
        this.money = money;
    }

    public List<SolarSystem> getSolarSystems() {
        return this.solarSystems;
    }

    /**
     * Add a solar system to the list of solar systems occupied by this race.
     * It's necessary because the list is later used by other methods.
     * @param solarSystem Solar system to add.
     */
    public void addSolarSystem(SolarSystem solarSystem) {
        this.solarSystems.add(solarSystem);
    }

    /**
     * Remove a solar system to the list of solar systems occupied by this race.
     * It's necessary because the list is later used by other methods.
     * @param solarSystem Solar system to add.
     */
    public void removeSolarSystem(SolarSystem solarSystem) {
        this.solarSystems.remove(solarSystem);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public MotherShip getMotherShip() {
        return motherShip;
    }

    /**
     * Add money owned by the alien race.
     * @param delta Money amount to add.
     */
    public void addMoney(int delta) {
        this.money += delta;
    }

    public void setMotherShip(MotherShip motherShip) {
        this.motherShip = motherShip;
    }

    @Override
    public String toString() {
        return "app.alien.AlienRace{" +
                "name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}