package app.config;

public class ApplicationProperties {

    private final int galaxySize;
    private final double spawnLifeProbability;
    private final String alienRaceAttackingAlgo;

    public ApplicationProperties(int galaxySize, double spawnLifeProbability, String alienRaceAttackingAlgo) {
        this.galaxySize = galaxySize;
        this.spawnLifeProbability = spawnLifeProbability;
        this.alienRaceAttackingAlgo = alienRaceAttackingAlgo;
    }

    public int getGalaxySize() {
        return galaxySize;
    }

    public double getSpawnLifeProbability() {
        return spawnLifeProbability;
    }

    public String getAlienRaceAttackingAlgo() {
        return alienRaceAttackingAlgo;
    }

    @Override
    public String toString() {
        return "ApplicationProperties{" +
                "galaxySize=" + galaxySize +
                ", spawnLifeProbability=" + spawnLifeProbability +
                ", alienRaceAttackingAlgo='" + alienRaceAttackingAlgo + '\'' +
                '}';
    }
}