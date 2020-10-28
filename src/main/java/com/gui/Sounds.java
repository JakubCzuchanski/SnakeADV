package com.gui;

import javax.sound.sampled.*;
import java.io.*;

public class Sounds {

    public void playSound(String filePath) {


 //       javax.sound.sampled.LineUnavailableException: line with format PCM_SIGNED 44100.0 Hz, 24 bit, stereo, 6 bytes/frame, little-endian not supported.


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



