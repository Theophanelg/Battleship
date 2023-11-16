package battleship;

/**
 * The Cell class represents a cell in a game grid.
 */
public class Cell {

    /**
     * Represents an empty cell.
     */
    public final static char CELL_EMPTY = '~';

    /**
     * Represents a cell with a boat that has not been touched.
     */
    public final static char CELL_WITH_BOAT_NOTOUCH = 'B';

    /**
     * Represents a cell with a boat that has been touched.
     */
    public final static char CELL_WITH_BOAT_TOUCH = '*';

    /**
     * Represents an unknown cell.
     */
    public final static char CELL_UNKNOWN = '.';

    private Ship ship;
    private boolean shot;

    /**
     * Constructor for the Cell class.
     */
    public Cell() {
        shot = false;
    }

    /**
     * Gets the ship in the cell.
     *
     * @return The ship in the cell.
     */
    public Ship getShip() {
        return this.ship;
    }

    /**
     * Sets the ship in the cell.
     *
     * @param ship The ship to set.
     */
    public void setShip(Ship ship) {
        this.ship = ship;
    }

    /**
     * Checks if the cell has a ship.
     *
     * @return true if the cell has a ship, false otherwise.
     */
    public boolean hasShip() {
        return this.ship != null;
    }

    /**
     * Checks if the cell has been hit by a shot.
     *
     * @return true if the cell has been hit, false otherwise.
     */
    public boolean hasBeenShot() {
        return shot;
    }

    /**
     * Checks if the cell is empty.
     *
     * @return true if the cell is empty, false otherwise.
     */
    public boolean isEmpty() {
        return this.ship == null;
    }

    /**
     * Performs a shot on the cell and returns the result of the shot.
     *
     * @return The result of the shot, which can be Answer.Missing, Answer.Hit, or
     *         Answer.Sunk.
     */
    public Answer shot() {
        if (isEmpty() || hasBeenShot()) {
            shot = true;
            return Answer.Missing;
        } else {
            shot = true;
            ship.beenHitting();
            if (getShip().getLifePoints() < 1) {
                return Answer.Sunk;
            }
        }
        return Answer.Hit;
    }

    /**
     * Returns a character representation of the cell's state based on the specified
     * perspective.
     *
     * @param defender If true, this method is called from the defender's
     *                 perspective; otherwise, it's from the attacker's perspective.
     * @return A character representing the cell's state, which can be CELL_EMPTY,
     *         CELL_WITH_BOAT_NOTOUCH, or CELL_UNKNOW.
     */
    public char toCharacter(boolean defender) {
        if (defender) {
            if (isEmpty()) {
                return CELL_EMPTY;
            }
            if (!hasBeenShot()) {
                return CELL_WITH_BOAT_NOTOUCH;
            }
        } else {
            if (!hasBeenShot()) {
                return CELL_UNKNOWN;
            }
            if (isEmpty()) {
                return CELL_EMPTY;
            }
        }
        return CELL_WITH_BOAT_TOUCH;
    }
}