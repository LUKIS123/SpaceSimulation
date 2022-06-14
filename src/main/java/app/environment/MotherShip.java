package app.environment;

import app.alien.AlienRace;

public class MotherShip {
    private int positionX;
    private int positionY;
    private int resources;
    private AlienRace owner;

    public void visitSolarSystem(SolarSystem solarSystem) {
    }

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

    public void destroyAndRespawn() {
        this.resources = 0;
    }

    @Override
    public String toString() {
        return owner.toString();
    }
}