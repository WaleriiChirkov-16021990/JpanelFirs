package org.example.task2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Program extends JFrame {

    private final static int WINDOW_WIDTH = 600;
    private final static int WINDOW_HEIGHT = 300;
    private static final int WINDOW_POSX = 600;
    private static final int WINDOW_POSY = 200;
    private final JPanel panelAuthenticator;
    private final JPanel panelAuthenticatedUser;
    private final JPanel panelAuthenticatedButton;
    private final JButton authenticatedButton;
    private Component[] componentsData;
    private Component[] componentsButtonAuth;
//    private final JButton authenticatedButton;

//    public AuthenticateServer getAuthenticateServer() {
//        return authenticateServer;
//    }

//    private final AuthenticateServer authenticateServer;

    public Program() throws HeadlessException {
//        authenticateServer = new AuthenticateServer();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX,WINDOW_POSY);
        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        panelAuthenticator = new JPanel(new GridLayout(1,1));
        panelAuthenticatedButton = new JPanel(new GridLayout(1,1));
        panelAuthenticatedUser = new JPanel(new GridLayout(2,1));
        authenticatedButton = new JButton("Authenticate");
        panelAuthenticator.add(authenticatedButton, BorderLayout.NORTH);
        add(panelAuthenticator,BorderLayout.NORTH);

//        add(panelAuthenticatedUser,BorderLayout.CENTER);
//        panelAuthenticatedUser.add(authenticateServer.getPanelTopAuthenticated(), BorderLayout.NORTH);
//        componentsData = panelAuthenticatedUser.getComponents();
//        panelAuthenticatedUser.setVisible(false);
//
//        add(panelAuthenticatedButton,BorderLayout.SOUTH);
//        panelAuthenticatedButton.add(authenticateServer.getPanelSouthButtonGroup(), BorderLayout.SOUTH);
//        componentsButtonAuth = panelAuthenticatedButton.getComponents();
//        panelAuthenticatedButton.setVisible(false);


        setVisible(true);

        authenticatedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                panelAuthenticator.setVisible(false);
//                panelAuthenticatedButton.setVisible(true);
//                panelAuthenticatedUser.setVisible(true);
                setVisible(false);
                new AuthenticateServer();

            }
        }
        );




//        List<Component> list =  Arrays.stream(componentsButtonAuth).filter(component -> component instanceof JButton && component.getName().equals("OK")).toList();

//        list.forEach(component -> {
//            ((JButton)component).addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    panelAuthenticator.setVisible(true);
//                    panelAuthenticatedButton.setVisible(false);
//                    panelAuthenticatedUser.setVisible(false);
//                }
//            });
//        });


    }
}



//            @Override
//            public void actionPerformed(ActionEvent e) {
//                panelAuthenticatedUser.setVisible(false);
//                panelAuthenticatedButton.setVisible(false);
//            }
//        });
//    public JPanel getPanelAuthenticator() {
//        return panelAuthenticator;
//    }
//}
