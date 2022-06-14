package app.config;

public class ApplicationProperties {
    private final int galaxySize;
    private final double spawnAlienProbability;
    private final double spawnSolarSystemProbability;
    private final boolean randomAlienAmount;
    private final int alienAmount;
    private final int minStartingMoney;
    private final int maxStartingMoney;
    private final int minSolarSystemResources;
    private final int maxSolarSystemResources;
    private final String alienRaceAttackingAlgo;
    private final int generationCount;
    private final int colonizationCost;

    public ApplicationProperties(
            int galaxySize,
            double spawnAlienProbability,
            double spawnSolarSystemProbability,
            boolean randomAlienAmount,
            int alienAmount,
            int minStartingMoney,
            int maxStartingMoney,
            int minSolarSystemResources,
            int maxSolarSystemResources,
            String alienRaceAttackingAlgo, int generationCount, int colonizationCost) {
        this.galaxySize = galaxySize;
        this.spawnAlienProbability = spawnAlienProbability;
        this.spawnSolarSystemProbability = spawnSolarSystemProbability;
        this.randomAlienAmount = randomAlienAmount;
        this.alienAmount = alienAmount;
        this.minStartingMoney = minStartingMoney;
        this.maxStartingMoney = maxStartingMoney;
        this.minSolarSystemResources = minSolarSystemResources;
        this.maxSolarSystemResources = maxSolarSystemResources;
        this.alienRaceAttackingAlgo = alienRaceAttackingAlgo;
        this.generationCount = generationCount;
        this.colonizationCost = colonizationCost;
    }

    public double getSpawnSolarSystemProbability() {
        return spawnSolarSystemProbability;
    }

    public int getColonizationCost() {
        return colonizationCost;
    }

    public boolean isRandomAlienAmount() {
        return randomAlienAmount;
    }

    public int getAlienAmount() {
        return alienAmount;
    }

    public int getMinStartingMoney() {
        return minStartingMoney;
    }

    public int getMaxStartingMoney() {
        return maxStartingMoney;
    }

    public int getMinSolarSystemResources() {
        return minSolarSystemResources;
    }

    public int getMaxSolarSystemResources() {
        return maxSolarSystemResources;
    }

    public int getGalaxySize() {
        return galaxySize;
    }

    public double getSpawnAlienProbability() {
        return spawnAlienProbability;
    }

    public String getAlienRaceAttackingAlgo() {
        return alienRaceAttackingAlgo;
    }

    public int getGenerationCount() {
        return generationCount;
    }

    @Override
    public String toString() {
        return "ApplicationProperties{" +
                "galaxySize=" + galaxySize +
                ", spawnAlienProbability=" + spawnAlienProbability +
                ", spawnSolarSystemProbability=" + spawnSolarSystemProbability +
                ", randomAlienAmount=" + randomAlienAmount +
                ", alienAmount=" + alienAmount +
                ", minStartingMoney=" + minStartingMoney +
                ", maxStartingMoney=" + maxStartingMoney +
                ", minSolarSystemResources=" + minSolarSystemResources +
                ", maxSolarSystemResources=" + maxSolarSystemResources +
                ", alienRaceAttackingAlgo='" + alienRaceAttackingAlgo + '\'' +
                ", generationCount=" + generationCount +
                ", colonizationCost=" + colonizationCost +
                '}';
    }
}