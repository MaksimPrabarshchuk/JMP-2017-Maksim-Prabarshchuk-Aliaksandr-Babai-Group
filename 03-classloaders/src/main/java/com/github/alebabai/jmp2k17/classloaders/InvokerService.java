package com.github.alebabai.jmp2k17.classloaders;

public interface InvokerService {

    /**
     * Invokes static methods of a class
     *
     * @param className
     * @param methodName
     * @param args
     * @param <T>
     * @return T
     */
    <T> T invokeStatic(String className, String methodName, Object... args);
}
