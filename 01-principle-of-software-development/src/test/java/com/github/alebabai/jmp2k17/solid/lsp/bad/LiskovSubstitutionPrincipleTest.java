package com.github.alebabai.jmp2k17.solid.lsp.bad;

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
        square.setHeight(3);
        Assert.assertNotEquals(AreaCalculator.calculateArea(square), 4.0, 0.0);
    }
}
