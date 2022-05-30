public class SolarSystem {
    private int resourcesAmount;
    private int resourcesExtracted;
    private boolean hasOwner;
    private AlienRace owner;

    public SolarSystem(int resourcesAmount, int resourcesExtracted, boolean hasOwner, AlienRace owner) {
        this.resourcesAmount = resourcesAmount;
        this.resourcesExtracted = resourcesExtracted;
        this.hasOwner = hasOwner;
        this.owner = owner;
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

    public boolean isHasOwner() {
        return hasOwner;
    }

    public void setHasOwner(boolean hasOwner) {
        this.hasOwner = hasOwner;
    }

    public AlienRace getOwner() {
        return owner;
    }

    public void setOwnerName(AlienRace ownerName) {
        this.owner = owner;
    }

    public void addResourcesExtracted(int delta) {
        this.resourcesExtracted += delta;
    }
}
