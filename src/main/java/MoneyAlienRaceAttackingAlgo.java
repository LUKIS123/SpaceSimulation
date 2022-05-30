public class MoneyAlienRaceAttackingAlgo implements AlienRaceAttackingAlgo {
    @Override
    public void attack(Galaxy galaxy, MotherShip attackingShip, SolarSystem attackedSolarSystem) {
        if (attackingShip.getOwner().getMoney() > attackedSolarSystem.getOwner().getMoney()) {
            attackedSolarSystem.addResourcesExtracted(attackingShip.getResources());
            attackingShip.destroyAndRespawn();
        } else {
            attackedSolarSystem.setOwner(attackingShip.getOwner());
        }
    }
}
