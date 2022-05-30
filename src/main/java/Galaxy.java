import app.config.ApplicationProperties;

import java.util.*;

public class Galaxy {
    private int sizeX;
    private int sizeY;
    private ArrayList<ArrayList<GalaxyField>> grid = new ArrayList<ArrayList<GalaxyField>>();
    private AlienRelationships alienRelationships = new AlienRelationships();
    private List<AlienRace> alienRaces = new ArrayList<AlienRace>();
    private Map<String, MotherShip> alienMotherShips = new HashMap<String, MotherShip>();
    private MotherShipMover motherShipMover = new MotherShipMover();
    private AlienRaceTrader alienRaceTrader = new AlienRaceTrader();
    private AlienRaceAttackingAlgo alienRaceAttackingAlgo;
    private ApplicationProperties config;
    private static final Random random = new Random();

    public AlienRaceAttackingAlgo getAlienRaceAttackingAlgo() {
        return alienRaceAttackingAlgo;
    }

    public void setAlienRaceAttacker(AlienRaceAttackingAlgo alienRaceAttackingALgo) {
        this.alienRaceAttackingAlgo = alienRaceAttackingAlgo;
    }

    public Galaxy(ApplicationProperties config) {
        this.config = config;
        this.sizeX = config.getGalaxySize();
        this.sizeY = config.getGalaxySize();

        initAlienRaceAttackingAlgo();
        initAliens();
        initGrid();
    }

    private void initAlienRaceAttackingAlgo() {
        switch (config.getAlienRaceAttackingAlgo()) {
            case "RandomAlienRaceAttackingAlgo":
                this.alienRaceAttackingAlgo = new RandomAlienRaceAttackingAlgo();
                break;
            case "NeighbourAlienRaceAttackingAlgo":
                this.alienRaceAttackingAlgo = new NeighbourAlienRaceAttackingAlgo();
                break;
            case "MoneyAlienRaceAttackingAlgo":
                this.alienRaceAttackingAlgo = new MoneyAlienRaceAttackingAlgo();
                break;
            default:
                this.alienRaceAttackingAlgo = new RandomAlienRaceAttackingAlgo();
                break;
        }
    }

    private void initAliens() {
        int alienAmount = config.getAlienAmount();
        for (int i = 0; i < alienAmount; i++) {
            int randomMoneyNumber = config.getMinStartingMoney() +
                    random.nextInt(config.getMaxStartingMoney() - config.getMinStartingMoney());
            AlienRace alienRace = new AlienRace(AlienNameGenerator.generate(), randomMoneyNumber);
            alienRaces.add(alienRace);
        }
    }

    private void initGrid() {
        // init grid
        for (int i = 0; i < this.sizeY; i++) {
            grid.add(new ArrayList<GalaxyField>(this.sizeX));
        }

        // init grid's solar systems
        for (int i = 0; i < this.sizeY; i++) {
            for (int j = 0; j < this.sizeX; j++) {
                if (random.nextDouble() <= config.getSpawnSolarSystemProbability()) {
                    int resourcesAmount = config.getMinSolarSystemResources() +
                            random.nextInt(config.getMaxSolarSystemResources() - config.getMinSolarSystemResources());
                    SolarSystem solarSystem;
                    if (config.getSpawnAlienProbability() <= random.nextDouble()) {
                        AlienRace randomRace = this.alienRaces.get(random.nextInt(this.alienRaces.size()));
                        solarSystem = new SolarSystem(resourcesAmount, 0, true, randomRace);
                    } else {
                        solarSystem = new SolarSystem(resourcesAmount, 0, false, null);
                    }

                    this.grid.get(i).set(j, new GalaxyField(solarSystem));
                }
            }
        }

        // init mother ships in grid
        for (int i = 0; i < config.getAlienAmount(); i++) {
            AlienRace alienRace = alienRaces.get(i);
            int x = random.nextInt(this.sizeX);
            int y = random.nextInt(this.sizeY);

            MotherShip motherShip = new MotherShip(x, y, 0, alienRace);
            alienRace.setMotherShip(motherShip);
            grid.get(y).get(x).getMotherShips().add(motherShip);
        }
    }

    public int getSizeX() {
        return sizeX;
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }

    public ArrayList<ArrayList<GalaxyField>> getGrid() {
        return grid;
    }

    public void setGrid(ArrayList<ArrayList<GalaxyField>> grid) {
        this.grid = grid;
    }

    public AlienRelationships getAlienRelationships() {
        return alienRelationships;
    }

    public void setAlienRelationships(AlienRelationships alienRelationships) {
        this.alienRelationships = alienRelationships;
    }

    public List<AlienRace> getAlienRaces() {
        return alienRaces;
    }

    public void setAlienRaces(List<AlienRace> alienRaces) {
        this.alienRaces = alienRaces;
    }

    public Map<String, MotherShip> getAlienMotherShips() {
        return alienMotherShips;
    }

    public void setAlienMotherShips(Map<String, MotherShip> alienMotherShips) {
        this.alienMotherShips = alienMotherShips;
    }

    public MotherShipMover getMotherShipMover() {
        return motherShipMover;
    }

    public void setMotherShipMover(MotherShipMover motherShipMover) {
        this.motherShipMover = motherShipMover;
    }

    public AlienRaceTrader getAlienRaceTrader() {
        return alienRaceTrader;
    }

    public void setAlienRaceTrader(AlienRaceTrader alienRaceTrader) {
        this.alienRaceTrader = alienRaceTrader;
    }

    public void makeStep() {
        for (AlienRace alienRace : alienRaces) {
            motherShipMover.randomMove(alienRace.getMotherShip(), this);
        }
    }

    public void print() {

    }
}
