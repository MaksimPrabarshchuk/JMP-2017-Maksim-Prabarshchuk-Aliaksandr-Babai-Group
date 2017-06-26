package com.github.alebabai.jmp2k17.locks;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.StampedLock;

import static java.lang.System.out;

public class LocksApplication {

    private static final Map<Integer, String> DB = new HashMap<>();
    private static final StampedLock LOCK = new StampedLock();

    public static void read() {
        long stamp = LOCK.readLock();
        try {
            sleep(1000L);
            out.printf("Reading from DB: %s%n", DB.get(RandomUtils.nextInt(0, 3)));
        } finally {
            LOCK.unlockRead(stamp);
        }
    }

    public static void write() {
        final long stamp = LOCK.writeLock();
        try {
            out.printf("Writing to DB with stamp - %d%n", stamp);
            DB.put(RandomUtils.nextInt(0, 3), RandomStringUtils.randomAlphabetic(10));
            sleep(100L);
        } finally {
            LOCK.unlockWrite(stamp);
        }
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        final ExecutorService executor = Executors.newFixedThreadPool(100);

        executor.submit(LocksApplication::write);
        executor.submit(LocksApplication::write);
        executor.submit(LocksApplication::write);
        executor.submit(LocksApplication::write);

        executor.submit(LocksApplication::read);
        executor.submit(LocksApplication::read);
        executor.submit(LocksApplication::read);
        executor.submit(LocksApplication::read);

        executor.submit(LocksApplication::write);
        executor.submit(LocksApplication::write);
        executor.submit(LocksApplication::write);
        executor.submit(LocksApplication::write);
        executor.submit(LocksApplication::write);
        executor.submit(LocksApplication::write);
        executor.submit(LocksApplication::write);
        executor.submit(LocksApplication::write);
        executor.submit(LocksApplication::write);
        executor.submit(LocksApplication::write);
        executor.submit(LocksApplication::write);
        executor.submit(LocksApplication::write);

        executor.submit(LocksApplication::read);
        executor.submit(LocksApplication::read);
        executor.submit(LocksApplication::read);
        executor.submit(LocksApplication::read);


        System.in.read();//wait main thread
    }
}
