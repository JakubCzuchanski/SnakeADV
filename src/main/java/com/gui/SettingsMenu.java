package com.gui;

import com.game.GamePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SettingsMenu extends JPanel {

    RootPanel rootPanel;
    GamePanel gamePanel;
    public JCheckBox wallHack;
    int soundLvl = 10;


    public SettingsMenu(RootPanel gameFrame) {
        this.rootPanel = gameFrame;
        gamePanel = new GamePanel(this.rootPanel);

        setBackground(Color.BLACK);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();


        JCheckBox eclipseEffect = new JCheckBox("Random Eclipse Effect");
        eclipseEffect.setFont(new Font("Chiller", Font.BOLD, 30));
        eclipseEffect.setSize(60, 60);
        eclipseEffect.setFocusable(false);
        eclipseEffect.setForeground(Color.green);
        eclipseEffect.setBackground(null);
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(eclipseEffect, gbc);



        wallHack = new JCheckBox("Wall Hack");
        wallHack.setFont(new Font("Chiller", Font.BOLD, 30));
        wallHack.setSize(60, 60);
        wallHack.setFocusable(false);
        wallHack.setForeground(Color.green);
        wallHack.setBackground(null);
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(wallHack, gbc);


        JSlider soundSlider = new JSlider(JSlider.HORIZONTAL, 0, 20, 10);
        soundSlider.setMajorTickSpacing(5);
        soundSlider.setBackground(null);
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridwidth = 1;
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(soundSlider, gbc);


        ButtonMenu muteButton = new ButtonMenu("Mute");
        muteButton.setFont(new Font("Chiller", Font.BOLD, 32));
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(muteButton, gbc);


        ButtonMenu menuButton = new ButtonMenu("Back to Menu");
        gbc.insets = new Insets(20, 20, 20, 20);
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(menuButton, gbc);


        eclipseEffect.addActionListener(e -> {
            if (eclipseEffect.isSelected()){
                System.out.println("Włączenie eclipse effect");
            }else {
                System.out.println("Wyłączenie eclipse effect");
            }
        });
        eclipseEffect.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                eclipseEffect.setForeground(Color.yellow);
            }
            public void mouseExited(MouseEvent evt) {
                eclipseEffect.setForeground(Color.green);
            }
        });


        wallHack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (wallHack.isSelected()) {
                    System.out.println("Włączenie wallhacka");
                    gamePanel.wallHack(true);
                } else if (!wallHack.isSelected()) {
                    System.out.println("Wyłączenie wallhacka");
                    gamePanel.wallHack(false);
                }
            }
        });
        wallHack.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                wallHack.setForeground(Color.yellow);
            }
            public void mouseExited(MouseEvent evt) {
                wallHack.setForeground(Color.green);
            }
        });


        muteButton.addActionListener(e -> {
            System.out.println("Wycisz");
            if (soundSlider.getValue() > 0){
                soundLvl = soundSlider.getValue();
                soundSlider.setValue(0);
            }else {
                soundSlider.setValue(soundLvl);
            }

        });

        soundSlider.addChangeListener(e -> {
            int value = soundSlider.getValue();
            System.out.println(value);

        });

        menuButton.addActionListener(e -> {
            System.out.println("Wróc do menu");
            rootPanel.switchPanel(rootPanel.getMainMenu());
        });

    }


}
