package app.config;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class JsonConfigurationTest {

    @Test
    void getConfig() {
        // Arrange
        JsonConfiguration jsonConfiguration = new JsonConfiguration("src/test/resources/testConfiguration.json");
        // Act
        Map<String, String> testArgsMap = jsonConfiguration.getConfig();
        // Assert
        assertEquals("111", testArgsMap.get("galaxySize"));
        assertEquals("0.1", testArgsMap.get("spawnAlienProbability"));
        assertEquals("0.2", testArgsMap.get("spawnSolarSystemProbability"));
        assertEquals("false", testArgsMap.get("randomAlienAmount"));
        assertEquals("22", testArgsMap.get("alienAmount"));
        assertEquals("3333", testArgsMap.get("minStartingMoney"));
        assertEquals("4444", testArgsMap.get("maxStartingMoney"));
        assertEquals("99", testArgsMap.get("minSolarSystemResources"));
        assertEquals("5556", testArgsMap.get("maxSolarSystemResources"));
        assertEquals("NeighbourRaceAttackingAlgo", testArgsMap.get("alienRaceAttackingAlgo"));
        assertEquals("99", testArgsMap.get("generationCount"));
    }
}