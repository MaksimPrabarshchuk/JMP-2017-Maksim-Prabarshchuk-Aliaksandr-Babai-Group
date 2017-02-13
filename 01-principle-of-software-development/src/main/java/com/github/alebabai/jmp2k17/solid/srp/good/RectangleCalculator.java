package com.github.alebabai.jmp2k17.solid.srp.good;

import java.util.Optional;

public class RectangleCalculator {

    public double getArea(Rectangle rectangle) {
        return Optional.ofNullable(rectangle)
                .map(it -> it.getWidth() * it.getHeight())
                .orElse(Double.NaN);
    }
}
