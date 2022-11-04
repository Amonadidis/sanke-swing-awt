package de.jannishornfeck.service;

import de.jannishornfeck.Configuration;
import de.jannishornfeck.model.Direction;
import de.jannishornfeck.model.Position;
import de.jannishornfeck.model.Snake;

import java.util.List;

public class SnakeService {

    public void change(Snake snake, Direction direction) {
        if (!snake.getDirection().isOpposite(direction)) {
            snake.setDirection(direction);
        }
    }

    public int count(Snake snake) {
        return snake.getPositions().size() - Configuration.SNAKE_LENGTH;
    }

    public void grow(Snake snake) {
        List<Position> snakePositions = snake.getPositions();
        Position snakeTailPosition = snakePositions.get(snakePositions.size() - 1);

        snakePositions.add(new Position(snakeTailPosition));
    }

    public void initialize(Snake snake) {
        snake.getPositions().clear();

        for (int i = 0; i < Configuration.SNAKE_LENGTH; i++) {
            snake.getPositions().add(i, new Position());
        }

        snake.setDirection(Direction.getRandomStartValue());
    }

    public void move(Snake snake) {
        for (int i = snake.getPositions().size() - 1; i > 0; i--) {
            Position oldPosition = snake.getPositions().get(i);
            Position newPosition = snake.getPositions().get(i - 1);

            oldPosition.setX(newPosition.getX());
            oldPosition.setY(newPosition.getY());
        }

        Position headPosition = snake.getPositions().get(0);

        switch (snake.getDirection()) {
            case LEFT -> headPosition.setX(headPosition.getX() - 1);
            case RIGHT -> headPosition.setX(headPosition.getX() + 1);
            case UP -> headPosition.setY(headPosition.getY() - 1);
            case DOWN -> headPosition.setY(headPosition.getY() + 1);
            default -> throw new IllegalStateException("Unexpected value: " + snake.getDirection());
        }
    }

}
