package app.config;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class ApplicationConfigurer {
    public ApplicationConfigurer() {
    }

    public JSONObject readJSONFile() {
        JSONParser jsonParser = new JSONParser();
        Object object;
        try (FileReader reader = new FileReader("configuration.json")) {
            object = jsonParser.parse(reader);
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
        return (JSONObject) object;
    }

    public ApplicationProperties parseConfigurationObject(JSONObject arg) {
        JSONObject Simulation = (JSONObject) arg.get("Simulation");
        Long galaxySize = (Long) Simulation.get("galaxySize");
        Double spawnLifeProbability = (Double) Simulation.get("spawnLifeProbability");
        String alienRaceAttackingAlgo = (String) Simulation.get("alienRaceAttackingAlgo");

        return new ApplicationProperties(galaxySize.intValue(), spawnLifeProbability, alienRaceAttackingAlgo);
    }
}