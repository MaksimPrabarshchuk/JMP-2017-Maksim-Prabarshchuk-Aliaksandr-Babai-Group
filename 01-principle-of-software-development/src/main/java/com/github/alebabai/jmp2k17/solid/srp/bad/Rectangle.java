package com.github.alebabai.jmp2k17.solid.srp.bad;

public class Rectangle {
    private final long width;
    private final long height;

    public Rectangle(long width, long height) {
        this.width = width;
        this.height = height;
    }

    public long getWidth() {
        return width;
    }

    public long getHeight() {
        return height;
    }

    public long calculateArea() {
        return width * height;
    }

    public void print() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }
}
