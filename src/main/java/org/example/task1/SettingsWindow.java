package org.example.task1;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsWindow extends JFrame {

    private static final int WINDOW_WIDTH = 230;
    private static final int WINDOW_HEIGHT = 350;

    private JLabel labelMode = new JLabel("Select your game mode");
    private JRadioButton radioButtonPCMode = new JRadioButton("for PC mode", true);
    private JRadioButton radioButtonHumanMode = new JRadioButton("for human mode");
    private JLabel labelFieldSize = new JLabel("Select your size of the Field");
    private JSlider sliderSizeGameField = new JSlider(3,10,3);
    private JLabel labelWinLength = new JLabel("Select your length of the Win");
    private JSlider sliderWinLength = new JSlider(3,10,3);
    private ButtonGroup buttonGroup = new ButtonGroup();

    private JPanel gridPropertiesGame = new JPanel(new GridLayout(4,1));
    private JPanel gridPropertiesSize = new JPanel(new GridLayout(2,1));
    private JPanel gridPropertiesMode = new JPanel(new GridLayout(3,1));

    private JPanel gridPropertiesWinLength = new JPanel(new GridLayout(2,1));

    private int FIELD_SIZE = 3;

    public int getFIELD_SIZE() {
        return FIELD_SIZE;
    }

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
                FIELD_SIZE = sliderSizeGameField.getValue();
                gameWindow.startNewGame(valueMode,sliderSizeGameField.getValue(),sliderSizeGameField.getValue(),sliderWinLength.getValue());
                setVisible(false);
            }
        });

        add(gridPropertiesGame);

    }

    public JLabel getLabelMode() {
        return labelMode;
    }

    public void setLabelMode(JLabel labelMode) {
        this.labelMode = labelMode;
    }

    public JRadioButton getRadioButtonPCMode() {
        return radioButtonPCMode;
    }

    public void setRadioButtonPCMode(JRadioButton radioButtonPCMode) {
        this.radioButtonPCMode = radioButtonPCMode;
    }

    public JRadioButton getRadioButtonHumanMode() {
        return radioButtonHumanMode;
    }

    public void setRadioButtonHumanMode(JRadioButton radioButtonHumanMode) {
        this.radioButtonHumanMode = radioButtonHumanMode;
    }

    public JLabel getLabelFieldSize() {
        return labelFieldSize;
    }

    public void setLabelFieldSize(JLabel labelFieldSize) {
        this.labelFieldSize = labelFieldSize;
    }

    public JSlider getSliderSizeGameField() {
        return sliderSizeGameField;
    }

    public void setSliderSizeGameField(JSlider sliderSizeGameField) {
        this.sliderSizeGameField = sliderSizeGameField;
    }

    public JLabel getLabelWinLength() {
        return labelWinLength;
    }

    public void setLabelWinLength(JLabel labelWinLength) {
        this.labelWinLength = labelWinLength;
    }

    public JSlider getSliderWinLength() {
        return sliderWinLength;
    }

    public void setSliderWinLength(JSlider sliderWinLength) {
        this.sliderWinLength = sliderWinLength;
    }

    public ButtonGroup getButtonGroup() {
        return buttonGroup;
    }

    public void setButtonGroup(ButtonGroup buttonGroup) {
        this.buttonGroup = buttonGroup;
    }

    public JPanel getGridPropertiesGame() {
        return gridPropertiesGame;
    }

    public void setGridPropertiesGame(JPanel gridPropertiesGame) {
        this.gridPropertiesGame = gridPropertiesGame;
    }

    public JPanel getGridPropertiesSize() {
        return gridPropertiesSize;
    }

    public void setGridPropertiesSize(JPanel gridPropertiesSize) {
        this.gridPropertiesSize = gridPropertiesSize;
    }

    public JPanel getGridPropertiesMode() {
        return gridPropertiesMode;
    }

    public void setGridPropertiesMode(JPanel gridPropertiesMode) {
        this.gridPropertiesMode = gridPropertiesMode;
    }

    public JPanel getGridPropertiesWinLength() {
        return gridPropertiesWinLength;
    }

    public void setGridPropertiesWinLength(JPanel gridPropertiesWinLength) {
        this.gridPropertiesWinLength = gridPropertiesWinLength;
    }

    public JButton getStartButton() {
        return startButton;
    }

    public void setStartButton(JButton startButton) {
        this.startButton = startButton;
    }

}

//    Первое задание – добавить на экран компоновщик-сетку с одним столбцом и добавить над существующей кнопкой следующие компоненты в заданном порядке: JLabel с заголовком «Выберите режим игры», сгруппированные в ButtonGroup
//        переключаемые JRadioButton с указанием режимов «Человек против компьютера» и «Человек против человека», JLabel с заголовком «Выберите размеры
//        поля», JLabel с заголовком «Установленный размер поля:», JSlider со значениями 3..10, JLabel с заголовком «Выберите длину для победы», JLabel с заголовком «Установленная длина:», JSlider со значениями 3..10.

