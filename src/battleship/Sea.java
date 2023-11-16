package battleship;

import battleship.util.Position;

/**
 * The Sea class represents the game board for the battleship game.
 */
public class Sea {
    private int length;
    private int width;
    private Cell[][] cells;

    /**
     * Constructor of sea
     * 
     * @param length lenght of the cell
     * @param width  width of the cell
     */
    public Sea(int length, int width) {
        this.length = length;
        this.width = width;

        cells = new Cell[length][width];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    /**
     * Add ship in the positon on cells
     * 
     * @param s ship
     * @param p position in the cells
     * @throws InvalidShipPlacementException if the placement was invalid
     */
    public void addShip(Ship s, Position p) throws InvalidShipPlacementException {
        int x = p.getX();
        int y = p.getY();
        if (x >= 0 && x < length && y >= 0 && y < width) {
            if (!cells[x][y].hasShip()) {
                cells[x][y].setShip(s);
                Ship.SHIP_LIFES += s.getLifePoints();
            } else {
                throw new InvalidShipPlacementException("Cell already occuped by another ship");
            }
        } else {
            throw new InvalidShipPlacementException("Ship placement is outside the limit");
        }
    }

    /**
     * shoot on the position x y and return the shot on cell
     * 
     * @param p position x y
     * @return the cell shot
     * @throws InvalidShootException check if the shoot was invalid
     */
    public Answer Shoot(Position p) throws InvalidShootException {
        int x = p.getX();
        int y = p.getY();
        if (x > this.length || y > this.width) {
            throw new InvalidShootException("Invalid shoot expection");
        } else {
            Cell cell = cells[x][y];
            return cell.shot();
        }
    }

    /**
     * get the total of life points
     * 
     * @return the total life points
     */
    public int getRemainingLifePoints() {
        return Ship.SHIP_LIFES;
    }

    /**
     * display the game board line by line and cell by cell, on standard output,
     * the display is different for the defender or the attacker, according to
     * parameter
     * 
     * @param isDefender true if display is for defender, false if for opponent
     */
    public void display(boolean isDefender) {
        System.out.print(" ");
        for (int i = 0; i < cells.length; i++) {
            System.out.printf(" " + (char) (i + 65));
        }
        System.out.println();

        for (int i = 0; i < cells.length; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < cells[i].length; j++) {
                System.out.printf("%c ", cells[i][j].toCharacter(isDefender));
            }
            System.out.println();
        }
    }

    /**
     * Test if the ship can be placed vertically and check if a boat was not placed
     * on the cells
     * 
     * @param shipToPlace the ship to add
     * @param position    The position of the cell
     * @throws IllegalStateException if the ship can not be placed on the sea
     */
    private void testIfShipCanBePlacedVertically(Ship shipToPlace, Position position) throws IllegalStateException {
        if (position.getY() + shipToPlace.getLifePoints() > width) {
            throw new IllegalStateException("The boat was on the limit of the sea");
        }
        for (int i = position.getX(); i < position.getX() + shipToPlace.getLifePoints(); i++) {
            if (cells[i][position.getY()].hasShip()) {
                throw new IllegalStateException(
                        "Cells at the position " + i + ", " + position.getY() + " was already occuped.");
            }
        }
    }

    // Question 15
    /**
     * add the ship b to this game’s sea. Ship is added vertically down from
     * position p.
     * The number of cells is determined by the ship life points.
     * 
     * @param shipToPlace the ship to add
     * @param position    the position of the first (top) cell occupied by the ship
     * @throws IllegalStateException if the ship b can not be placed on the sea
     */
    /*
     * public void addShipVertically(Ship shipToPlace, Position position) throws
     * IllegalStateException {
     * testIfShipCanBePlacedVertically(shipToPlace, position);
     * for (int i = position.getX(); i < position.getX() +
     * shipToPlace.getLifePoints(); i++) {
     * cells[i][position.getY()].setShip(shipToPlace);
     * }
     * }
     */

    /**
     * Test if the ship can be placed horizontally and check if a boat was not
     * placed on the cells
     * 
     * @param shipToPlace the ship to add
     * @param position    The position of the cell
     * @throws IllegalStateException if the ship can not be placed on the sea
     */
    private void testIfShipCanBePlacedHorizontally(Ship shipToPlace, Position position) throws IllegalStateException {
        if (position.getX() + shipToPlace.getLifePoints() > width) {
            throw new IllegalStateException("The boat was on the limit of the sea");
        }
        for (int i = position.getY(); i < position.getY() + shipToPlace.getLifePoints(); i++) {
            if (cells[i][position.getX()].hasShip()) {
                throw new IllegalStateException(
                        "Cells at the position " + i + ", " + position.getX() + " was already occuped.");
            }
        }
    }

    // Question 16
    /**
     * add the ship b to this game’s sea. Ship is added horizontally down from
     * position p.
     * The number of cells is determined by the ship life points.
     * 
     * @param shipToPlace the ship to add
     * @param position    the position of the first (top) cell occupied by the ship
     * @throws IllegalStateException if the ship b can not be placed on the sea
     */
    /*
     * public void addShipHorizontally(Ship shipToPlace, Position position) throws
     * IllegalStateException {
     * testIfShipCanBePlacedHorizontally(shipToPlace, position);
     * for (int i = position.getY(); i < position.getY() +
     * shipToPlace.getLifePoints(); i++) {
     * cells[i][position.getX()].setShip(shipToPlace);
     * }
     * }
     */

    /**
     * Try if the ship can be placed
     * 
     * @param shipToPlace the ship to add
     * @param position    the position of the cells
     * @param dx          Vertical position
     * @param dy          Horizontal position
     * @throws IllegalStateException if the ship can not be placed on the sea :
     *                               return exception
     */
    public void testIfShipCanBePlaced(Ship shipToPlace, Position position, int dx, int dy)
            throws IllegalStateException {
        if (position.getX() + (shipToPlace.getLifePoints() - 1) * dx > width ||
                position.getY() + (shipToPlace.getLifePoints() - 1) * dy > length) {
            throw new IllegalStateException("The boat was on the limit of the sea");
        }
        for (int i = 0; i < shipToPlace.getLifePoints(); i++) {
            if (cells[position.getX() + i][position.getY() + i].hasShip()) {
                throw new IllegalStateException("Cells at the position " + (position.getX() + i) + ", "
                        + (position.getY() + i) + " was already occuped.");
            }
        }
    }

    /**
     * Add the ship to the game board at the specified position
     * 
     * @param shipToPlace The ship to add to the board
     * @param position    the position where the ship should be placed
     * @param dx          Vertical position
     * @param dy          Horizontal position
     * @throws IllegalStateException if the ship can not be placed on the sea
     */
    public void addShip(Ship shipToPlace, Position position, int dx, int dy) throws IllegalStateException {
        testIfShipCanBePlaced(shipToPlace, position, dx, dy);

        int x = position.getX();
        int y = position.getY();
        if (dx == 1 && dy == 0) {
            for (int i = 0; i < shipToPlace.getLifePoints(); i++) {
                if (cells[x][y + i].getShip() == null) {
                    cells[x][y + i].setShip(shipToPlace);
                }
            }
        } else if (dx == 0 && dy == 1) {
            for (int i = 0; i < shipToPlace.getLifePoints(); i++) {
                if (cells[x + i][y].getShip() == null) {
                    cells[x + i][y].setShip(shipToPlace);
                }
            }
        } else {
            throw new IllegalStateException("Entrez les bons nombres entre 0 et 1 ou 1 et 0 !");
        }
        Ship.SHIP_LIFES += shipToPlace.getLifePoints();
    }

    /**
     * Add ship in vertically position in the board
     * 
     * @param shipToPlace The ship to add in the board
     * @param position    The position in the board
     * @throws IllegalStateException if the ship can not be placed on the sea
     */
    public void addShipVertically(Ship shipToPlace, Position position) throws IllegalStateException {
        addShip(shipToPlace, position, 0, 1);
    }

    /**
     * Add ship in horizontally position in the board
     * 
     * @param shipToPlace The ship to add in the board
     * @param position    The position in the board
     * @throws IllegalStateException if the ship can not be placed on the sea
     */
    public void addShipHorizontally(Ship shipToPlace, Position position) throws IllegalStateException {
        addShip(shipToPlace, position, 1, 0);
    }
}
