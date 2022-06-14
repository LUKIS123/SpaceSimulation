package app.config;

import java.util.HashMap;
import java.util.Map;

public class MockJsonConfiguration implements IJsonConfiguration {

    @Override
    public Map<String, String> getConfig() {
        Map<String, String> mockArgs = new HashMap<>();
        mockArgs.put("galaxySize", "8");
        mockArgs.put("alienAmount", "12");
        mockArgs.put("minStartingMoney", "999");
        mockArgs.put("maxStartingMoney", "888");
        mockArgs.put("minSolarSystemResources", "777");
        mockArgs.put("maxSolarSystemResources", "666");
        mockArgs.put("alienRaceAttackingAlgo", "NeighbourRaceAttackingAlgo");
        mockArgs.put("colonizationCost", "100");

        return mockArgs;
    }
}