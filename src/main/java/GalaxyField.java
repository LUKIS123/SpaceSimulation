import java.util.List;
import java.util.ArrayList;

public class GalaxyField {
    private SolarSystem solarSystem;
    // List of mother ships currently in the galaxy field
    private List<MotherShip> motherShips = new ArrayList<MotherShip>();

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

    public Boolean isEmpty() {
        return solarSystem == null;
    }

    @Override
    public String toString() {
        String[] output = {""};
        motherShips.forEach(motherShip -> {
            if(motherShip.getOwner()!=null)
            output[0] += motherShip.toString();
        });
        return output[0];
    }
}
