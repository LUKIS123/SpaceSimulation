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


/**
 * Class Application is the main class.
 * It combines the individual elements of the simulation which are responsible for individual tasks.
 */
public class Application {

    /**
     * This static method runs the whole simulation.
     * Firstly, the provided arguments are being parsed, which then are handed over to
        the class responsible for the simulation making another step each generation.
        In the meantime simulation data is being saved to a csv file.
     * @param args the array of Strings, which may be provided by the user from console.
     */

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