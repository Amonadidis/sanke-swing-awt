package de.jannishornfeck.model;

import java.util.ArrayList;
import java.util.List;

public class Snake {

    private final DirectionWrapper directionWrapper = new DirectionWrapper(Direction.getRandomStartValue());
    private final List<Position> positions = new ArrayList<>();

    public Direction getDirection() {
        return directionWrapper.getDirection();
    }

    public void setDirection(Direction direction) {
        this.directionWrapper.setDirection(direction);
    }

    public DirectionWrapper getDirectionWrapper() {
        return directionWrapper;
    }

    public List<Position> getPositions() {
        return positions;
    }

}
