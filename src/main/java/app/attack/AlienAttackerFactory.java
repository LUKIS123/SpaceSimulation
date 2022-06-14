package app.attack;

import app.attack.algo.AlienRaceAttackingAlgo;
import app.attack.algo.MoneyAlienRaceAttackingAlgo;
import app.attack.algo.NeighbourAlienRaceAttackingAlgo;
import app.attack.algo.RandomAlienRaceAttackingAlgo;
import app.config.ApplicationProperties;

public class AlienAttackerFactory {
    public static AlienAttacker create(ApplicationProperties config) {
        AlienRaceAttackingAlgo alienRaceAttackingAlgo;
        switch (config.getAlienRaceAttackingAlgo()) {
            case "app.attack.algo.RandomAlienRaceAttackingAlgo":
                alienRaceAttackingAlgo = new RandomAlienRaceAttackingAlgo();
                break;
            case "app.attack.algo.NeighbourAlienRaceAttackingAlgo":
                alienRaceAttackingAlgo = new NeighbourAlienRaceAttackingAlgo();
                break;
            case "app.attack.algo.MoneyAlienRaceAttackingAlgo":
                alienRaceAttackingAlgo = new MoneyAlienRaceAttackingAlgo();
                break;
            default:
                alienRaceAttackingAlgo = new RandomAlienRaceAttackingAlgo();
                break;
        }

        return new AlienAttacker(alienRaceAttackingAlgo);
    }
}