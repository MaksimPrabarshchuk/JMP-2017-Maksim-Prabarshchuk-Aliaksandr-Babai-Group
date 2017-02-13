package com.github.alebabai.jmp2k17.solid.ocp.good;

public class Circle extends Shape {
    public Circle(double area) {
        super(area);
    }

    @Override
    public void draw() {
        System.out.println("Drawing circle");
        System.out.println(this);
    }
}
