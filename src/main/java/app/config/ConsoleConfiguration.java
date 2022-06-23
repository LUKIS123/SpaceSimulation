package app.config;

import java.util.HashMap;
import java.util.Map;

/**
 * The class is used to take the arguments array and
    return a Map of them for further operations on it.
 */
public class ConsoleConfiguration implements IConsoleConfiguration {
    private final Map<String, String> argsMap = new HashMap<>();

    /**
     * This method is used to iterate through the
        arguments array and put them into a HashMap.
     * @param consoleInput the array od arguments that were given by the user.
     */
    public ConsoleConfiguration(String[] consoleInput) {
        try {
            for (int i = 0; i < consoleInput.length; i += 2) {
                String key = consoleInput[i];

                String value;
                String tmp = consoleInput[i + 1];
                if (tmp.startsWith("--")) {
                    System.out.println("WARNING: One argument is missing value");
                    i -= 1;
                    continue;
                } else {
                    value = tmp;
                }
                argsMap.put(key.substring(2), value);
            }
        } catch (Exception e) {
            System.out.println("WARNING: One command is missing an argument or an incorrect input had been given\n");
        }
    }

    /**
     * @return argsMap - map of the read arguments - (key, value).
     */
    public Map<String, String> getConfig() {
        return argsMap;
    }
}