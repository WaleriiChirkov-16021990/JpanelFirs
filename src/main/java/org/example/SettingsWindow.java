package org.example;

import javax.swing.*;

public class SettingsWindow extends JFrame {

    private static final int WINDOW_WIDTH = 230;
    private static final int WINDOW_HEIGHT = 350;

    JButton startButton = new JButton("Start");

    public SettingsWindow(GameWindow gameWindow) {
        setLocationRelativeTo(gameWindow);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        add(startButton);
    }
}
