import app.config.FromConsoleConfigurer;
import app.config.FromJSONConfigurer;
import app.config.ApplicationProperties;
import app.save.SaveDataToCSV;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // test
        //reading application arguments from console input
        FromConsoleConfigurer consoleConfigurer = new FromConsoleConfigurer(args);
        ApplicationProperties consoleAppProperties = consoleConfigurer.parseConsoleInput();
        System.out.println(consoleAppProperties.toString()+"\n");
        //reading application arguments from configuration.json
        FromJSONConfigurer jsonConfigurer = new FromJSONConfigurer();
        ApplicationProperties jsonAppProperties = jsonConfigurer.parseConfigurationObject(jsonConfigurer.readJSONFile());
        //running with properties
        System.out.println(jsonAppProperties.toString());

        //SaveDataToCSV TEST====================================================
        List<String[]> dataLines = new ArrayList<>();
        SaveDataToCSV dataFile = new SaveDataToCSV("output.csv");
        //Flushing the data at first
        dataFile.flushCSVFile();
        //adding array od data to the list
        dataLines.add(new String[]
                {"John", "Doe", "38", "Comment Data"});
        //saving it
        dataFile.saveSimulationData(dataLines.get(0));
        //adding another array od data to the list
        dataLines.add(new String[]
                {"Jane", "Doe, Jr.", "19", "She said \"I'm being quoted\""});
        //saving it
        dataFile.saveSimulationData(dataLines.get(1));
        //AlienNameGenerator===================================================
        System.out.println("\nExample Alien names test\n");
        for (int i = 0; i < 5; i++) {
            System.out.println(AlienNameGenerator.generate());
        }
        System.out.println("\nEnd of test\n");
        //END OF TEST==========================================================

        Galaxy galaxy = new Galaxy(1, 2);

        for (int i = 0; i < 5; i++) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
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