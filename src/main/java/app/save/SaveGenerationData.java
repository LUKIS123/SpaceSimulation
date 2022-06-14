package app.save;

import app.alien.AlienRace;
import app.environment.Galaxy;

import java.util.ArrayList;
import java.util.List;

public class SaveGenerationData {

    private final String[] headline = {"Generation", "Alien race", "Money", "Solar Systems"};
    private final List<String[]> dataLines = new ArrayList<>();
    private final DataToCsvWriter dataToCsvWriter;

    public SaveGenerationData(String fileName) {
        this.dataToCsvWriter = new DataToCsvWriter(fileName);
        prepareFile();
    }

    private void prepareFile() {
        this.dataToCsvWriter.flushCSVFile();
        this.dataToCsvWriter.saveSimulationData(this.headline);
    }

    public void saveDataLines(Galaxy galaxyState, String generationCount) {
        for (int i = 0; i < galaxyState.getAlienRaces().size(); i++) {
            AlienRace alienRace = galaxyState.getAlienRaces().get(i);
            this.dataLines.add(new String[]{
                    generationCount,
                    alienRace.getName(),
                    String.valueOf(alienRace.getMoney()),
                    String.valueOf(alienRace.getSolarSystems().size())
            });
            this.dataToCsvWriter.saveSimulationData(dataLines.get(i));
        }
        dataLines.clear();
    }
}