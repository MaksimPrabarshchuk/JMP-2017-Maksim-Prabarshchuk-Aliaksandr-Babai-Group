package com.github.alebabai.jmp2k17.deadlock;


import java.io.IOException;
import java.util.concurrent.CompletableFuture;

public class DeadLockExample {
    private DeadLockExample() {
    }

    public static void main(String[] args) throws IOException {
        final SharedResource first = new SharedResource("first");
        final SharedResource second = new SharedResource("second");
        final SharedResource third = new SharedResource("third");

        CompletableFuture.runAsync(() -> {
            synchronized (first) {
                System.out.println("Thread 1: locked resource 1");

                try { Thread.sleep(100);} catch (Exception e) {}

                synchronized (second) {
                    System.out.println("Thread 1: locked resource 2");
                }
            }
        });

        CompletableFuture.runAsync(() -> {
            synchronized (second) {
                System.out.println("Thread 2: locked resource 2");

                try { Thread.sleep(100);} catch (Exception e) {}

                synchronized (first) {
                    System.out.println("Thread 2: locked resource 1");
                }
            }
        });

        CompletableFuture.runAsync(() -> {
            synchronized (third) {
                System.out.println("Thread 3: locked resource 3");

                try { Thread.sleep(100);} catch (Exception e) {}

                synchronized (first) {
                    System.out.println("Thread 3: locked resource 1");
                }
            }
        });

        System.in.read();
    }
}
