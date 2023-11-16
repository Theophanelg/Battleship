package battleship;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class CellTest {
    @Test
    public void testToCharacterEmpty() {
        Cell cell = new Cell();
        assertEquals(cell.toCharacter(true), '~');
    }

    @Test
    public void testToCharacterDefenderCellWithBoatNotTouched() {
        Ship ship = new Ship(3);
        Cell cell = new Cell();
        cell.setShip(ship);
        assertEquals('B', cell.toCharacter(true) );
    }

    @Test
    public void testToCharacterDefenderCellWithBoatTouched() {
        Ship ship = new Ship(2);
        Cell cell = new Cell();
        cell.setShip(ship);
        assertEquals('B', cell.toCharacter(true));
    }

    @Test
    public void testToCharacterAttackerEmptyCell() {
        Cell cell = new Cell();
        assertEquals('.', cell.toCharacter(false));
    }

    @Test
    public void testToCharacterAttackerCellWithBoatTouched() {
        Cell cell = new Cell();
        Ship ship = new Ship(3);
        cell.setShip(ship);
        cell.shot();
        ship.beenHitting();
        assertEquals(cell.toCharacter(false), '*');
    }

    @Test
    public void testToCharacterAttackerCellWithBoatNotTouched() {
        Ship ship = new Ship(2);
        Cell cell = new Cell();
        cell.setShip(ship);
        assertEquals(cell.toCharacter(false), '.');
    }

    @Test
    public void testToCharacterAttackerEmptyCellAfterShot() {
        Cell cell = new Cell();
        cell.shot();
        assertEquals(cell.toCharacter(false), '~');
    }

    @Test
    public void testToCharacterForAttackerUnknownCell() {
        Cell cell = new Cell();
        assertEquals(cell.toCharacter(false), '.');
    }

}