import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Galaxy {
    private int sizeX;
    private int sizeY;
    private ArrayList<ArrayList<GalaxyField>> grid = new ArrayList<ArrayList<GalaxyField>>();
    private AlienRelatiopships alienRelatiopships;
    private List<AlienRace> alienRaces;
    private Map<String, MotherShip> alienMotherShips = new HashMap<String, MotherShip>();
    private MotherShipMover motherShipMover;
    private AlienRaceTrader alienRaceTrader;
    private AlienRaceAttackingAlgo alienRaceAttackingAlgo;

    public AlienRaceAttackingAlgo getAlienRaceAttackingAlgo() {
        return alienRaceAttackingAlgo;
    }

    public void setAlienRaceAttacker(AlienRaceAttackingAlgo alienRaceAttackingALgo) {
        this.alienRaceAttackingAlgo = alienRaceAttackingAlgo;
    }

    public Galaxy(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
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

    public AlienRelatiopships getAlienRelationships() {
        return alienRelatiopships;
    }

    public void setAlienRelationships(AlienRelatiopships alienRelatiopships) {
        this.alienRelatiopships = alienRelatiopships;
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

    }

    public void print() {

    }
}
