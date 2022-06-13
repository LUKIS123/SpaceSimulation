package app;

import app.alien.AlienRace;
import app.config.ArgumentHandler;
import app.config.ApplicationProperties;
import app.config.ConsoleConfiguration;
import app.config.JsonConfiguration;
import app.environment.Galaxy;
import app.save.DataToCsvWriter;
import app.utility.GalaxyPrinter;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        ArgumentHandler argumentHandler = new ArgumentHandler(new ConsoleConfiguration(args), new JsonConfiguration("configuration.json"));
        ApplicationProperties applicationProperties = argumentHandler.getProperties();
        System.out.println(applicationProperties);

        Galaxy galaxy = new Galaxy(applicationProperties);

        System.out.println("\n------------- Starting state: ------------");
        GalaxyPrinter.printAliens(galaxy);

        for (int i = 0; i < applicationProperties.getGenerationCount(); i++) {
            System.out.println("Generation " + (i + 1) + ":");

            galaxy.makeStep();
            galaxy.print();

            if (i % 10 == 0) {
                System.out.println("------------ STATE AFTER " + (i + 1) + " GENERATIONS: ------------");
                GalaxyPrinter.printAliens(galaxy);
            }
        }

        System.out.println("\n------------- Ending state: ------------");
        GalaxyPrinter.printAliens(galaxy);

        saveToCsv(galaxy);
    }

    public static void saveToCsv(Galaxy galaxy) {
        // Save tp csv
        List<String[]> dataLines = new ArrayList<>();
        DataToCsvWriter dataFile = new DataToCsvWriter("output.csv");
        // Flushing the data at first
        dataFile.flushCSVFile();
        // adding array od data to the list
        dataLines.add(new String[]
                {"Alien race", "Money", "Solar Systems"});
        // saving it
        dataFile.saveSimulationData(dataLines.get(0));
        for (int i = 0; i < galaxy.getAlienRaces().size(); i++) {
            AlienRace alienRace = galaxy.getAlienRaces().get(i);
            // adding another array od data to the list
            dataLines.add(new String[]{
                    alienRace.getName(),
                    String.valueOf(alienRace.getMoney()),
                    String.valueOf(alienRace.getSolarSystems().size())
            });
            // saving it
            dataFile.saveSimulationData(dataLines.get(i+1));
        }
    }


}