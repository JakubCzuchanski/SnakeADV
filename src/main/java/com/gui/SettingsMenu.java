package com.gui;

import com.main.GameFrame;

import javax.swing.*;
import java.awt.*;

public class SettingsMenu extends JPanel {

    GameFrame gameFrame;

    public SettingsMenu(GameFrame gameFrame) {
        this.gameFrame = gameFrame;

        ButtonMenu menuButton = new ButtonMenu("Wróc do menu");
        add(menuButton);

        JTextField settingsLogo = new JTextField();
        settingsLogo.setText("Ustawienia");
        add(settingsLogo);


        menuButton.addActionListener(e -> {
            gameFrame.backToMainMenu();

        });

    }

    @Override
    public Dimension getPreferredSize() {
        // TODO Auto-generated method stub
        return new Dimension(1100, 800);
    }

}
