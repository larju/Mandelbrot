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
