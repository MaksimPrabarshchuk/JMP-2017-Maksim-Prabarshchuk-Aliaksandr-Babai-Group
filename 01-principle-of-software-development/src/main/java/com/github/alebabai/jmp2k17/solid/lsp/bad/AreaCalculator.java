package com.github.alebabai.jmp2k17.solid.lsp.bad;

public class AreaCalculator {
    private AreaCalculator() {
    }

    public static double calculateArea(Rectangle rectangle) {
        return rectangle.getHeight() * rectangle.getWidth();
    }
}
