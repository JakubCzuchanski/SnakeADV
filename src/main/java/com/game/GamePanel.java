package com.game;

import com.gui.RootPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import static java.awt.Color.*;

public class GamePanel extends JPanel implements ActionListener {


    private static final int SCREEN_HEIGHT = 810;
    private static final int SCREEN_WIDTH = 1080;
    private static final int UNIT = 30;
    private static final int GAME_UNIT = (SCREEN_HEIGHT * SCREEN_WIDTH) / UNIT;
    private int[] snakeX = new int[GAME_UNIT];
    private int[] snakeY = new int[GAME_UNIT];
    int snakeSize = 8;
    private int appleX;
    private int appleY;
    private boolean running;
    Timer timer;
    private Random random;
    char direction = 'R';
    private static final int DELAY = 80;
    int score = 0;
    RootPanel rootPanel;


    public GamePanel(RootPanel gameFrame) {
        rootPanel = gameFrame;

        setLayout(null);
        setBackground(BLACK);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyEvent(this));
        startGame();


    }

    public void startGame() {
        running = true;
        random = new Random();
        snakeX = new int[GAME_UNIT];
        snakeY = new int[GAME_UNIT];
        newApple();
        direction = 'R';
        timer = new Timer(DELAY, this);
        timer.start();
        requestFocus();

    }

    public void newApple() {
        appleX = random.nextInt((int) (SCREEN_WIDTH / UNIT)) * UNIT;
        appleY = random.nextInt((int) (SCREEN_HEIGHT / UNIT)) * UNIT;
    }

    public void checkApple() {
        for (int i = snakeSize; i > 0; i--) {
            if (snakeX[0] == appleX && snakeY[0] == appleY) {
                newApple();
                snakeSize++;
                score += 23;
            }
        }
    }

    public void crash() {
        for (int i = 0; i < snakeSize; i++) {
            if (snakeX[0] == snakeX[i + 1] && snakeY[0] == snakeY[i + 1]) {
                running = false;
            }
        }
        if (snakeX[0] < 0 || snakeX[0] > SCREEN_WIDTH || snakeY[0] < 0 || snakeY[0] > SCREEN_HEIGHT) {
            running = false;
        }
        if (!running) {
            timer.stop();
        }

    }

    public void move() {
        for (int i = snakeSize; i > 0; i--) {
            snakeX[i] = snakeX[i - 1];
            snakeY[i] = snakeY[i - 1];
        }
        if (running) {
            switch (direction) {
                case 'L':
                    snakeX[0] -= UNIT;
                    break;
                case 'R':
                    snakeX[0] += UNIT;
                    break;
                case 'U':
                    snakeY[0] -= UNIT;
                    break;
                case 'D':
                    snakeY[0] += UNIT;
                    break;
            }
        }
    }

    public void gameOver() {
        rootPanel.switchPanel(rootPanel.getGameOver());
//        g.setColor(RED);
//        g.setFont(new Font("Arial",Font.BOLD, 100));
//        FontMetrics fontMetrics1 = getFontMetrics(g.getFont());
//        g.drawString("Game over", (SCREEN_WIDTH - fontMetrics1.stringWidth("Game over")) / 2, SCREEN_HEIGHT / 2);
//        g.setColor(RED);
//        g.setFont(new Font("Arial", Font.BOLD, 30));
//        FontMetrics fontMetrics2 = getFontMetrics(g.getFont());
//        g.drawString("Score: " + score, (SCREEN_WIDTH - fontMetrics2.stringWidth("Score: " + score)) / 2, (SCREEN_HEIGHT / 2) + 60);
//
//        g.setColor(BLUE);
//        g.setFont(new Font("Arial", Font.BOLD, 15));
//        FontMetrics fontMetrics3 = getFontMetrics(g.getFont());
//        g.drawString("Press key k to restart", (SCREEN_WIDTH - fontMetrics3.stringWidth("Press key k to restart")) / 2, (SCREEN_HEIGHT / 2) + 90);


    }

    @Override
    protected void paintComponent(Graphics g){
            super.paintComponent(g);

            if (running) {
                g.setColor(RED);
                g.fillOval(appleX, appleY, UNIT, UNIT);

                for (int i = 0; i < snakeSize; i++) {
                    if (i == 0) {
                        g.setColor(GREEN);
                        g.fillRect(snakeX[i], snakeY[i], UNIT, UNIT);
                    } else {
                        g.setColor(BLUE);
                        g.fillRect(snakeX[i], snakeY[i], UNIT, UNIT);
                    }
                }
                g.setColor(RED);
                g.setFont(new Font("Arial", Font.BOLD, 30));
                FontMetrics fontMetrics = getFontMetrics(g.getFont());
                g.drawString("Score: " + score, SCREEN_WIDTH - fontMetrics.stringWidth("Score: " + score), 30);

            } else
                gameOver();
        }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            move();
            checkApple();
            crash();
        }
        repaint();
    }


    public int getScore() {
        return score;
    }

}