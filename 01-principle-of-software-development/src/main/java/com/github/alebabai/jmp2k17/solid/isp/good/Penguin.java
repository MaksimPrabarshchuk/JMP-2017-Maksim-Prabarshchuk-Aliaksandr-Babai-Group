package com.github.alebabai.jmp2k17.solid.isp.good;


public class Penguin implements SwimBehaviour, TweetBehaviour {
    @Override
    public void swim() {
        System.out.println("Penguin cat swim");
    }

    @Override
    public void tweet() {
        System.out.println("Penguin can tweet");
    }
}
