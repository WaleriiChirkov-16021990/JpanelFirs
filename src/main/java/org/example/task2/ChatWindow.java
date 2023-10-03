package org.example.task2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private final AuthenticateServer authenticateServer;
    public ChatWindow(AuthenticateServer authenticateServer) throws HeadlessException {
        this.authenticateServer = authenticateServer;
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


        buttonSendMessage.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextAreaMessages.append(authenticateServer.getTextFieldLogin().getText() + " : " + textFieldMessage.getText() + "\n");
                textFieldMessage.setText("");
            }
        });

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
