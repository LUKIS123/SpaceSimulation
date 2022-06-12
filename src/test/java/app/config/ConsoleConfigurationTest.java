package app.config;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConsoleConfigurationTest {

    @Test
    void getConfig() {
        //Arrange
        String[] args = {"--galaxySize", "2137", "--spawnAlienProbability", "0.420", "--spawnSolarSystemProbability", "0.69", "--randomAlienAmount", "true",
                "--alienAmount", "911", "--minStartingMoney", "11", "--maxStartingMoney", "888", "--minSolarSystemResources", "0", "--maxSolarSystemResources", "555",
                "--alienRaceAttackingAlgo", "NeighbourRaceAttackingAlgo", "--generationCount", "99"};
        ConsoleConfiguration consoleConfiguration = new ConsoleConfiguration(args);
        //Act
        Map<String, String> testArgsMap = consoleConfiguration.getConfig();
        //Assert
        assertEquals("2137", testArgsMap.get("galaxySize"));
        assertEquals("0.420", testArgsMap.get("spawnAlienProbability"));
        assertEquals("0.69", testArgsMap.get("spawnSolarSystemProbability"));
        assertEquals("true", testArgsMap.get("randomAlienAmount"));
        assertEquals("911", testArgsMap.get("alienAmount"));
        assertEquals("11", testArgsMap.get("minStartingMoney"));
        assertEquals("888", testArgsMap.get("maxStartingMoney"));
        assertEquals("0", testArgsMap.get("minSolarSystemResources"));
        assertEquals("555", testArgsMap.get("maxSolarSystemResources"));
        assertEquals("NeighbourRaceAttackingAlgo", testArgsMap.get("alienRaceAttackingAlgo"));
        assertEquals("99", testArgsMap.get("generationCount"));
    }
}