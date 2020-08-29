package com.larju.gui;

import javax.swing.*;
import java.awt.*;

public class Canvas extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Here we can draw custom things
        g.drawString("hello, world", 0, 10);
    }
}
