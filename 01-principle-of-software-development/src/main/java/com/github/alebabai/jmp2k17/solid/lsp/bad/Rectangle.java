package com.github.alebabai.jmp2k17.solid.lsp.bad;

public class Rectangle {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public Rectangle setWidth(double width) {
        this.width = width;
        return this;
    }

    public double getHeight() {
        return height;
    }

    public Rectangle setHeight(double height) {
        this.height = height;
        return this;
    }
}
