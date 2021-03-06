package app.config;

import java.util.Map;

/**
 * This class is used to combine the two Maps of
    String value data, parse them and return
    data in form of ArgumentProperties object.
    The console input is taken as preferred values.
 */
public class ArgumentHandler {
    private final Map<String, String> consoleArgsMap;
    private final Map<String, String> jsonArgsMap;

    /**
     * @param consoleConfig instance of the ConsoleConfiguration interface.
     * @param jsonConfig instance of the JsonConfiguration interface.
     */
    public ArgumentHandler(IConsoleConfiguration consoleConfig, IJsonConfiguration jsonConfig) {

        this.consoleArgsMap = consoleConfig.getConfig();

        this.jsonArgsMap = jsonConfig.getConfig();
    }

    private int getIntValue(String key) {
        try {
            if (consoleArgsMap.get(key) == null) {
                return Integer.parseInt(jsonArgsMap.get(key));
            } else {
                return Integer.parseInt(consoleArgsMap.get(key));
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0;
        }
    }

    private double getDoubleValue(String key) {
        try {
            if (consoleArgsMap.get(key) == null) {
                return Double.parseDouble(jsonArgsMap.get(key));
            } else {
                return Double.parseDouble(consoleArgsMap.get(key));
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0;
        }
    }

    private boolean getBooleanValue(String key) {
        try {
            if (consoleArgsMap.get(key) == null) {
                return Boolean.parseBoolean(jsonArgsMap.get(key));
            } else {
                return Boolean.parseBoolean(consoleArgsMap.get(key));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private String getStringValue(String key) {
        try {
            if (consoleArgsMap.get(key) == null) {
                return jsonArgsMap.get(key);
            } else {
                return consoleArgsMap.get(key);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * It uses the private getValue methods to parse
        the String data to the expected types of values.
     * @return ApplicationProperties -
        object of the class used fot holding the data.
     */
    public ApplicationProperties getProperties() {
        return new ApplicationProperties(getIntValue("galaxySize"), getDoubleValue("spawnAlienProbability"),
                getDoubleValue("spawnSolarSystemProbability"), getBooleanValue("randomAlienAmount"),
                getIntValue("alienAmount"), getIntValue("minStartingMoney"), getIntValue("maxStartingMoney"),
                getIntValue("minSolarSystemResources"), getIntValue("maxSolarSystemResources"),
                getStringValue("alienRaceAttackingAlgo"), getIntValue("generationCount"), getIntValue("colonizationCost"));
    }
}