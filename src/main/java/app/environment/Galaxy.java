package app.environment;

import app.alien.AlienRace;
import app.attack.algo.AlienRaceAttackingAlgo;
import app.attack.algo.MoneyAlienRaceAttackingAlgo;
import app.attack.algo.NeighbourAlienRaceAttackingAlgo;
import app.attack.algo.RandomAlienRaceAttackingAlgo;
import app.utility.AlienRaceTrader;
import app.alien.AlienRelationships;
import app.attack.*;
import app.config.ApplicationProperties;
import app.utility.AlienNameGenerator;

import java.util.*;

public class Galaxy {
    private int sizeX;
    private int sizeY;
    private ArrayList<ArrayList<GalaxyField>> grid = new ArrayList<>();
    private AlienRelationships alienRelationships = new AlienRelationships();
    private List<AlienRace> alienRaces = new ArrayList<>();
    private Map<String, MotherShip> alienMotherShips = new HashMap<>();
    private MotherShipMover motherShipMover = new MotherShipMover();
    private AlienRaceTrader alienRaceTrader = new AlienRaceTrader();
    private ApplicationProperties config;
    private SolarSystemVisitor solarSystemVisitor;


    public Galaxy(ApplicationProperties config, AlienAttacker alienAttacker) {
        this.config = config;
        this.solarSystemVisitor = new SolarSystemVisitor(alienAttacker);
    }

    public ApplicationProperties getConfig() {
        return config;
    }

    public void setConfig(ApplicationProperties config) {
        this.config = config;
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

    private void extractResources() {
        for (ArrayList<GalaxyField> line : grid) {
            for (GalaxyField field : line) {
                if (!field.isEmpty()) {
                    field.getSolarSystem().extractResources(config.getMinSolarSystemResources()/100);
                }
            }
        }
    }

    public void makeStep() {
        extractResources();

        for (AlienRace alienRace : alienRaces) {
            System.out.println("\t" + alienRace.getName() + ": ");

            // Move ship
            MotherShip motherShip = alienRace.getMotherShip();
            motherShipMover.randomMove(motherShip, this);
            System.out.println("\t\tShip moved to x=" + motherShip.getPositionX() + " y=" + motherShip.getPositionY());

            // visit solar system
            SolarSystem currSolarSystem = grid.get(motherShip.getPositionY()).get(motherShip.getPositionX()).getSolarSystem();
            this.solarSystemVisitor.visit(this, currSolarSystem, motherShip);
        }
    }
}
