# SpaceSimulation
 OOP Project - a simple Agent-based simulation

The program can be run either by ```gadle``` task ```run``` with following set of arguments, for example:
```java
run --args="--galaxySize 100 --spawnAlienProbability 0.5 --spawnSolarSystemProbability 0.5 --randomAlienAmount false --alienAmount 5 --minStartingMoney 1000 --maxStartingMoney 1234 --minSolarSystemResources 100 --maxSolarSystemResources 1234 --alienRaceAttackingAlgo NeighbourRaceAttackingAlgo --generationCount 10"
```
Or you can run the ```SpaceSimulation-1.0-SNAPSHOT-all.jar``` file in the direcory ```\SpaceSimulation\build\libs``` with following set of arguments, for example:
```java
java -jar .\SpaceSimulation-1.0-SNAPSHOT-all.jar --galaxySize 200 --spawnAlienProbability 0.5 --spawnSolarSystemProbability 0.5 --randomAlienAmount false --alienAmount 5 --minStartingMoney 1000 --maxStartingMoney 1234 --minSolarSystemResources 100 --maxSolarSystemResources 1234 --alienRaceAttackingAlgo NeighbourRaceAttackingAlgo --generationCount 25
 ```
 __❗ Keep in mind, that the order of the arguments given doesn't matter ❗__
 <br /><br />
 It is also possible to provide the input arguments via ```configuration.json``` file, from which the default values are being loaded. For example you can run the program by providing the input you're interested in:
 ```java
 java -jar .\SpaceSimulation-1.0-SNAPSHOT-all.jar --galaxySize 500 --generationCount 33
 ```
 The rest of the arguments will be loaded from the .json file.
 
There are two separate ```configuration.json``` files, one of which is being used while running by ```gradle``` using Intellij. You can find it in the main folder ```\SpaceSimulation```. The second one is being used while running ```SpaceSimulation-1.0-SNAPSHOT-all.jar```, which you can find in the same folder ```\SpaceSimulation\build\libs```. 
<br /><br />
Example structure of the configuration.json file:
```json
{
  "Simulation": {
    "galaxySize": 250,
    "spawnAlienProbability": 0.5,
    "spawnSolarSystemProbability": 0.5,
    "randomAlienAmount": false,
    "alienAmount": 5,
    "minStartingMoney": 1000,
    "maxStartingMoney": 1234,
    "minSolarSystemResources": 100,
    "maxSolarSystemResources": 1234,
    "alienRaceAttackingAlgo": "MoneyAlienRaceAttackingAlgo",
    "generationCount": 5
  }
}
```
