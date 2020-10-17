package com.main;

import com.gui.MainMenu;
import com.gui.SettingsMenu;

import javax.swing.JFrame;

public class GameFrame extends JFrame {

	private MainMenu mainMenu;
	private SettingsMenu settingsMenu;

	public GameFrame() {
		mainMenu = new MainMenu(this);
		settingsMenu = new SettingsMenu(this);

		setTitle("SnakeADV");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		add(settingsMenu);
		settingsMenu.setVisible(false);
		add(mainMenu);


		pack();

	}

	public void changeToSettings(){
		mainMenu.setVisible(false);
		settingsMenu.setVisible(true);

	}
	public void backToMainMenu(){
		System.out.println("test");

	}

}
