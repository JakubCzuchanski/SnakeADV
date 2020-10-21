package com.gui;

import com.game.GamePanel;

import javax.swing.*;
import java.awt.*;

public class RootPanel extends JRootPane {

    private MainMenu mainMenu;
    private SettingsMenu settingsMenu;
    private SignInMenu signInMenu;
    private SignUpMenu signUpMenu;
    private GamePanel gamePanel;

    public RootPanel() {
        mainMenu = new MainMenu(this);
        settingsMenu = new SettingsMenu(this);
        signInMenu = new SignInMenu(this);
        signUpMenu = new SignUpMenu(this);
        gamePanel = new GamePanel();

        contentPane.add(mainMenu);

    }

    public void switchPanel(JPanel panel) {
        contentPane.removeAll();
        contentPane.add(panel);
        contentPane.repaint();
        contentPane.revalidate();
    }

    public MainMenu getMainMenu() {
        return mainMenu;
    }

    public SettingsMenu getSettingsMenu() {
        return settingsMenu;
    }

    public SignInMenu getSignInMenu() {
        return signInMenu;
    }

    public SignUpMenu getSignUpMenu() {
        return signUpMenu;
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1100, 800);
    }
}
