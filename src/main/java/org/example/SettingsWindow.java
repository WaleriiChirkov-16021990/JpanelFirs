package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsWindow extends JFrame {

    private static final int WINDOW_WIDTH = 230;
    private static final int WINDOW_HEIGHT = 350;

    JButton startButton = new JButton("Start");

    public SettingsWindow(GameWindow gameWindow) {
        setLocationRelativeTo(gameWindow); //
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        startButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                gameWindow.startNewGame(0,3,3,3);
                setVisible(false);
            }
        });

        add(startButton);
    }
}

//    Первое задание – добавить на экран компоновщик-сетку с одним столбцом и добавить над существующей кнопкой следующие компоненты в заданном порядке: JLabel с заголовком «Выберите режим игры», сгруппированные в ButtonGroup
//        переключаемые JRadioButton с указанием режимов «Человек против компьютера» и «Человек против человека», JLabel с заголовком «Выберите размеры
//        поля», JLabel с заголовком «Установленный размер поля:», JSlider со значениями 3..10, JLabel с заголовком «Выберите длину для победы», JLabel с заголовком «Установленная длина:», JSlider со значениями 3..10.