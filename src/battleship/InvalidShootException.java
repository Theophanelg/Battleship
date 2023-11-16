package battleship;

/**
 * The InvalidShootException class represents an exception that is thrown when a
 * shoot is invalid.
 */
public class InvalidShootException extends Exception {

   /**
    * Constructs a new InvalidShootException with the specified error message.
    *
    * @param message The error message.
    */
   public InvalidShootException(String message) {
      super(message);
   }
}