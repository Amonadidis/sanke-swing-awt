package de.jannishornfeck.view;

import de.jannishornfeck.Configuration;
import de.jannishornfeck.model.DirectionWrapper;
import de.jannishornfeck.model.Position;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.List;

public class Panel extends JPanel {

    private Position applePosition;
    private DirectionWrapper snakeDirectionWrapper;
    private List<Position> snakePositions;

    private boolean isSnakeBitOpen = true;

    public Panel() {
        setPreferredSize(new Dimension(Configuration.WIDTH, Configuration.HEIGHT));
        setBackground(Configuration.COLOR_PANEL);
        setFocusable(true);
    }

    public void setApplePosition(Position applePosition) {
        this.applePosition = applePosition;
    }

    public void setSnakeDirectionWrapper(DirectionWrapper snakeDirectionWrapper) {
        this.snakeDirectionWrapper = snakeDirectionWrapper;
    }

    public void setSnakePositions(List<Position> snakePositions) {
        this.snakePositions = snakePositions;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        paintGrid(graphics);
        paintApple(graphics);
        paintSnake(graphics);
    }

    private void paintApple(Graphics graphics) {
        graphics.setColor(Configuration.COLOR_APPLE);
        graphics.fillOval(
                applePosition.getX() * Configuration.SIZE + 5,
                applePosition.getY() * Configuration.SIZE + 5,
                Configuration.SIZE - 10,
                Configuration.SIZE - 10
        );
    }

    private void paintGrid(Graphics graphics) {
        graphics.setColor(Configuration.COLOR_GRID);

        for (int i = 0; i < Configuration.WIDTH / Configuration.SIZE; i++) {
            graphics.drawLine(
                    i * Configuration.SIZE,
                    0,
                    i * Configuration.SIZE,
                    Configuration.HEIGHT
            );
            graphics.drawLine(
                    0,
                    i * Configuration.SIZE,
                    Configuration.WIDTH,
                    i * Configuration.SIZE);
        }
    }

    private void paintSnake(Graphics graphics) {
        for (Position position : snakePositions) {
            Position snakeHeadPosition = snakePositions.get(0);

            if (position == snakeHeadPosition) {
                graphics.setColor(Configuration.COLOR_SNAKE_BODY);
                graphics.fillRoundRect(
                        position.getX() * Configuration.SIZE,
                        position.getY() * Configuration.SIZE,
                        Configuration.SIZE,
                        Configuration.SIZE,
                        Configuration.SNAKE_ARCH_SIZE,
                        Configuration.SNAKE_ARCH_SIZE
                );

                int archAngle = isSnakeBitOpen ? Configuration.SNAKE_BIT_ANGLE_OPEN : Configuration.SNAKE_BIT_ANGLE_CLOSED;
                int startAngle = (360 - archAngle) / 2;

                switch (snakeDirectionWrapper.getDirection()) {
                    case LEFT -> startAngle += 0;
                    case DOWN -> startAngle += 90;
                    case RIGHT -> startAngle += 180;
                    case UP -> startAngle += 270;
                    default -> throw new IllegalStateException("Unexpected value: " + snakeDirectionWrapper.getDirection());
                }

                        graphics.setColor(Configuration.COLOR_SNAKE_BIT);
                graphics.fillArc(
                        position.getX() * Configuration.SIZE,
                        position.getY() * Configuration.SIZE,
                        Configuration.SIZE,
                        Configuration.SIZE,
                        startAngle,
                        archAngle
                );

                isSnakeBitOpen = !isSnakeBitOpen;

                continue;
            }

            graphics.setColor(Configuration.COLOR_SNAKE_BODY);
            graphics.fillRoundRect(
                    position.getX() * Configuration.SIZE,
                    position.getY() * Configuration.SIZE,
                    Configuration.SIZE,
                    Configuration.SIZE,
                    Configuration.SNAKE_ARCH_SIZE,
                    Configuration.SNAKE_ARCH_SIZE
            );
        }
    }

}
