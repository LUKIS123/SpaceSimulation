package app.attack.algo;

import app.alien.AlienRace;
import app.environment.Galaxy;
import app.environment.MotherShip;
import app.environment.SolarSystem;

public class NeighbourAlienRaceAttackingAlgo implements AlienRaceAttackingAlgo {
    @Override
    public boolean attack(Galaxy galaxy, MotherShip attackingShip, SolarSystem attackedSolarSystem) {
        AlienRace attacker = attackingShip.getOwner();
        AlienRace attacked = attackedSolarSystem.getOwner();
        if (attacker.getSolarSystems().size() == 1)
            return false;
        if (attacked.getSolarSystems().size() == 1)
            return true;

        int size = Math.max(galaxy.getSizeX(), galaxy.getSizeY());
        int x = attackingShip.getPositionX();
        int y = attackingShip.getPositionY();
        for (int i = 1; i < size; i++) {
            SolarSystem solarSystem = scanLine(galaxy, x-i, y+i, x+i, y+i);
            if (solarSystem != null)
                return solarSystem.getOwner() == attackingShip.getOwner();
            solarSystem = scanLine(galaxy, x-i, y-i, x+i, y-i);
            if (solarSystem != null)
                return solarSystem.getOwner() == attackingShip.getOwner();
            solarSystem = scanLine(galaxy, x-i, y+i, x-i, y-i);
            if (solarSystem != null)
                return solarSystem.getOwner() == attackingShip.getOwner();
            solarSystem = scanLine(galaxy, x+i, y+i, x+i, y-i);
            if (solarSystem != null)
                return solarSystem.getOwner() == attackingShip.getOwner();
        }
        return false;
    }

    private SolarSystem scanLine(Galaxy galaxy, int x1, int y1, int x2, int y2) {
        int xStep = 0;
        int yStep = 0;

        if (x1 < x2)
            xStep = 1;
        else if (x1 > x2)
            xStep = -1;
        if (y1 < y2)
            yStep = 1;
        if (y1 > y2)
            yStep = -1;

        for (; x1 != x2 && y1 != y2; x1 += xStep, y1 += yStep) {
            if (x1 < 0 || x1 >= galaxy.getSizeX())
                continue;
            if (y1 < 0 || y1 >= galaxy.getSizeY())
                continue;
            SolarSystem solarSystem = galaxy.getGrid().get(y1).get(x1).getSolarSystem();
            if (solarSystem != null) {
                if (solarSystem.hasOwner())
                    return solarSystem;
            }
        }

        return null;
    }
}