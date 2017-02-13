package com.github.alebabai.jmp2k17.solid.ocp.bad;

public class ShapePresenter {
    public void drawShape(Shape shape){
        if(shape instanceof Circle) {
            drawCircle((Circle) shape);
        } else if(shape instanceof Rectangle) {
            drawRectangle((Rectangle) shape);
        }
    }

    protected void drawRectangle(Rectangle rectangle) {
        System.out.println("Drawing rectangle");
        System.out.println(rectangle);
    }

    protected void drawCircle(Circle circle) {
        System.out.println("Drawing circle");
        System.out.println(circle);
    }
}
