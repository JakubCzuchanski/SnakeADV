package com.main;

import com.gui.RootPanel;
import com.gui.Sounds;


import javax.swing.JFrame;

public class GameFrame extends JFrame {

	RootPanel rootPanel ;

	public GameFrame()  {
		rootPanel = new RootPanel();
		setTitle("SnakeADV");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(rootPanel);
		setVisible(true);
		pack();

	}

}
