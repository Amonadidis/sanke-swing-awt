package de.jannishornfeck;

import de.jannishornfeck.model.Position;

import java.awt.Color;

public class Configuration {

    public static final String GAME_TITLE = "Snake";

    public static final String HIGH_SCORE_TEXT = "Erreichte Punkte: ";

    public static final int HEIGHT = 600;
    public static final int WIDTH = 600;
    public static final int SIZE = 30;

    public static final Position BOUNDARY = new Position(WIDTH / SIZE, HEIGHT / SIZE);

    public static final int SNAKE_ARCH_SIZE = 20;

    public static final int SNAKE_BIT_ANGLE_CLOSED = 25;
    public static final int SNAKE_BIT_ANGLE_OPEN = 80;

    public static final int SNAKE_DELAY = 125;

    public static final int SNAKE_LENGTH = 6;

    public static final Color COLOR_APPLE = new Color(0xAADC143C, true);
    public static final Color COLOR_GRID = new Color(0x607080);
    public static final Color COLOR_PANEL = new Color(0x708090);
    public static final Color COLOR_SNAKE_BODY = new Color(0x007070);
    public static final Color COLOR_SNAKE_BIT = new Color(0xAADC143C, true);

}
