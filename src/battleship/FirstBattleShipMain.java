package battleship;

import battleship.util.Position;

/**
 * The FirstBattleShipMain class is the main class to run a simple Battleship
 * game.
 */
public class FirstBattleShipMain {
    /**
     * The main method to run the game.
     *
     * @param args The command-line arguments.
     * @throws InvalidShipPlacementException If the ship placement is invalid.
     * @throws InvalidShootException         If the shoot is invalid.
     */
    public static void main(String[] args) throws InvalidShipPlacementException, InvalidShootException {
        // Create a sea with size 10x10
        Sea test = new Sea(10, 10);

        // Create two ships with 1 life point each
        Ship s1 = new Ship(1);
        Ship s2 = new Ship(1);

        // Create positions for the ships
        Position position1 = new Position(0, 2);
        Position position2 = new Position(5, 7);

        // Add ships to the sea at specified positions
        test.addShip(s1, position1);
        test.addShip(s2, position2);

        // Shoot at the position of ship s1
        test.Shoot(position1);

        // Display the sea with ships visible
        test.display(true);

        // Display the sea without showing the ships
        test.display(false);
    }
}