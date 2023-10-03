package org.example.task2;

import javax.swing.*;
import java.awt.*;

//Создать окно клиента чата. Окно должно содержать JtextField для ввода логина, пароля, IP-адреса сервера, порта подключения к серверу, область ввода
//        сообщений, JTextArea область просмотра сообщений чата и JButton подключения к серверу и отправки сообщения в чат. Желательно сразу сгруппировать
//        компоненты, относящиеся к серверу сгруппировать на JPanel сверху экрана, а
//        компоненты, относящиеся к отправке сообщения – на JPanel снизу.

public class ChatWindow extends JFrame {
    private final static int WINDOW_WIDTH = 600;
    private final static int WINDOW_HEIGHT = 300;
    private static final int WINDOW_POSX = 600;
    private static final int WINDOW_POSY = 200;
    private final JTextArea jTextAreaMessages;
    private final JButton buttonSave;
    private final JButton buttonLoaded;
    private final JPanel panelFullScreen;
    private final JPanel panelTop;
    private final JPanel panelBottom;
    private final JPanel panelBottomFromAreaText;
    private final JPanel panelBottomFromMessage;

    private final JTextField textFieldMessage;
    private final JButton buttonSendMessage;
    public ChatWindow() throws HeadlessException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(WINDOW_POSX,WINDOW_POSY,WINDOW_WIDTH,WINDOW_HEIGHT);
        setTitle("ServerChat");
        setResizable(false);
        panelFullScreen = new JPanel(new GridLayout(2,1));
        panelTop = new JPanel(new GridLayout(1,1));
        panelBottom = new JPanel(new GridLayout(2,1));
        panelBottomFromAreaText = new JPanel(new GridLayout(1,2));
        panelBottomFromMessage = new JPanel(new GridLayout(1,2));
        jTextAreaMessages = new JTextArea();
        buttonSave = new JButton("Save");
        buttonLoaded = new JButton("Load");
        textFieldMessage = new JTextField();
        buttonSendMessage = new JButton("Send message");
        add(panelFullScreen);
        panelFullScreen.add(panelTop);
        panelFullScreen.add(panelTop);
        panelFullScreen.add(panelBottom,BorderLayout.SOUTH);
        panelTop.add(jTextAreaMessages);
        panelBottomFromAreaText.add(buttonSave);
        panelBottomFromAreaText.add(buttonLoaded);
        panelBottom.add(panelBottomFromAreaText, BorderLayout.SOUTH);
        panelBottomFromMessage.add(textFieldMessage);
        panelBottomFromMessage.add(buttonSendMessage, BorderLayout.EAST);
        panelBottom.add(panelBottomFromMessage);

        setVisible(true);


    }
}
