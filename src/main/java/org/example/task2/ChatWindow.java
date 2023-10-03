package org.example.task2;

import javax.swing.*;
import java.awt.*;

//Создать окно клиента чата. Окно должно содержать JtextField для ввода логина, пароля, IP-адреса сервера, порта подключения к серверу, область ввода
//        сообщений, JTextArea область просмотра сообщений чата и JButton подключения к серверу и отправки сообщения в чат. Желательно сразу сгруппировать
//        компоненты, относящиеся к серверу сгруппировать на JPanel сверху экрана, а
//        компоненты, относящиеся к отправке сообщения – на JPanel снизу.

public class ChatWindow extends JFrame {
    private final static int WINDOW_WIDTH = 600;
    private final static int WINDOW_HEIGHT = 800;
    private static final int WINDOW_POSX = 600;
    private static final int WINDOW_POSY = 700;
//    private final JTextArea jTextAreaMessage;
//    private final JButton button;
//    private final JPanel panelFullScreen;
//    private final JPanel panelTop;
//    private final JPanel panelBottom;
//    private final JTextField textFieldMessage;
//    private final JButton buttonSendMessage;
    public ChatWindow() throws HeadlessException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX,WINDOW_POSY);
        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);

        setTitle("ServerChat");
        setResizable(false);
    }
}
