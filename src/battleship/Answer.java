package battleship;

/**
 * An enumeration representing possible answers for a shot in a Battleship game.
 * {@link #Missing}: Indicates that the shot missed and didn't hit any ship.
 * {@link #Hit}: Indicates that a ship has been hit.
 * {@link #Sunk}: Indicates that a ship has been sunk.
 */
public enum Answer {
    /**
     * indicates that the shot missed and didn't hit any ship
     */
    Missing,

    /**
     * indicates that a ship has been hit
     */
    Hit,

    /**
     * indicates that a ship has been sunk
     */
    Sunk;
}
