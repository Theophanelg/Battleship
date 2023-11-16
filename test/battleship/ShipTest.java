package battleship;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShipTest{
    @Test
    public void shipHasBeenSunk(){
        Ship s1 = new Ship(1);
        s1.beenHitting();
        assertTrue(s1.hasBeenSunk());
    }

    @Test
    public void shipGetLife(){
        int lifePoints = 2;
        Ship s2 = new Ship(lifePoints);
        assertTrue(lifePoints == s2.getLifePoints());
    }

    @Test
    public void shipBeenHitting(){
        int lifePoints = 2;
        Ship s3 = new Ship(lifePoints);
        s3.beenHitting();
        assertTrue(lifePoints - 1 == s3.getLifePoints());
    }
}