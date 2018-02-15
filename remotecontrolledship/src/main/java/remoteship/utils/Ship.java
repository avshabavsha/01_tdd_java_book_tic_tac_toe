package remoteship.utils;

import lombok.Getter;

@Getter
public class Ship {
    private final Location location;
    private Planet planet;

    public Ship(Location location, Planet planet) {
        this.location = location;
        this.planet = planet;
    }

    public void moveForward() {
        location.forward(planet.getMax());
    }

    public void moveBackward() {
        location.backward(planet.getMax());
    }

    public void turnLeft() {
        location.turnLeft();
    }

    public void turnRight() {
        location.turnRight();
    }

    public void receiveCommands(String commands) {
        for (char command : commands.toCharArray()) {
            switch (command) {
                case 'f':
                    moveForward();
                    break;
                case 'b':
                    moveBackward();
                    break;
                case 'l':
                    turnLeft();
                    break;
                case 'r':
                    turnRight();
                    break;
            }
        }
    }
}
