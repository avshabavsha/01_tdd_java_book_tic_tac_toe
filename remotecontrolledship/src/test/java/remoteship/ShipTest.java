package remoteship;

import org.junit.Assert;
import org.junit.Test;
import remoteship.utils.Direction;
import remoteship.utils.Location;
import remoteship.utils.Point;
import remoteship.utils.Ship;

/**
 * Created by avshaloms on 14/02/2018.
 */
public class ShipTest {

    @Test
    public void whenInstantiatedThenLocationIsSet() {
        Location location = new Location(
                new Point(21, 13),
                Direction.NORTH);

        Ship ship = new Ship(location);
        Assert.assertEquals(location, ship.getLocation());
    }
}
