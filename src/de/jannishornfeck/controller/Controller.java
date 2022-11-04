package de.jannishornfeck.controller;

import de.jannishornfeck.Configuration;
import de.jannishornfeck.model.Apple;
import de.jannishornfeck.model.Direction;
import de.jannishornfeck.model.Snake;
import de.jannishornfeck.service.AppleService;
import de.jannishornfeck.service.CollisionService;
import de.jannishornfeck.service.SnakeService;
import de.jannishornfeck.view.Frame;
import de.jannishornfeck.view.InformationPanel;
import de.jannishornfeck.view.Panel;

import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controller {

    private final Apple apple = new Apple();
    private final Snake snake = new Snake();

    private final AppleService appleService = new AppleService();
    private final CollisionService collisionService = new CollisionService();
    private final SnakeService snakeService = new SnakeService();

    private final Timer timer;

    private final Frame frame = new Frame();
    private final InformationPanel informationPanel = frame.getInformationPanel();
    private final Panel panel = frame.getPanel();

    private boolean isNewGame = true;

    public Controller() {
        panel.setApplePosition(apple.getPosition());
        panel.setSnakeDirectionWrapper(snake.getDirectionWrapper());
        panel.setSnakePositions(snake.getPositions());

        panel.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent keyEvent) {
                switch (keyEvent.getKeyCode()) {
                    case KeyEvent.VK_LEFT, KeyEvent.VK_KP_LEFT, KeyEvent.VK_A -> snakeService.change(snake, Direction.LEFT);
                    case KeyEvent.VK_RIGHT, KeyEvent.VK_KP_RIGHT, KeyEvent.VK_D -> snakeService.change(snake, Direction.RIGHT);
                    case KeyEvent.VK_UP, KeyEvent.VK_KP_UP, KeyEvent.VK_W -> snakeService.change(snake, Direction.UP);
                    case KeyEvent.VK_DOWN, KeyEvent.VK_KP_DOWN, KeyEvent.VK_S -> snakeService.change(snake, Direction.DOWN);
                }
            }

        });

        timer = new Timer(Configuration.SNAKE_DELAY, actionEvent -> executeGame());

        timer.start();

        frame.setVisible(true);
    }

    public void executeGame() {
        if (isNewGame) {
            isNewGame = false;

            snakeService.initialize(snake);
            appleService.randomize(apple);

            informationPanel.setHighScore(0);
        }

        snakeService.move(snake);

        boolean collidedSnakeWithApple = collisionService.checkCollisionSnakeWithApple(snake, apple);

        if (collidedSnakeWithApple) {
            snakeService.grow(snake);
            appleService.randomize(apple);

            informationPanel.setHighScore(snakeService.count(snake));
        }

        boolean collidedSnakeWithBoundary = collisionService.checkCollisionSnakeWithBoundary(snake, Configuration.BOUNDARY);
        boolean collidedSnakeWithItself = collisionService.checkCollisionSnakeWithItself(snake);

        if (collidedSnakeWithBoundary || collidedSnakeWithItself) {
            timer.stop();

            int option = JOptionPane.showConfirmDialog(
                    frame,
                    "Wollen Sie ein neues Spiel starten?",
                    "Spiel verloren",
                    JOptionPane.YES_NO_OPTION
            );

            switch (option) {
                case JOptionPane.YES_OPTION -> {
                    isNewGame = true;

                    timer.restart();
                }
                case JOptionPane.NO_OPTION -> System.exit(0);
                default -> throw new IllegalStateException("Unexpected value: " + option);
            }

            return;
        }

        panel.repaint();
    }

}
