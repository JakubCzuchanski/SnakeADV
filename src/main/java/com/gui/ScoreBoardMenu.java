package com.gui;

import javax.swing.*;
import java.awt.*;

public class ScoreBoardMenu extends JPanel {

    RootPanel rootPanel;

    public ScoreBoardMenu(RootPanel gameFrame) {
        this.rootPanel = gameFrame;

        setBackground(Color.BLACK);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();



        ButtonMenu menuButton = new ButtonMenu("Back to Menu");
        gbc.insets = new Insets(20, 20, 20, 20);
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(menuButton, gbc);


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
