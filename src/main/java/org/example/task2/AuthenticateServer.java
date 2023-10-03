package org.example.task2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;

public class AuthenticateServer extends JFrame {

    private static int WINDOW_WIDTH = 330;
    private static int WINDOW_HEIGHT = 190;
    private static int WINDOW_POSX = 660;
    private static int WINDOW_POSY = 200;
    private final JButton okButton;
    private final JButton exitButton;
    private final JPanel panelSouthButtonGroup;
    private final JPanel panelTopAuthenticated;

    private final JTextField textFieldLogin;
    private final JPasswordField passwordField;
    private final JTextField textFieldIPAddress;
    private final JTextField textFieldPort;
    private final JLabel labelInfo;
    private static boolean isAuthenticated = false;
//    private final ChatWindow chatWindow;

    public AuthenticateServer() throws HeadlessException {
        setBounds(WINDOW_POSX, WINDOW_POSY, WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Authenticate");
        setResizable(false);
        panelSouthButtonGroup = new JPanel(new GridLayout(1,2));
        okButton = new JButton("OK");
        exitButton = new JButton("Exit");
        panelSouthButtonGroup.add(okButton);
        panelSouthButtonGroup.add(exitButton);
        add(panelSouthButtonGroup,BorderLayout.SOUTH);
//        chatWindow = new ChatWindow();

        panelTopAuthenticated = new JPanel(new GridLayout(5,1));
        add(panelTopAuthenticated,BorderLayout.NORTH);
        textFieldLogin = new JTextField("Enter your Login");
        passwordField = new JPasswordField("Enter Password");
        textFieldIPAddress = new JTextField("Enter IP Address");
        textFieldPort = new JTextField("Enter Port");
        labelInfo = new JLabel();
        labelInfo.setText("For Authentication entered with login and password");
        panelTopAuthenticated.add(textFieldLogin);
        panelTopAuthenticated.add(passwordField);
        panelTopAuthenticated.add(textFieldIPAddress);
        panelTopAuthenticated.add(textFieldPort);
        panelTopAuthenticated.add(labelInfo);


        setVisible(true);

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                     labelInfo.setText("Authentication successful");
                     isAuthenticated = true;
                     setVisible(false);
                     new ChatWindow();
            }
        });


        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelInfo.setText("Bye bye");
                setVisible(false);
                new Program();
            }
        });
    }

    public JButton getOkButton() {
        return okButton;
    }

    public JButton getExitButton() {
        return exitButton;
    }

    public JPanel getPanelSouthButtonGroup() {
        return panelSouthButtonGroup;
    }

    public JPanel getPanelTopAuthenticated() {
        return panelTopAuthenticated;
    }

    public JTextField getTextFieldLogin() {
        return textFieldLogin;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public JLabel getLabelInfo() {
        return labelInfo;
    }

    public static boolean isAuthenticated() {
        return isAuthenticated;
    }

    public JTextField getTextFieldIPAddress() {
        return textFieldIPAddress;
    }

    public JTextField getTextFieldPort() {
        return textFieldPort;
    }

    public static int getWindowWidth() {
        return WINDOW_WIDTH;
    }

    public static int getWindowHeight() {
        return WINDOW_HEIGHT;
    }

    public static int getWindowPosx() {
        return WINDOW_POSX;
    }

    public static int getWindowPosy() {
        return WINDOW_POSY;
    }

    public static boolean isIsAuthenticated() {
        return isAuthenticated;
    }
//
//    public ChatWindow getChatWindow() {
//        return chatWindow;
//    }
}
