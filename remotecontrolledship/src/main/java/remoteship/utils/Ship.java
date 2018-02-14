package remoteship.utils;
import lombok.Getter;

@Getter
public class Ship {

    private final Location location;

    public Ship(Location location) {

        this.location = location;
    }

    public void moveForward() {
        location.forward();
    }

    public void moveBackward() {
        location.backward();
    }
}
