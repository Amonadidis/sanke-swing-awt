package de.jannishornfeck.service;

import de.jannishornfeck.Configuration;
import de.jannishornfeck.model.Apple;

import java.util.Random;

public class AppleService {

    private final Random random = new Random();

    public void randomize(Apple apple) {
        apple.getPosition().setX(random.nextInt(Configuration.BOUNDARY.getX()));
        apple.getPosition().setY(random.nextInt(Configuration.BOUNDARY.getY()));
    }

}
