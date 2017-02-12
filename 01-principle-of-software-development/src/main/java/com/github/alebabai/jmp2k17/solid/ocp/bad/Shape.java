package com.github.alebabai.jmp2k17.solid.ocp.bad;

public abstract class Shape {
    protected final double area;

    public Shape(double area) {
        this.area = area;
    }

    public double getArea() {
        return area;
    }

    @Override
    public String toString() {
        return "Shape{" +
                "area=" + area +
                '}';
    }
}
