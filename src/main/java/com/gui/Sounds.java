package com.gui;

import javax.sound.sampled.*;
import java.io.*;

public class Sounds  {

RootPanel rootPanel;

    public void playSound(String filePath) {

        new Thread(() -> {
            try {
                System.out.println(filePath + " Sound played");
                File sound = new File(filePath);
                AudioInputStream inputStream = AudioSystem.getAudioInputStream(sound);
                Clip clip = AudioSystem.getClip();
                clip.open(inputStream);
                clip.start();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                e.printStackTrace();
            }
        }).start();

    }
}



