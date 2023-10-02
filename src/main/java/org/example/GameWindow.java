package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {
    private static final int WINDOW_WIDTH = 555;
    private static final int WINDOW_HEIGHT = 555;
    private static final int WINDOW_POSX = 800;
    private static final int WINDOW_POSY = 300;

    JButton buttonNewGame = new JButton("New Game");
    JButton buttonExit = new JButton("Exit");

    Map map;
    SettingsWindow settingsWindow;




    public GameWindow() throws HeadlessException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX,WINDOW_POSY);
        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);

        setTitle("TicTacToe");
        setResizable(false);
        JPanel panelGridSoutch = new JPanel(new GridLayout(1,2));
        panelGridSoutch.add(buttonNewGame);
        panelGridSoutch.add(buttonExit);
        add(panelGridSoutch, BorderLayout.SOUTH);
        map = new Map();
        add(map);
        settingsWindow = new SettingsWindow(this);
        setVisible(true);
//        settingsWindow.setVisible(true);
        buttonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        buttonNewGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingsWindow.setVisible(true);
            }
        });

    }

    void startNewGame(boolean mode, int fSzX, int fSzY, int wLength) {
        map.startNewGame(mode, fSzX, fSzY, wLength);
    }

}
