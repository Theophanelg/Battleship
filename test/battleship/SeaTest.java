package battleship;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

import battleship.util.Position;

public class SeaTest {

    @Test
    public void testAddShip() throws InvalidShipPlacementException {
        Sea sea = new Sea(10, 10);
        Ship ship = new Ship(3);
        assertFalse(sea.getRemainingLifePoints() == ship.getLifePoints());
        sea.addShip(ship, new Position(0, 0));
        assertTrue(sea.getRemainingLifePoints() == ship.getLifePoints());
    }

    @Test
    public void testShootShip() throws InvalidShipPlacementException, InvalidShootException {
        Sea sea = new Sea(10, 10);
        Ship ship = new Ship(2);
        Position p1 = new Position(2, 3);
        sea.addShip(ship, p1);
        sea.Shoot(p1);
        assertTrue(ship.getLifePoints() == 1);
    }

    @Test
    public void testRemainingLifeShip() throws InvalidShipPlacementException {
        Sea sea = new Sea(10, 10);
        Ship ship = new Ship(1);
        Position p1 = new Position(5, 6);
        sea.addShip(ship, p1);
        assertEquals(1, sea.getRemainingLifePoints());
    }

    @Test
    public void testIfShipCanBePlacedVertically() throws InvalidShipPlacementException, IllegalStateException {
        Sea sea = new Sea(10, 10);
        Ship ship = new Ship(2);
        Position position = new Position(2, 2);
        assertDoesNotThrow(() ->
        sea.addShipVertically(ship, position));
    }

    @Test
    public void testIfShipCanBePlacedHorizontally() throws InvalidShipPlacementException,IllegalStateException {
        Sea sea = new Sea(10, 10);
        Ship ship = new Ship(2);
        Position position = new Position(2, 2);
        assertDoesNotThrow(() ->
        sea.addShipHorizontally(ship, position));
    }
}
