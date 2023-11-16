package battleship;

import battleship.util.Position;
import io.Input;

/**
 * The Game class represents a Battleship game.
 */
public class Game {
    private Sea sea;

    /**
     * Constructor for the Game class.
     *
     * @param sea The sea of the game.
     */
    public Game(Sea sea) {
        this.sea = sea;
    }

    /**
     * Launches the game, displays the attacker board, and returns the position shot
     * by the attacker.
     * When all boats are down, returns victory for the attacker.
     *
     * @throws InvalidShootException If the shoot is invalid.
     */
    public void play() throws InvalidShootException {
        while (sea.getRemainingLifePoints() != 0) {
            sea.display(false);
            try {
                System.out.println(sea.Shoot(inputPosition()));
            } catch (InvalidShootException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.print("You WIN !");
    }

    /**
     * Gets the sea of the game.
     *
     * @return The sea of the game.
     */
    public Sea getSea() {
        return this.sea;
    }

    /**
     * Takes input from the player for the position to shoot.
     * If the player enters a null position, it prompts for a valid position.
     *
     * @return The position entered by the player.
     */
    private Position inputPosition() {
        Position position = null;
        while (position == null) {
            System.out.println(
                    "Please enter the coordinates of the target cell (Column, Row) in the format LR, for example: F2 or A4");
            String input = Input.readString();
            String[] parts = input.split("");

            if (parts.length == 2) {
                try {
                    int x = Integer.parseInt(parts[1]);
                    int y = convertLetterToNumber(parts[0]);
                    position = new Position(x, y);
                } catch (NumberFormatException e) {
                    System.out.print("Please enter valid position information");
                }
            }
            if (position == null) {
                System.out.println("Error: Invalid format!");
            }
        }
        return position;
    }

    /**
     * Converts a letter to its corresponding numeric value.
     *
     * @param letter The letter to convert.
     * @return The numeric value of the letter.
     */
    private int convertLetterToNumber(String letter) {
        return letter.toUpperCase().charAt(0) - 'A';
    }
}