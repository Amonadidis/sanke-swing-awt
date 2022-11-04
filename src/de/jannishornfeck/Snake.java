package de.jannishornfeck;

import de.jannishornfeck.controller.Controller;

import javax.swing.SwingUtilities;

public class Snake {

    public static void main(String[] arguments) {
        SwingUtilities.invokeLater(Controller::new);
    }

}
