package com.github.alebabai.jmp2k17.java8;

import lombok.Value;
import lombok.experimental.Accessors;

@Value
@Accessors(chain = true)
public class Data {
    private final String name;
    private final String data;
}
