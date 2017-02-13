package com.github.alebabai.jmp2k17.solid.srp.good;

import java.util.Optional;

public class RectanglePresenter {

    public void print(Rectangle rectangle) {
        Optional.ofNullable(rectangle)
                .ifPresent(System.out::println);
    }
}
