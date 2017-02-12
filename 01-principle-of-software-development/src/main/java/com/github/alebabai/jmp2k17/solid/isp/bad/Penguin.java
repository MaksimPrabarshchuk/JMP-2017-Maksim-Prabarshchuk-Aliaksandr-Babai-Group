package com.github.alebabai.jmp2k17.solid.isp.bad;


import com.sun.xml.internal.ws.server.UnsupportedMediaException;

public class Penguin implements Bird {
    @Override
    public void fly() {
        System.out.println("WTF!?");
        throw new UnsupportedMediaException();
    }

    @Override
    public void tweet() {
        System.out.println("Penguin can tweet");
    }
}
