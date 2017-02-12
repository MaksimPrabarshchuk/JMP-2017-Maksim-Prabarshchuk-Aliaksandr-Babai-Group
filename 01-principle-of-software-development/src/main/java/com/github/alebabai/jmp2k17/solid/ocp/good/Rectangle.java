package com.github.alebabai.jmp2k17.solid.ocp.good;

public class Rectangle extends Shape {
    public Rectangle(double area) {
        super(area);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "area=" + area +
                '}';
    }

    @Override
    public void draw() {
        System.out.println("Drawing rectangle");
        System.out.println(this);
    }
}
