package com.github.alebabai.jmp2k17.solid.lsp.good;

import org.junit.Assert;
import org.junit.Test;

public class LiskovSubstitutionPrincipleTest {

    @Test
    public void rectangleTest() {
        final Rectangle rectangle = new Rectangle(2, 4);
        Assert.assertEquals(AreaCalculator.calculateArea(rectangle), 8.0, 0.0);
    }

    @Test
    public void squareTest() {
        final Square square = new Square(2);
        Assert.assertEquals(AreaCalculator.calculateArea(square), 4.0, 0.0);
    }
}
