# Battleship

```bash
  A naval battle in JAVA
```

## Jar
```bash
  jar cvfm tv3.jar tv.TvMain3 -C classes tv
  jar cvfe tv3bis.jar tv.TvMain3 -c classes tv
  - Jar of Second and Third BattleShipMain
  jar cvfe SecondBattleShipMain.jar SecondBattleShipMain.java -c classes .
  jar cvfe ThirdBattleShipMain.jar SecondBattleShipMain.java -c classes .
```
## Compilation

```bash
  javac -classpath junit-console.jar:classes test/battleship/ShipTest.java
  - Compilation of the Battleship classe
  javac -cp src src/battleship/*.java -d classes
  javac -cp src src/io/*.java -d classes
  javac -cp src src/tv/*.java -d classes
```

## Execution

```bash
  java -jar tv3.jar Test
  java -jar tv3bis.jar Test2
  java -jar junit-console.jar -classpath test:classes -scan-classpath 
  - Execution of jar Second and Third BattleShipMain
  java -jar SecondBattleShipMain.jar Second
  java -jar ThirdBattleShipMain.jar Third
```

## Docs 

```bash
  javadoc -sourcepath src -subpackages battleship -d docs
```
## Authors

- [theophane.legrand.etu@univ-lille.fr](mailto:theophane.legrand.etu@univ-lille.fr)


