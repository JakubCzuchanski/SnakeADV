package com.game;

import com.gui.RootPanel;
import com.gui.SettingsMenu;


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
    private int badAppleX;
    private int badAppleY;
    private boolean running;
    Timer timer;
    private Random random;
    char direction = 'R';
    private static final int DELAY = 80;
    int score = 0;
    RootPanel rootPanel;
    static boolean isWallHack;
    private int appleEaten = 0;
    private int timeGame = 0;



    public GamePanel(RootPanel gameFrame) throws InterruptedException {
        this.rootPanel = gameFrame;
        setLayout(null);
        setBackground(BLACK);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyEvent(this));
        startGame();


    }

    public void startGame() throws InterruptedException {
        running = true;
        random = new Random();
        snakeX = new int[GAME_UNIT];
        snakeY = new int[GAME_UNIT];
        newApple();
        drawBadApple();
        direction = 'R';
        timer = new Timer(DELAY, this);
        timer.start();
        stoper();
        requestFocus();

    }

    public void wallHack(boolean value) {
        isWallHack = value;

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
                appleEaten++;
            }
        }
    }


    public void drawBadApple() {

            badAppleX = random.nextInt((int) (SCREEN_WIDTH / UNIT)) * UNIT;
            badAppleY = random.nextInt((int) (SCREEN_HEIGHT / UNIT)) * UNIT;
        }



    public void stoper() throws InterruptedException {

        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                timeGame++;
            }
        }).start();
    }

    public void checkBadApple() {
        for (int i = snakeSize; i > 0; i--) {
            if (snakeX[0] == badAppleX && snakeY[0] == badAppleY) {
                drawBadApple();
                score -= 23;
            }

        }
    }

    public void eclipseEffect() {

    }

    public void crash() {
        if (!isWallHack) {
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
    }

    public void wallHackMode() {
        if (isWallHack) {
            for (int i = 0; i < snakeSize; i++) {
                if (snakeX[0] == snakeX[i + 1] && snakeY[0] == snakeY[i + 1]) {
                    running = false;
                }
            }
            if (snakeX[0] < 0) {
                snakeX[0] = SCREEN_WIDTH;
            }
            if (snakeX[0] > SCREEN_WIDTH) {
                snakeX[0] = 0;
            }
            if (snakeY[0] < 0) {
                snakeY[0] = SCREEN_HEIGHT;
            }
            if (snakeY[0] > SCREEN_HEIGHT) {
                snakeY[0] = 0;
            }
            if (!running) {
                timer.stop();
            }

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

    public void gameOver() throws InterruptedException {
        rootPanel.switchPanel(rootPanel.getGameOver());

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (running) {
            g.setColor(RED);
            g.fillOval(appleX, appleY, UNIT, UNIT);
            g.setColor(MAGENTA);
            g.fillOval(badAppleX, badAppleY, UNIT, UNIT);


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

            g.setColor(RED);
            g.setFont(new Font("Arial", Font.BOLD, 30));
            FontMetrics fontMetrics1 = getFontMetrics(g.getFont());
            g.drawString("Apple: " + appleEaten, (SCREEN_WIDTH - fontMetrics1.stringWidth("Apple: " + appleEaten)) / 30, 30);

            g.setColor(RED);
            g.setFont(new Font("Arial", Font.BOLD, 30));
            FontMetrics fontMetrics2 = getFontMetrics(g.getFont());
            g.drawString("Time: " + timeGame, (SCREEN_WIDTH - fontMetrics2.stringWidth("Time: " + timeGame)) / 5, 30);

        } else {
            try {
                gameOver();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            move();
            checkApple();
            checkBadApple();
            crash();
            wallHackMode();
        }
        repaint();
    }


    public int getScore() {
        return score;
    }

}