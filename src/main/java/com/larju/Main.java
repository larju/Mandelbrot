package com.larju;

import com.larju.gui.Mandelbrot;

import javax.swing.*;

public class Main {

    /** Window dimensions */
    public static final int WIDTH = 1280;
    public static final int HEIGHT = 720;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Mandelbrot Visualization");
        Mandelbrot mandelbrot = new Mandelbrot();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.add(mandelbrot);
    }
}
