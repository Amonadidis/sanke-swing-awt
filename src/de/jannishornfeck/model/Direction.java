package de.jannishornfeck.model;

import java.util.Random;

public enum Direction {

    LEFT,
    RIGHT,
    UP,
    DOWN;

    private Direction opposite;

    static {
        LEFT.opposite = RIGHT;
        RIGHT.opposite = LEFT;
        UP.opposite = DOWN;
        DOWN.opposite = UP;
    }

    public static Direction getRandomStartValue() {
        Direction[] startDirections = {RIGHT, DOWN};

        return startDirections[new Random().nextInt(startDirections.length)];
    }

    public boolean isOpposite(Direction direction) {
        return this.equals(direction.opposite);
    }

}
