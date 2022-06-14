package app.environment;

import app.alien.AlienRace;

import java.util.List;

public class MotherShip {
    private int positionX;
    private int positionY;
    private int resources;
    private AlienRace owner;

    public MotherShip(int positionX, int positionY, int recourses, AlienRace owner) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.resources = recourses;
        this.owner = owner;

    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getResources() {
        return resources;
    }

    public void setResources(int resources) {
        this.resources = resources;
    }

    public AlienRace getOwner() {
        return owner;
    }

    public void setOwner(AlienRace owner) {
        this.owner = owner;
    }

    public void addResources(int delta) {
        this.resources += delta;
    }

    public void destroyAndRespawn(Galaxy galaxy) {
        this.resources = 0;

        if (this.getOwner().getSolarSystems().size() > 0) {
            for (int i = 0; i < galaxy.getGrid().size(); i++) {
                List<GalaxyField> line = galaxy.getGrid().get(i);
                for (int j = 0; j < line.size(); j++) {
                    GalaxyField field = line.get(j);
                    SolarSystem solarSystem = field.getSolarSystem();
                    if (solarSystem.getOwner() == owner) {
                        this.positionX = j;
                        this.positionY = i;
                        return;
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        return owner.toString();
    }
}