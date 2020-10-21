package com.gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;


public class MainMenu extends JPanel {

    private RootPanel rootPanel;
//    private JLabel backgroundImage;
    private Image backgroundImage;


    public MainMenu(RootPanel gameFrame) {
        this.rootPanel = gameFrame;

        setBackground(Color.BLACK);
        try{
            backgroundImage = ImageIO.read(new File("src/images/MenuBackground.jpeg"));
        }catch (IOException e){
            System.err.println(e);
        }



        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();


        gbc.insets = new Insets(20,20,80,20);

        ButtonMenu playButton = new ButtonMenu("Play!");
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(playButton, gbc);

        gbc.insets = new Insets(20,20,20,20);

        ButtonMenu signInButton = new ButtonMenu("Login");
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(signInButton, gbc);


        ButtonMenu signUpButton = new ButtonMenu("SignUP");
        gbc.gridwidth = 1;
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(signUpButton, gbc);


        ButtonMenu settingButton = new ButtonMenu("Settings");
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(settingButton, gbc);

        playButton.addActionListener(e -> {
            System.out.println("Tutaj zacznie granie");
            rootPanel.switchPanel(rootPanel.getGamePanel());
        });

        signInButton.addActionListener(e -> {
            System.out.println("Logowanie");
            rootPanel.switchPanel(rootPanel.getSignInMenu());
        });


        signUpButton.addActionListener(e -> {
            System.out.println("Rejestracja");
            rootPanel.switchPanel(rootPanel.getSignUpMenu());
        });

        settingButton.addActionListener(e -> {
            System.out.println("Ustawienia");
            rootPanel.switchPanel(rootPanel.getSettingsMenu());
        });


    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the background image.
        g.drawImage(backgroundImage, 0, 0, this);
    }

}
