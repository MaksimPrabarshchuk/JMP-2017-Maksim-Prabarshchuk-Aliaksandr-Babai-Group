package com.github.alebabai.jmp2k17.deadlock;

public class SharedResource {
    private final String data;

    public SharedResource(String name) {
        this.data = name;
    }

    public String getData() {
        return this.data;
    }

    @Override
    public String toString() {
        return "SharedResource{" +
                "data='" + data + '\'' +
                '}';
    }
}
