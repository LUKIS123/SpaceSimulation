package app;

import app.attack.AlienAttackerFactory;
import app.config.ApplicationProperties;
import app.config.ArgumentHandler;
import app.config.ConsoleConfiguration;
import app.config.JsonConfiguration;
import app.environment.Galaxy;
import app.environment.GalaxyCreator;
import app.save.SaveGenerationData;
import app.utility.GalaxyPrinter;

public class Application {

    public static void main(String[] args) {
        ArgumentHandler argumentHandler = new ArgumentHandler(new ConsoleConfiguration(args), new JsonConfiguration("configuration.json"));
        ApplicationProperties applicationProperties = argumentHandler.getProperties();
        System.out.println(applicationProperties);

        Galaxy galaxy = GalaxyCreator.create(applicationProperties, AlienAttackerFactory.create(applicationProperties));

        SaveGenerationData saveGenerationData = new SaveGenerationData("output.csv");
        // saving starting state
        saveGenerationData.saveDataLines(galaxy, "Starting state");

        System.out.println("\n------------- Starting state: ------------");
        GalaxyPrinter.printAliens(galaxy);

        for (int i = 0; i < applicationProperties.getGenerationCount(); i++) {
            System.out.println("Generation " + (i + 1) + ":");

            galaxy.makeStep();
            // saving state of each generation
            saveGenerationData.saveDataLines(galaxy, String.valueOf(i + 1));

            if (i % 10 == 0 && i != 0) {
                System.out.println("------------ STATE AFTER " + (i + 1) + " GENERATIONS: ------------");
                GalaxyPrinter.printAliens(galaxy);
            }
        }
        System.out.println("\n------------- Ending state: ------------");
        GalaxyPrinter.printAliens(galaxy);
    }
}