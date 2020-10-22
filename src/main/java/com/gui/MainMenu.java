package com.gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;


public class MainMenu extends JPanel {

    private RootPanel rootPanel;
    private Image backgroundImage;


    public MainMenu(RootPanel gameFrame) {
        this.rootPanel = gameFrame;

        try{
            backgroundImage = ImageIO.read(new File("src/images/MenuBackground.jpeg"));
        }catch (IOException e){
            System.err.println(e);
            e.printStackTrace();
            setBackground(Color.BLACK);
        }



        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();


        gbc.insets = new Insets(20,20,50,20);
        ButtonMenu playButton = new ButtonMenu("Play!");
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(playButton, gbc);

        gbc.insets = new Insets(20,20,20,20);
        ButtonMenu scoreButton = new ButtonMenu("Score Board");
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(scoreButton, gbc);


        gbc.insets = new Insets(20,20,20,20);
        ButtonMenu signInButton = new ButtonMenu("Login");
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(signInButton, gbc);


        gbc.insets = new Insets(20,20,20,20);
        ButtonMenu signUpButton = new ButtonMenu("SignUP");
        gbc.gridwidth = 1;
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(signUpButton, gbc);


        gbc.insets = new Insets(20,20,20,20);
        ButtonMenu settingButton = new ButtonMenu("Settings");
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(settingButton, gbc);

        gbc.insets = new Insets(20,20,20,20);
        ButtonMenu exitButton = new ButtonMenu("Exit");
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(exitButton, gbc);

        playButton.addActionListener(e -> {
            System.out.println("Tutaj zacznie granie");
            try {
                rootPanel.switchPanel(rootPanel.getGamePanel());
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        });

        scoreButton.addActionListener(e -> {
            System.out.println("Punkciki");
            try {
                rootPanel.switchPanel(rootPanel.getScoreBoardMenu());
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        });


        signInButton.addActionListener(e -> {
            System.out.println("Logowanie");
            try {
                rootPanel.switchPanel(rootPanel.getSignInMenu());
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        });


        signUpButton.addActionListener(e -> {
            System.out.println("Rejestracja");
            try {
                rootPanel.switchPanel(rootPanel.getSignUpMenu());
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        });

        settingButton.addActionListener(e -> {
            System.out.println("Ustawienia");
            try {
                rootPanel.switchPanel(rootPanel.getSettingsMenu());
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        });

        exitButton.addActionListener(e -> {
            System.out.println("Wyjscie");
            System.exit(0);
        });

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the background image.
        g.drawImage(backgroundImage, 0, 0, this);
    }

}
