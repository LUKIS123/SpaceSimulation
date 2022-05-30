package app.config;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class FromJSONConfigurer {
    public FromJSONConfigurer() {
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
        Double spawnAlienProbability = (Double) Simulation.get("spawnAlienProbability");
        Double spawnSolarSystemProbability = (Double) Simulation.get("spawnSolarSystemProbability");
        Boolean randomAlienAmount = (Boolean) Simulation.get("randomAlienAmount");
        Long alienAmount = (Long) Simulation.get("alienAmount");
        Long minStartingMoney = (Long) Simulation.get("minStartingMoney");
        Long maxStartingMoney = (Long) Simulation.get("maxStartingMoney");
        Long minSolarSystemResources = (Long) Simulation.get("minSolarSystemResources");
        Long maxSolarSystemResources = (Long) Simulation.get("maxSolarSystemResources");
        String alienRaceAttackingAlgo = (String) Simulation.get("alienRaceAttackingAlgo");

        return new ApplicationProperties(
                galaxySize.intValue(),
                spawnAlienProbability,
                spawnSolarSystemProbability,
                randomAlienAmount,
                alienAmount.intValue(),
                minStartingMoney.intValue(),
                maxStartingMoney.intValue(),
                minSolarSystemResources.intValue(),
                maxSolarSystemResources.intValue(),
                alienRaceAttackingAlgo
        );
    }
}