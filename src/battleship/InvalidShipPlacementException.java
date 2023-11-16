package battleship;

/**
 * The InvalidShipPlacementException class represents an exception that is
 * thrown when a ship placement is invalid.
 */
public class InvalidShipPlacementException extends Exception {

    /**
     * Constructs a new InvalidShipPlacementException with the specified error
     * message.
     *
     * @param message The error message.
     */
    public InvalidShipPlacementException(String message) {
        super(message);
    }
}