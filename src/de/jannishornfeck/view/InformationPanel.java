package de.jannishornfeck.view;

import de.jannishornfeck.Configuration;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class InformationPanel extends JPanel {

    JLabel jLabel = new JLabel(Configuration.HIGH_SCORE_TEXT + 0);

    public InformationPanel() {
        add(jLabel, SwingConstants.CENTER);
    }

    public void setHighScore(int highScore) {
        jLabel.setText(Configuration.HIGH_SCORE_TEXT + highScore);
    }

}
