package org.example.task2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;

//Создать окно клиента чата. Окно должно содержать JtextField для ввода логина, пароля, IP-адреса сервера, порта подключения к серверу, область ввода
//        сообщений, JTextArea область просмотра сообщений чата и JButton подключения к серверу и отправки сообщения в чат. Желательно сразу сгруппировать
//        компоненты, относящиеся к серверу сгруппировать на JPanel сверху экрана, а
//        компоненты, относящиеся к отправке сообщения – на JPanel снизу.

public class ChatWindow extends JFrame {
    private final static int WINDOW_WIDTH = 800;
    private final static int WINDOW_HEIGHT = 400;
    private static final int WINDOW_POSX = 600;
    private static final int WINDOW_POSY = 200;
    private final JTextArea jTextAreaMessages;
    private final JScrollPane jScrollPane;
    private final JButton buttonSave;
    private final JButton buttonLoaded;
    private final JPanel panelFullScreen;
    private final JPanel panelTop;
    private final JPanel panelBottom;
    private final JPanel panelBottomFromAreaText;
    private final JPanel panelBottomFromMessage;
    private final JPanel panelAlarmMessage;
    private final JLabel alarmLabel;
    private final JTextField textFieldMessage;
    private final JButton buttonSendMessage;
    private final AuthenticateServer authenticateServer;

    private final File file = new File("history.txt");

    public ChatWindow(AuthenticateServer authenticateServer) throws HeadlessException {
        this.authenticateServer = authenticateServer;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(WINDOW_POSX, WINDOW_POSY, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("ServerChat");
        setResizable(false);
        panelFullScreen = new JPanel(new GridLayout(2, 1));
        panelTop = new JPanel(new GridLayout(1, 1));
        panelBottom = new JPanel(new GridLayout(3, 1));
        panelAlarmMessage = new JPanel(new GridLayout(2, 1));
        panelBottomFromAreaText = new JPanel(new GridLayout(1, 2));
        panelBottomFromMessage = new JPanel(new GridLayout(1, 2));
        jTextAreaMessages = new JTextArea(20,1);
        jScrollPane = new JScrollPane(jTextAreaMessages);

        buttonSave = new JButton("Save");
        buttonLoaded = new JButton("Load");
        textFieldMessage = new JTextField();
        buttonSendMessage = new JButton("Send message");
        add(panelFullScreen);
        panelFullScreen.add(panelTop);
        panelFullScreen.add(panelBottom, BorderLayout.SOUTH);
        panelTop.add(jScrollPane);
        panelBottom.add(panelAlarmMessage);
        panelBottomFromAreaText.add(buttonSave);
        panelBottomFromAreaText.add(buttonLoaded);
        panelBottom.add(panelBottomFromAreaText, BorderLayout.SOUTH);
        panelBottomFromMessage.add(textFieldMessage);
        panelBottomFromMessage.add(buttonSendMessage, BorderLayout.EAST);
        panelBottom.add(panelBottomFromMessage);
        alarmLabel = new JLabel("Alarm");
        panelAlarmMessage.setVisible(false);
        panelAlarmMessage.add(alarmLabel, BorderLayout.WEST);
        loadedHistoryFromFile();
        setVisible(true);
        panelAlarmMessage.setVisible(false);



        buttonSendMessage.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textFieldMessage.getText().isEmpty() || (textFieldMessage.getText().isEmpty())){
                    alarmLabel.setVisible(true);
                    alarmLabel.setText("Status : Message is empty");
                    panelAlarmMessage.setVisible(true);
                } else {
                    jTextAreaMessages.append(authenticateServer.getTextFieldLogin().getText() + " : " + textFieldMessage.getText() + "\n");
                    textFieldMessage.setText("");
                    alarmLabel.setText("Status : Ok");
                }
            }
        });

        textFieldMessage.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (textFieldMessage.getText().isEmpty() || (textFieldMessage.getText().isEmpty())){
                        alarmLabel.setVisible(true);
                        alarmLabel.setText("Status : Message is empty");
                        panelAlarmMessage.setVisible(true);
                    } else {
                        jTextAreaMessages.append(authenticateServer.getTextFieldLogin().getText() + " : " + textFieldMessage.getText() + "\n");
                        textFieldMessage.setText("");
                        if (alarmLabel.getText().equals("Status : Message is empty")){
                            alarmLabel.setText("Status : Ok");
                        } else {
                            alarmLabel.setText("");
                            panelAlarmMessage.setVisible(false);
                        }
                    }
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });


        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (writeToHistory()) {
                    panelAlarmMessage.setVisible(false);
                } else {
                    alarmLabel.setText("ALARM: History not saved");
                    panelAlarmMessage.setVisible(true);
                }
            }
        });

        buttonLoaded.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (loadedHistoryFromFile()) {
                    panelAlarmMessage.setVisible(false);
                } else {
                    alarmLabel.setText("ALARM: History not loaded");
                    panelAlarmMessage.setVisible(true);
                }
            }
        });
    }

    public boolean writeToHistory() {
        try (FileWriter fileWriter = new FileWriter(file, false)) {
            fileWriter.write(jTextAreaMessages.getText());
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean loadedHistoryFromFile() {
        try (FileReader reader = new FileReader(file)) {
            int count;
            StringBuilder stringBuilder = new StringBuilder();
            while ((count = reader.read()) != -1) {
                stringBuilder.append((char) count);
            }
            jTextAreaMessages.setText(stringBuilder.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public JTextArea getjTextAreaMessages() {
        return jTextAreaMessages;
    }

    public JButton getButtonSave() {
        return buttonSave;
    }

    public JButton getButtonLoaded() {
        return buttonLoaded;
    }

    public JPanel getPanelFullScreen() {
        return panelFullScreen;
    }

    public JPanel getPanelTop() {
        return panelTop;
    }

    public JPanel getPanelBottom() {
        return panelBottom;
    }

    public JPanel getPanelBottomFromAreaText() {
        return panelBottomFromAreaText;
    }

    public JPanel getPanelBottomFromMessage() {
        return panelBottomFromMessage;
    }

    public JTextField getTextFieldMessage() {
        return textFieldMessage;
    }

    public JButton getButtonSendMessage() {
        return buttonSendMessage;
    }

    public AuthenticateServer getAuthenticateServer() {
        return authenticateServer;
    }
}
