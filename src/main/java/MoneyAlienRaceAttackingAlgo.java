public class MoneyAlienRaceAttackingAlgo implements AlienRaceAttackingAlgo {
    @Override
    public boolean attack(Galaxy galaxy, MotherShip attackingShip, SolarSystem attackedSolarSystem) {
        if (attackingShip.getOwner().getMoney() > attackedSolarSystem.getOwner().getMoney()) {
            return true;
        } else {
            return false;
        }
    }
}
