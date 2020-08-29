package com.larju;

import com.larju.gui.Canvas;

import javax.swing.*;

public class Main {

    /** Window dimensions */
    private static final int WIDTH = 1280;
    private static final int HEIGHT = 720;

    /** Looping until this is true */
    private static boolean finished = false;

    private static Canvas canvas;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Mandelbrot Visualization");
        canvas = new Canvas();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(canvas);
        frame.setSize(WIDTH, HEIGHT);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
