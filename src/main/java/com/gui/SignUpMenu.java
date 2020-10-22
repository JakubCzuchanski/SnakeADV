package com.gui;

import javax.swing.*;
import java.awt.*;

public class SignUpMenu extends JPanel {

    RootPanel rootPanel;

    public SignUpMenu(RootPanel gameFrame) {
        this.rootPanel = gameFrame;

        setBackground(Color.BLACK);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();


        gbc.insets = new Insets(5, 5, 5, 5);
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(new Font("Chiller", Font.BOLD, 35));
        nameLabel.setForeground(Color.green);
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(nameLabel, gbc);

        gbc.insets = new Insets(5, 5, 5, 5);
        JTextField nameTxtField = new JTextField();
        nameTxtField.setPreferredSize(new Dimension(200, 28));
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(nameTxtField, gbc);

        gbc.insets = new Insets(5, 5, 5, 5);
        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setFont(new Font("Chiller", Font.BOLD, 35));
        ageLabel.setForeground(Color.green);
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(ageLabel, gbc);

        gbc.insets = new Insets(5, 5, 5, 5);
        JTextField ageTxtField = new JTextField();
        ageTxtField.setPreferredSize(new Dimension(200, 28));
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(ageTxtField, gbc);


        gbc.insets = new Insets(5, 5, 5, 5);
        JLabel loginLabel = new JLabel("Login:");
        loginLabel.setFont(new Font("Chiller", Font.BOLD, 35));
        loginLabel.setForeground(Color.green);
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(loginLabel, gbc);

        gbc.insets = new Insets(5, 5, 5, 5);
        JTextField loginTxtField = new JTextField();
        loginTxtField.setPreferredSize(new Dimension(200, 28));
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(loginTxtField, gbc);

        gbc.insets = new Insets(5, 5, 5, 5);
        JLabel passLabel = new JLabel("Password:");
        passLabel.setFont(new Font("Chiller", Font.BOLD, 35));
        passLabel.setForeground(Color.green);
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(passLabel, gbc);

        gbc.insets = new Insets(5, 5, 5, 5);
        JPasswordField passTxtField = new JPasswordField();
        passTxtField.setPreferredSize(new Dimension(200, 28));
        gbc.gridx = 1;
        gbc.gridy = 3;
        add(passTxtField, gbc);

        gbc.insets = new Insets(5, 5, 5, 5);
        JLabel passConfLabel = new JLabel("Confirm Password:");
        passConfLabel.setFont(new Font("Chiller", Font.BOLD, 35));
        passConfLabel.setForeground(Color.green);
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(passConfLabel, gbc);

        gbc.insets = new Insets(5, 5, 5, 5);
        JPasswordField passConfTxtField = new JPasswordField();
        passConfTxtField.setPreferredSize(new Dimension(200, 28));
        gbc.gridx = 1;
        gbc.gridy = 4;
        add(passConfTxtField, gbc);

        gbc.insets = new Insets(20, 20, 20, 20);
        ButtonMenu registerButton = new ButtonMenu("Sign Up!");
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 5;
        add(registerButton, gbc);

        gbc.insets = new Insets(20, 20, 20, 20);
        ButtonMenu menuButton = new ButtonMenu("Back to Menu");
        menuButton.setFont(new Font("Chiller", Font.BOLD, 32));
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 6;
        add(menuButton, gbc);

        registerButton.addActionListener(e -> {
            System.out.println("name " + nameTxtField.getText());
            System.out.println("age " + ageTxtField.getText());
            System.out.println("login " + loginTxtField.getText());
            System.out.print("pass ");
            System.out.println((passTxtField.getPassword()));
            System.out.print("pass ");
            System.out.println((passConfTxtField.getPassword()));

            System.out.println("Zarejestrowano");
            try {
                rootPanel.switchPanel(rootPanel.getMainMenu());
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        });


        menuButton.addActionListener(e -> {
            System.out.println("Wróc do menu");
            try {
                rootPanel.switchPanel(rootPanel.getMainMenu());
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        });

    }

}
