import app.config.ArgumentHandler;
import app.config.ApplicationProperties;
import app.config.ConsoleConfiguration;
import app.config.JsonConfiguration;
import app.save.DataToCsvWriter;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        ArgumentHandler argumentHandler = new ArgumentHandler(new ConsoleConfiguration(args), new JsonConfiguration("configuration.json"));
        ApplicationProperties applicationProperties = argumentHandler.getProperties();
        System.out.println(applicationProperties);

        // SaveDataToCSV TEST====================================================
        List<String[]> dataLines = new ArrayList<>();
        DataToCsvWriter dataFile = new DataToCsvWriter("output.csv");
        // Flushing the data at first
        dataFile.flushCSVFile();
        // adding array od data to the list
        dataLines.add(new String[]
                {"John", "Doe", "38", "Comment Data"});
        // saving it
        dataFile.saveSimulationData(dataLines.get(0));
        // adding another array od data to the list
        dataLines.add(new String[]
                {"Jane", "Doe, Jr.", "19", "She said \"I'm being quoted\""});
        // saving it
        dataFile.saveSimulationData(dataLines.get(1));
        // END OF TEST==========================================================

        Galaxy galaxy = new Galaxy(applicationProperties);

        for (int i = 0; i < 5; i++) {
            System.out.println("Generation " + (i + 1) + ":");

            galaxy.makeStep();
            galaxy.print();
            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}