package com.github.alebabai.jmp2k17.oom;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/**
 * Run with 20 MB as maximum HEAP size and
 * -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/your/path options
 */
public class OutOfMemoryExample {
    private static long LOWER_BOUND = 0;
    private static long UPPER_BOUND = 1000000;

    public static void main(String[] args) {
        try {
            final List<DataHolder> collect = LongStream.range(LOWER_BOUND, UPPER_BOUND)
                    .boxed()
                    .map(DataHolder::new)
                    .collect(Collectors.toList());
            collect.forEach(System.out::println);
        } catch (OutOfMemoryError error) {
            System.out.println("Out of memory error here!");
        }
    }
}
