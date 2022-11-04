package de.jannishornfeck.service;

import de.jannishornfeck.model.Apple;
import de.jannishornfeck.model.Position;
import de.jannishornfeck.model.Snake;

import java.util.List;

public class CollisionService {

    public boolean checkCollisionSnakeWithApple(Snake snake, Apple apple) {
        Position snakeHeadPosition = snake.getPositions().get(0);

        return apple.getPosition().equals(snakeHeadPosition);
    }

    public boolean checkCollisionSnakeWithBoundary(Snake snake, Position boundary) {
        Position snakeHeadPosition = snake.getPositions().get(0);

        return boundary.getX() == snakeHeadPosition.getX()
                || 0 > snakeHeadPosition.getX()
                || boundary.getY() == snakeHeadPosition.getY()
                || 0 > snakeHeadPosition.getY();
    }

    public boolean checkCollisionSnakeWithItself(Snake snake) {
        List<Position> snakePositions = snake.getPositions();
        Position snakeHeadPosition = snakePositions.get(0);

        return snakePositions.stream().skip(1).anyMatch(position -> position.equals(snakeHeadPosition));
    }

}
