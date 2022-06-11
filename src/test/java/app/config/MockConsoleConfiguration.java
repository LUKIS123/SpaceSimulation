package app.config;

import java.util.HashMap;
import java.util.Map;

public class MockConsoleConfiguration implements IConsoleConfiguration {

    @Override
    public Map<String, String> getConfig() {
        Map<String, String> mockArgs = new HashMap<>();
        mockArgs.put("galaxySize", "123");
        mockArgs.put("spawnAlienProbability", "0.111");
        mockArgs.put("spawnSolarSystemProbability", "0.222");
        mockArgs.put("randomAlienAmount", "false");

        return mockArgs;
    }
}