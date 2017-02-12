package com.github.alebabai.jmp2k17.solid.isp.bad;

public class Penguin implements Bird {
    @Override
    public void fly() {
        System.out.println("WTF!?");
    }

    @Override
    public void tweet() {
        System.out.println("Penguin can tweet");
    }
}
