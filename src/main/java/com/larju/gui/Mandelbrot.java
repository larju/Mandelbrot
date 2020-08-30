package com.larju.gui;

import com.larju.Main;

import javax.swing.*;
import java.awt.*;

public class Mandelbrot extends JPanel {

    /**
     * The ranges that screen coordinates should be scaled to.
     * Using same scale as Wikipedia article linked in /README.md (from section "Computer drawings").
     */
    private final float[] RANGE_X = {-2.5f, 1f};
    private final float[] RANGE_Y = {-1f, 1f};
    private float stepSizeX;
    private float stepSizeY;

    private final int MAX_ITERATIONS = 1500;

    public Mandelbrot() {
        super();

        float scaleXLength = Math.abs(RANGE_X[0]) + Math.abs(RANGE_X[1]);
        float scaleYLength = Math.abs(RANGE_Y[0]) + Math.abs(RANGE_Y[1]);
        stepSizeX = scaleXLength / Main.WIDTH;
        stepSizeY = scaleYLength / Main.HEIGHT;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        /*
         * Below I'm following pseudocode from Wikipedia article linked
         * in /README.md (under the section "Reading List", https://en.wikipedia.org/wiki/Mandelbrot_set#Computer_drawings).
         *
         * I do make my own modifications to this code.
         */
        // For each pixel on panel
        for (int y = 0; y < Main.HEIGHT; y++) {
            for (int x = 0; x < Main.WIDTH; x++) {
                // Scaling coordinates to our range
                double scaledX = scaleX(x);
                double scaledY = scaleY(y);

                int iterations = 0;                     // Number of current iterations
                double iterationX = 0, iterationY = 0;  // Variables used for continuous iterations below

                // Iterative process of iterationX & iterationY
                while (Math.pow(iterationX, 2) + Math.pow(iterationY, 2) <= 4*4 && iterations < MAX_ITERATIONS) {
                    double temporaryX = iterationX*iterationX - iterationY*iterationY + scaledX;
                    iterationY = 2*iterationX*iterationY + scaledY;
                    iterationX = temporaryX;

                    iterations++;
                }

                /* Selecting color & drawing pixel */
                g.setColor(new Color(iterations % 255));
                g.fillRect(x, y, 1, 1);
            }
        }

        System.out.println("Rendering done.");
    }

    /**
     * Used to scale a value to fit our range.
     *
     * @param value The value to scale
     * @return The scaled value
     */
    private double scaleX(double value) {
        return RANGE_X[0] + value*stepSizeX;
    }

    /**
     * Used to scale a value to fit our range.
     *
     * @param value The value to scale
     * @return The scaled value
     */
    private double scaleY(double value) {
        return RANGE_Y[0] + value*stepSizeY;
    }
}
