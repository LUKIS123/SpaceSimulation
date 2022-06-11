package app.config;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArgumentHandlerTest {

    @Test
    void getProperties() {
        //Arrange
        ArgumentHandler argumentHandler = new ArgumentHandler(new MockConsoleConfiguration(), new MockJsonConfiguration());

        ApplicationProperties correctApplicationProperties = new ApplicationProperties(123, 0.111, 0.222, false,
                12, 999, 888, 777, 666, "NeighbourRaceAttackingAlgo");
        //Act
        ApplicationProperties applicationProperties = argumentHandler.getProperties();
        //Assert
        assertEquals(correctApplicationProperties.getGalaxySize(),applicationProperties.getGalaxySize());
        assertEquals(correctApplicationProperties.getSpawnAlienProbability(),applicationProperties.getSpawnAlienProbability());
        assertEquals(correctApplicationProperties.getSpawnSolarSystemProbability(),applicationProperties.getSpawnSolarSystemProbability());
        assertEquals(correctApplicationProperties.isRandomAlienAmount(), applicationProperties.isRandomAlienAmount());
        assertEquals(correctApplicationProperties.getAlienAmount(), applicationProperties.getAlienAmount());
        assertEquals(correctApplicationProperties.getMinStartingMoney(), applicationProperties.getMinStartingMoney());
        assertEquals(correctApplicationProperties.getMaxStartingMoney(), applicationProperties.getMaxStartingMoney());
        assertEquals(correctApplicationProperties.getMinSolarSystemResources(), applicationProperties.getMinSolarSystemResources());
        assertEquals(correctApplicationProperties.getMaxSolarSystemResources(), applicationProperties.getMaxSolarSystemResources());
        assertEquals(correctApplicationProperties.getAlienRaceAttackingAlgo(), applicationProperties.getAlienRaceAttackingAlgo());
    }
}