package de.jannishornfeck.view;

import de.jannishornfeck.Configuration;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class Frame extends JFrame {

    private final InformationPanel informationPanel = new InformationPanel();
    private final Panel panel = new Panel();

    public Frame() {
        setTitle(Configuration.GAME_TITLE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel jPanel = new JPanel();

        jPanel.setLayout(new BorderLayout());
        jPanel.add(informationPanel, BorderLayout.NORTH);
        jPanel.add(panel, BorderLayout.CENTER);

        add(jPanel);
        pack();

        setLocationRelativeTo(null);
        setResizable(false);
    }

    public InformationPanel getInformationPanel() {
        return informationPanel;
    }

    public Panel getPanel() {
        return panel;
    }

}
