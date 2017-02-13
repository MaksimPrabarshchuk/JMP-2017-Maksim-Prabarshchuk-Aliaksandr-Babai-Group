package com.github.alebabai.jmp2k17.solid.isp.good;

public class Parrot implements TweetBehaviour, FlyBehaviour {
    @Override
    public void fly() {
        System.out.println("Parrot can fly");
    }

    @Override
    public void tweet() {
        System.out.println("Parrot can tweet");
    }
}
