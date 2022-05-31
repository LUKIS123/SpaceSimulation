package app.config;

import java.util.HashMap;
import java.util.Map;

public class ConsoleConfiguration {
    private final Map<String, String> argsMap = new HashMap<>();

    public ConsoleConfiguration(String[] consoleInput) {
        try {
            for (int i = 0; i < consoleInput.length; i += 2) {
                String key = consoleInput[i];
                String value = consoleInput[i + 1];

                argsMap.put(key.substring(2, key.length()), value);
            }
        } catch (Exception e) {
            System.out.println("WARNING: One command is missing an argument or an incorrect input had been given\n");
            for (int i = 0; i < consoleInput.length - 1; i += 2) {
                String key = consoleInput[i];
                String value = consoleInput[i + 1];

                argsMap.put(key.substring(2, key.length()), value);
            }
        }
    }

    public Map<String, String> getConfig() {
        return argsMap;
    }
}