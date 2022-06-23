package app.attack.algo;

import app.alien.AlienRace;
import app.environment.Galaxy;
import app.environment.MotherShip;
import app.environment.SolarSystem;

/**
 * Check who should win the war by checking who has its own other solar system closer to the attacked solar system.
 */
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
            if (checkSolarSystem(attackingShip, attackedSolarSystem, solarSystem))
               return solarSystem.getOwner() == attackingShip.getOwner();

            solarSystem = scanLine(galaxy, x-i, y-i, x+i, y-i);
            if (checkSolarSystem(attackingShip, attackedSolarSystem, solarSystem))
                return solarSystem.getOwner() == attackingShip.getOwner();
            solarSystem = scanLine(galaxy, x-i, y+i, x-i, y-i);
            if (checkSolarSystem(attackingShip, attackedSolarSystem, solarSystem))
                return solarSystem.getOwner() == attackingShip.getOwner();
            solarSystem = scanLine(galaxy, x+i, y+i, x+i, y-i);
            if (checkSolarSystem(attackingShip, attackedSolarSystem, solarSystem))
                return solarSystem.getOwner() == attackingShip.getOwner();
        }
        return false;
    }

    /**
     * Check if a solar system found by scanLine is correct. Correct meaning it's owned by either the attacking side or
     * defending side.
     * @param solarSystem Solar system found by scanLine.
     * @param attackingShip Mother ship that is attacking the solar system.
     * @param attackedSolarSystem Solar system that is on the defending side.
     * @return
     */
    private boolean checkSolarSystem(MotherShip attackingShip, SolarSystem attackedSolarSystem, SolarSystem solarSystem) {
        if (solarSystem == null)
            return false;
        if (solarSystem.getOwner() == attackingShip.getOwner() || solarSystem.getOwner() == attackedSolarSystem.getOwner())
            return true;
        return false;
    }

    /**
     * Check if there's a solar system in the given line in the galaxy grid.
     * @param galaxy Galaxy to search for.
     * @param x1 X of first point of the searched line.
     * @param y1 Y of first point of the searched line.
     * @param x2 X of second point of the searched line.
     * @param y2 Y of second point of the searched line.
     * @return Found solar system.
     */
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