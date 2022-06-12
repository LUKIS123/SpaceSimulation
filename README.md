# SpaceSimulation
 OOP Project - a simple Agent-based simulation

The program can be run either by ```gadle``` task ```run``` with following set of arguments, for example:
```java
run --args="--galaxySize 10 --spawnAlienProbability 0.5 --spawnSolarSystemProbability 0.5 --randomAlienAmount false --alienAmount 5 --minStartingMoney 1000 --maxStartingMoney 1234 --minSolarSystemResources 100 --maxSolarSystemResources 1234 --alienRaceAttackingAlgo NeighbourRaceAttackingAlgo"
```
Or you can run the ```SpaceSimulation-1.0-SNAPSHOT-all.jar``` file in the direcory ```\SpaceSimulation\build\libs``` with following set of arguments, for example:
```java
java -jar .\SpaceSimulation-1.0-SNAPSHOT-all.jar --galaxySize 200 --spawnAlienProbability 0.5 --spawnSolarSystemProbability 0.5 --randomAlienAmount false --alienAmount 5 --minStartingMoney 1000 --maxStartingMoney 1234 --minSolarSystemResources 100 --maxSolarSystemResources 1234 --alienRaceAttackingAlgo NeighbourRaceAttackingAlgo
 ```
 It is also possible to provide the input arguments via ```configuration.json``` file, from which the default values are being loaded. For example you can run the program by providing the input you're interested in:
 ```java
 java -jar .\SpaceSimulation-1.0-SNAPSHOT-all.jar --galaxySize 500
 ```
 The rest of the arguments will be loaded from the .json file.
