import java.util.List;
import java.util.ArrayList;

public class GalaxyField {
    private SolarSystem solarSystem;
    // List of mother ships currently in the galaxy field
    private List<MotherShip> motherShips;

    public SolarSystem getSolarSystem() {
        return solarSystem;
    }

    public void setSolarSystem(SolarSystem solarSystem) {
        this.solarSystem = solarSystem;
    }

    public List<MotherShip> getMotherShips() {
        return motherShips;
    }

    public void setMotherShips(List<MotherShip> motherShips) {
        this.motherShips = motherShips;
    }

    public GalaxyField(SolarSystem solarSystem) {
        this.solarSystem = solarSystem;
    }
}
