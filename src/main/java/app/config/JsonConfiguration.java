package app.config;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JsonConfiguration {

    private JSONObject jsonObject;
    private final Map<String, String> argsMap = new HashMap<>();

    public JsonConfiguration() {
        readFile();
        parseJSONObject();
    }

    public void readFile() {
        JSONParser jsonParser = new JSONParser();
        Object object;
        try (FileReader reader = new FileReader("configuration.json")) {
            object = jsonParser.parse(reader);
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
        this.jsonObject = (JSONObject) object;
    }

    private void parseJSONObject() {

        JSONObject simulation = (JSONObject) this.jsonObject.get("Simulation");

        for (Object key : simulation.keySet()) {
            this.argsMap.put(String.valueOf(key), String.valueOf(simulation.get(key)));
        }
    }

    public Map<String, String> getConfig() {
        return argsMap;
    }
}