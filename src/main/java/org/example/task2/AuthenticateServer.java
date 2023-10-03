package org.example.task2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AuthenticateServer extends JFrame {

    private final static int WINDOW_WIDTH = 330;
    private final static int WINDOW_HEIGHT = 190;
    private static final int WINDOW_POSX = -1660;
    private static final int WINDOW_POSY = -1200;
    private final JButton okButton;
    private final JButton exitButton;
    private final JPanel panelSouthButtonGroup;
    private final JPanel panelTopAuthenticated;

    private final JTextField textFieldLogin;
    private final JPasswordField passwordField;
    private final JTextField textFieldIPAddress;
    private final JTextField textFieldPort;
    private final JLabel labelInfo;
    private boolean isAuthenticated = false;
    private final ChatWindow chatWindow;

    public AuthenticateServer() throws HeadlessException {
        setBounds(WINDOW_POSX, WINDOW_POSY, WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Authenticate");
        setResizable(false);
        panelSouthButtonGroup = new JPanel(new GridLayout(1,2));
        okButton = new JButton("OK");
        exitButton = new JButton("Exit");
        panelSouthButtonGroup.add(okButton);
        panelSouthButtonGroup.add(exitButton);
        add(panelSouthButtonGroup,BorderLayout.SOUTH);
        chatWindow = new ChatWindow();

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


        setVisible(false);

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                     labelInfo.setText("Authentication successful");
                     isAuthenticated = true;
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelInfo.setText("Bye bye");
                setVisible(false);
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

    public boolean isAuthenticated() {
        return isAuthenticated;
    }

    public JTextField getTextFieldIPAddress() {
        return textFieldIPAddress;
    }

    public JTextField getTextFieldPort() {
        return textFieldPort;
    }
}
