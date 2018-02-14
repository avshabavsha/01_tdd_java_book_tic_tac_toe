package remoteship;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import remoteship.utils.Direction;
import remoteship.utils.Location;
import remoteship.utils.Point;
import remoteship.utils.Ship;

/**
 * Created by avshaloms on 14/02/2018.
 */
public class ShipTest {
    private Location location;
    private Ship ship;

    @Before
    public void setup(){
        location = new Location(
                new Point(21, 13),
                Direction.NORTH);

        ship = new Ship(location);
    }

    @Test
    public void whenInstantiatedThenLocationIsSet() {
        Assert.assertEquals(location, ship.getLocation());
    }

    @Test
    public void whenMoveForwardThenForward() {
        Location expected = location.copy();
        expected.forward();
        ship.moveForward();
        Assert.assertEquals(expected, ship.getLocation());
    }

    @Test
    public void whenMoveBackwardThenBackward() {
        Location expected = location.copy();
        expected.backward();
        ship.moveBackward();
        Assert.assertEquals(expected, ship.getLocation());
    }

}
