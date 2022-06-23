package app.environment;

import app.alien.AlienRace;

/**
 * Class for simulating the solar systems. Each solar system has its owner that extracts the solar system's resources.
 */
public class SolarSystem {
    private int resourcesAmount;
    private int resourcesExtracted;
    private AlienRace owner;

    /**
     * @param resourcesAmount Starting resources amount.
     * @param resourcesExtracted Starting resources that are already extracted. Usually set to 0.
     * @param owner The current owner of the solar system.
     */
    public SolarSystem(int resourcesAmount, int resourcesExtracted, AlienRace owner) {
        this.resourcesAmount = resourcesAmount;
        this.resourcesExtracted = resourcesExtracted;
        this.owner = owner;
        if (owner != null) {
            owner.addSolarSystem(this);
        }
    }

    public int getResourcesAmount() {
        return resourcesAmount;
    }

    public void setResourcesAmount(int resourcesAmount) {
        this.resourcesAmount = resourcesAmount;
    }

    public int getResourcesExtracted() {
        return resourcesExtracted;
    }

    public void setResourcesExtracted(int resourcesExtracted) {
        this.resourcesExtracted = resourcesExtracted;
    }

    public boolean hasOwner() {
        return this.owner != null;
    }

    public AlienRace getOwner() {
        return owner;
    }

    public void setOwner(AlienRace owner) {
        if (this.owner != null) {
            this.owner.removeSolarSystem(this);
        }
        if (owner != null) {
            owner.addSolarSystem(this);
        }
        this.owner = owner;
    }

    public void addResourcesExtracted(int delta) {
        this.resourcesExtracted += delta;
    }

    /**
     * Method for extracting resources from a planet. Each step of the simulations aliens extract a given amount.
     * @param amount Amount of resources to extract.
     */
    public void extractResources(int amount) {
        if (amount > resourcesAmount)
            amount = resourcesAmount;
        resourcesExtracted += amount;
        resourcesAmount -= amount;
    }
}