package battleship;

import battleship.util.Position;

/**
 * The SecondBattleShipMain class is the main class to run a simple Battleship
 * game.
 */
public class SecondBattleShipMain {
    /**
     * 
     * The main method of the Ship class.
     * 
     * @param args The command-line arguments.
     * @throws InvalidShootException         If the shoot is invalid.
     * @throws InvalidShipPlacementException If the ship placement is invalid.
     */
    public static void main(String[] args) throws InvalidShootException, InvalidShipPlacementException {
        // Create a sea with size 10x10
        Sea plat1 = new Sea(10, 10);

        // Create two ships with 1 life point each
        Ship s1 = new Ship(1);
        Ship s2 = new Ship(1);

        // Create positions for the ships
        Position position1 = new Position(0, 2);
        Position position3 = new Position(5, 7);

        // Add ships to the sea at specified positions
        plat1.addShip(s1, position1);
        plat1.addShip(s2, position3);

        // Display the sea with ships visible
        plat1.display(true);

        // Print the total remaining life points of the ships in the sea
        System.out.println(plat1.getRemainingLifePoints());

        // Create a new game instance with the sea and start playing
        new Game(plat1).play();
    }
}
