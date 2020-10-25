package com.gui;

import javax.swing.*;
import java.awt.*;
import java.util.function.ToDoubleBiFunction;

public class SignInMenu extends JPanel {

    RootPanel rootPanel;

    public SignInMenu(RootPanel gameFrame) {
        this.rootPanel = gameFrame;

        setBackground(Color.BLACK);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();


        gbc.insets = new Insets(5, 5, 5, 5);
        JLabel loginLabel = new JLabel("Login:");
        loginLabel.setFont(new Font("Chiller", Font.BOLD, 35));
        loginLabel.setForeground(Color.green);
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(loginLabel, gbc);

        gbc.insets = new Insets(5, 5, 5, 5);
        JTextField loginTxtField = new JTextField();
        loginTxtField.setPreferredSize(new Dimension(200, 28));
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(loginTxtField, gbc);


        gbc.insets = new Insets(5, 5, 5, 5);
        JLabel passLabel = new JLabel("Password:");
        passLabel.setFont(new Font("Chiller", Font.BOLD, 35));
        passLabel.setForeground(Color.green);
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(passLabel, gbc);

        gbc.insets = new Insets(5, 5, 5, 5);
        JPasswordField passTxtField = new JPasswordField();
        passTxtField.setPreferredSize(new Dimension(200, 28));
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(passTxtField, gbc);

        gbc.insets = new Insets(20, 20, 20, 20);
        ButtonMenu loginButton = new ButtonMenu("Login");
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(loginButton, gbc);

        gbc.insets = new Insets(20, 20, 20, 20);
        ButtonMenu guestButton = new ButtonMenu("Play as Guest");
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(guestButton, gbc);

        gbc.insets = new Insets(20, 20, 20, 20);
        ButtonMenu menuButton = new ButtonMenu("Back to Menu");
        menuButton.setFont(new Font("Chiller", Font.BOLD, 32));
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(menuButton, gbc);

        loginButton.addActionListener(e -> {
            //TODO zaimplementować logowanie

            System.out.println(loginTxtField.getText());
            System.out.println(passTxtField.getPassword());

//                loginTxtField
//                passTxtField

            System.out.println("Zaloguj!");
//            rootPanel.switchPanel(rootPanel.getMainMenu());

        });

        guestButton.addActionListener(e ->

        {
            System.out.println("Tutaj zagrasz jako gość");

                rootPanel.switchPanel(rootPanel.getGamePanel());


        });


        menuButton.addActionListener(e ->

        {
            System.out.println("Wróc do menu");

                rootPanel.switchPanel(rootPanel.getMainMenu());

        });

    }

}
