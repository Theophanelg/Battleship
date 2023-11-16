package battleship;

/**
 * The Ship class represents a ship in the battleship game.
 */
public class Ship {
    /**
     * The total remaining life points of all ships.
     */
    public static int SHIP_LIFES = 0;
    private int lifePoint;

    /**
     * Constructor of ship
     * 
     * @param length of the ship
     */
    public Ship(int length) {
        this.lifePoint = length;
    }

    /**
     * Check if the ship has been sunk.
     * 
     * @return True if the ship has been sunk, false otherwise.
     */
    public boolean hasBeenSunk() {
        if (getLifePoints() < 1) {
            return true;
        }
        return false;
    }

    /**
     * Reduce the ship's life points by 1 when it has been hit.
     */
    public void beenHitting() {
        this.lifePoint--;
        SHIP_LIFES--;
    }

    /**
     * Get the life point of the boat
     * 
     * @return lifepoint
     */
    public int getLifePoints() {
        return this.lifePoint;
    }

    public String toString() {
        return "This ship has " + getLifePoints() + " life points";
    }
}
