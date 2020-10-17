package com.gui;

import com.main.GameFrame;

import java.awt.Dimension;
import javax.swing.*;


public class MainMenu extends JPanel {

    GameFrame gameFrame;

    public MainMenu(GameFrame gameFrame) {
        this.gameFrame = gameFrame;

        ButtonMenu settingButton = new ButtonMenu("Ustawienia");
        add(settingButton);

        JTextField mainMenuLogo = new JTextField();
        mainMenuLogo.setText("MainMenu");
        add(mainMenuLogo);

        settingButton.addActionListener(e -> {
            gameFrame.changeToSettings();
        });


    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1100, 800);
    }

}
