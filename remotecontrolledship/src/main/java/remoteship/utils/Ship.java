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
