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

    private JButton buttonNewGame = new JButton("New Game");
    private JButton buttonExit = new JButton("Exit");

    private Map map;
    private SettingsWindow settingsWindow;




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
        settingsWindow = new SettingsWindow(this);
        map = new Map(this.settingsWindow);
        add(map);
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

    public JButton getButtonNewGame() {
        return buttonNewGame;
    }

    public void setButtonNewGame(JButton buttonNewGame) {
        this.buttonNewGame = buttonNewGame;
    }

    public JButton getButtonExit() {
        return buttonExit;
    }

    public void setButtonExit(JButton buttonExit) {
        this.buttonExit = buttonExit;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public SettingsWindow getSettingsWindow() {
        return settingsWindow;
    }

    public void setSettingsWindow(SettingsWindow settingsWindow) {
        this.settingsWindow = settingsWindow;
    }

    void startNewGame(boolean mode, int fSzX, int fSzY, int wLength) {
        map.startNewGame(mode, fSzX, fSzY, wLength);
    }

}
