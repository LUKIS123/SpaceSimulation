package app.config;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * This class reads the configuration file and returns
    them as a HashMap. The json.simple external library
    was used to read and parse the data.
 */
public class JsonConfiguration implements IJsonConfiguration {

    private JSONObject jsonObject;
    private final String file;
    private final Map<String, String> argsMap = new HashMap<>();

    /**
     * Method implements the private methods used for
        reading the file and parsing them to a HashMap.
     * @param filePath configuration file directory.
     */
    public JsonConfiguration(String filePath) {
        this.file = filePath;
        readFile();
        parseJSONObject();
    }

    /**
     * This private method is used to the
        configuration.json file.
     */
    private void readFile() {
        JSONParser jsonParser = new JSONParser();
        Object object;
        try (FileReader reader = new FileReader(file)) {
            object = jsonParser.parse(reader);
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
        this.jsonObject = (JSONObject) object;
    }

    /**
     * This private method is used to iterate
        through the json object and put the
        String values to the Map.
     */
    private void parseJSONObject() {

        JSONObject simulation = (JSONObject) this.jsonObject.get("Simulation");

        for (Object key : simulation.keySet()) {
            this.argsMap.put(String.valueOf(key), String.valueOf(simulation.get(key)));
        }
    }

    /**
     * @return argsMap - map of the read arguments - (key, value).
     */
    public Map<String, String> getConfig() {
        return argsMap;
    }
}