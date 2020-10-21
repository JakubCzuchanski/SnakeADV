package com.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.font.TextLayout;

public class ButtonMenu extends JButton {

    public ButtonMenu(String text) {
        super(text);

        setFont(new Font("Chiller", Font.BOLD, 50));
        setForeground(Color.green);
        setBorder(null);
        setBorderPainted(false);
        setOpaque(false);
        setContentAreaFilled(false);

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                setForeground(Color.yellow);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                setForeground(Color.green);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                setForeground(Color.green);
            }
        });

    }
}
