package app.environment;

import app.alien.AlienRace;
import app.attack.AlienAttacker;
import app.config.ApplicationProperties;
import app.utility.AlienNameGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * A class for creating and initializing a galaxy class.
 */
public class GalaxyCreator {
    private static final Random random = new Random();

    /**
     * Create and return a galaxy.
     * @param config Config of the current context.
     * @param attacker attacking algorithm used in the simulation.
     * @return Returns the generated galaxy.
     */
    public static Galaxy create(ApplicationProperties config, AlienAttacker attacker) {
        Galaxy galaxy = new Galaxy(config, attacker);

        galaxy.setConfig(config);
        galaxy.setSizeX(config.getGalaxySize());
        galaxy.setSizeY(config.getGalaxySize());

        initAliens(galaxy, config);
        initGrid(galaxy, config);

        return galaxy;
    }

    /**
     * Create and initialize all alien races that will be used in the simulation.
     * @param galaxy Galaxy to initialize.
     * @param config Config of the current context.
     */
    private static void initAliens(Galaxy galaxy, ApplicationProperties config) {
        int alienAmount = config.getAlienAmount();
        for (int i = 0; i < alienAmount; i++) {
            int randomMoneyNumber = config.getMinStartingMoney() +
                    random.nextInt(config.getMaxStartingMoney() - config.getMinStartingMoney());
            AlienRace alienRace = new AlienRace(AlienNameGenerator.generate(random.nextInt()), randomMoneyNumber);
            galaxy.getAlienRaces().add(alienRace);
        }
    }

    /**
     * Initialize all the field's of a grid with random solar systems and mother ships of alien races.
     * @param galaxy Galaxy to initialize.
     * @param config Config of the current context.
     */
    private static void initGrid(Galaxy galaxy, ApplicationProperties config) {
        // init grid
        for (int i = 0; i < galaxy.getSizeY(); i++) {
            ArrayList<GalaxyField> line = new ArrayList<>();
            for (int j = 0; j < galaxy.getSizeX(); j++) {
                line.add(new GalaxyField(null));
            }
            galaxy.getGrid().add(line);
        }

        // init grid's solar systems
        for (int i = 0; i < galaxy.getSizeY(); i++) {
            for (int j = 0; j < galaxy.getSizeX(); j++) {
                if (random.nextDouble() <= config.getSpawnSolarSystemProbability()) {
                    int resourcesAmount = config.getMinSolarSystemResources() +
                            random.nextInt(config.getMaxSolarSystemResources() - config.getMinSolarSystemResources());
                    SolarSystem solarSystem;
                    if (config.getSpawnAlienProbability() <= random.nextDouble()) {
                        // Solar system is colonized
                        List<AlienRace> alienRaces = galaxy.getAlienRaces();
                        AlienRace randomRace = alienRaces.get(random.nextInt(alienRaces.size()));
                        solarSystem = new SolarSystem(resourcesAmount, 0, randomRace);
                    } else {
                        // Solar system is not colonized
                        solarSystem = new SolarSystem(resourcesAmount, 0, null);
                    }

                    galaxy.getGrid().get(i).set(j, new GalaxyField(solarSystem));
                }
            }
        }

        // init mother ships in grid
        for (int i = 0; i < config.getAlienAmount(); i++) {
            AlienRace alienRace = galaxy.getAlienRaces().get(i);
            int x = random.nextInt(galaxy.getSizeX());
            int y = random.nextInt(galaxy.getSizeY());

            MotherShip motherShip = new MotherShip(x, y, 0, alienRace);
            alienRace.setMotherShip(motherShip);
            galaxy.getGrid().get(y).get(x).getMotherShips().add(motherShip);
        }
    }
}