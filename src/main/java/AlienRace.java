import scala.annotation.meta.setter;

import java.util.ArrayList;
import java.util.List;

public class AlienRace {
    static private List<String> usedNames = new ArrayList<String>();
    private List<SolarSystem> solarSystems = new ArrayList<SolarSystem>();
    private String name;
    private int money;
    private MotherShip motherShip;

    public AlienRace(String name, int money) {
        usedNames.add(name);
        this.name = name;
        this.money = money;
    }

    public List<SolarSystem> getSolarSystems() {
        return this.solarSystems;
    }

    public void addSolarSystem(SolarSystem solarSystem) {
        this.solarSystems.add(solarSystem);
    }

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

    public void addMoney(int delta) {
        this.money += delta;
    }

    public void setMotherShip(MotherShip motherShip) {
        this.motherShip = motherShip;
    }

    @Override
    public String toString() {
        return "AlienRace{" +
                "name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}
