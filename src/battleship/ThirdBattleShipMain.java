package battleship;

import battleship.util.Position;

/**
 * The ThirdBattleShipMain class is the main class to run a simple Battleship
 * game.
 */
public class ThirdBattleShipMain {
    /**
     * 
     * The main method of the Ship class.
     * 
     * @param args The command-line arguments.
     * @throws InvalidShootException If the shoot is invalid.
     */
    public static void main(String[] args) throws InvalidShootException {
        // Create a sea with size 10x10
        Sea sea = new Sea(10, 10);

        // Create a ship with 2 life points and place it vertically
        Ship shipVertically = new Ship(2);

        // Create a ship with 3 life points and place it horizontally
        Ship shipHorizontally = new Ship(3);

        // Create a position for the vertically placed ship
        Position positionVertically = new Position(1, 1);

        // Create a position for the horizontally placed ship
        Position positionHorizontally = new Position(5, 5);

        // Add the vertically placed ship to the sea with orientation (0, 1)
        sea.addShip(shipVertically, positionVertically, 0, 1);

        // Add the horizontally placed ship to the sea with orientation (1, 0)
        sea.addShip(shipHorizontally, positionHorizontally, 1, 0);

        // Display the sea with ships visible
        sea.display(true);

        // Create a new game instance with the sea and start playing
        new Game(sea).play();
    }
}
