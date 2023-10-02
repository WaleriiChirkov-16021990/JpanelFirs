package org.example;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsWindow extends JFrame {

    private static final int WINDOW_WIDTH = 230;
    private static final int WINDOW_HEIGHT = 350;

    JLabel labelMode = new JLabel("Select your game mode");
    JRadioButton radioButtonPCMode = new JRadioButton("for PC mode", true);
    JRadioButton radioButtonHumanMode = new JRadioButton("for human mode");
    JLabel labelFieldSize = new JLabel("Select your size of the Field");
    JSlider sliderSizeGameField = new JSlider(3,10,3);
    JLabel labelWinLength = new JLabel("Select your length of the Win");
    JSlider sliderWinLength = new JSlider(3,10,3);
    ButtonGroup buttonGroup = new ButtonGroup();

    JPanel gridPropertiesGame = new JPanel(new GridLayout(4,1));
    JPanel gridPropertiesSize = new JPanel(new GridLayout(2,1));
    JPanel gridPropertiesMode = new JPanel(new GridLayout(3,1));

    JPanel gridPropertiesWinLength = new JPanel(new GridLayout(2,1));



    JButton startButton = new JButton("Start");

    public SettingsWindow(GameWindow gameWindow) {
        setLocationRelativeTo(gameWindow); //
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Window of the Settings game");

        buttonGroup.add(radioButtonHumanMode);
        buttonGroup.add(radioButtonPCMode);

        gridPropertiesMode.add(labelMode);
        gridPropertiesMode.add(radioButtonHumanMode);
        gridPropertiesMode.add(radioButtonPCMode);

        gridPropertiesSize.add(labelFieldSize);
        gridPropertiesSize.add(sliderSizeGameField);

        gridPropertiesWinLength.add(labelWinLength);
        gridPropertiesWinLength.add(sliderWinLength);

        gridPropertiesGame.add(gridPropertiesMode);
        gridPropertiesGame.add(gridPropertiesSize);
        gridPropertiesGame.add(gridPropertiesWinLength);
        gridPropertiesGame.add(startButton);

        sliderWinLength.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

                labelWinLength.setText(
                        String.format("Select your length of the Win : %d",
                        sliderWinLength.getValue()
                        )
                );
            }
        });

        sliderSizeGameField.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                labelFieldSize.setText(
                        String.format(
                                "Select your size of the Field : %d",
                        sliderSizeGameField.getValue()
                        )
                );
            }
        });


        startButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean valueMode = radioButtonPCMode.isSelected();
                gameWindow.startNewGame(valueMode,sliderSizeGameField.getValue(),sliderSizeGameField.getValue(),sliderWinLength.getValue());
                setVisible(false);
            }
        });

        add(gridPropertiesGame);

    }
}

//    Первое задание – добавить на экран компоновщик-сетку с одним столбцом и добавить над существующей кнопкой следующие компоненты в заданном порядке: JLabel с заголовком «Выберите режим игры», сгруппированные в ButtonGroup
//        переключаемые JRadioButton с указанием режимов «Человек против компьютера» и «Человек против человека», JLabel с заголовком «Выберите размеры
//        поля», JLabel с заголовком «Установленный размер поля:», JSlider со значениями 3..10, JLabel с заголовком «Выберите длину для победы», JLabel с заголовком «Установленная длина:», JSlider со значениями 3..10.