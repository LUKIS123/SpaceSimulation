package app.config;

import java.util.HashMap;
import java.util.Map;

public class FromConsoleConfigurer {
    private final Map<String, String> argsMap = new HashMap<>();

    public FromConsoleConfigurer(String[] consoleInput) {
        for (int i = 0; i < consoleInput.length; i += 2) {
            String key = consoleInput[i];
            String value = consoleInput[i + 1];

            argsMap.put(key.substring(2, key.length()), value);
        }
    }

    public int getIntValue(String key) {
        return Integer.parseInt(argsMap.get(key));
    }

    public boolean getBooleanValue(String key) {
        return Boolean.parseBoolean(argsMap.get(key));
    }

    public double getDoubleValue(String key) {
        return Double.parseDouble(argsMap.get(key));
    }

    public String getStringValue(String key) {
        return argsMap.get(key);
    }

    public ApplicationProperties parseConsoleInput(){

        return new ApplicationProperties(getIntValue("galaxySize"), getDoubleValue("spawnAlienProbability"), getDoubleValue("spawnSolarSystemProbability"), getBooleanValue("randomAlienAmount"), getIntValue("alienAmount"), getIntValue("minStartingMoney"), getIntValue("maxStartingMoney"), getIntValue("minSolarSystemResources"), getIntValue("maxSolarSystemResources"), getStringValue("alienRaceAttackingAlgo"));
    }
}
