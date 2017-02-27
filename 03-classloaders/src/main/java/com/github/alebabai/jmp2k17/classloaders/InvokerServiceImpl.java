package com.github.alebabai.jmp2k17.classloaders;

import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.stream.Stream;

public class InvokerServiceImpl implements InvokerService {

    private final URLClassLoader classLoader;

    public InvokerServiceImpl(URL... urls) {
        this.classLoader = URLClassLoader.newInstance(urls);
    }

    @Override
    public <T> T invokeStatic(String className, String methodName, Object... args) {
        try {
            final Class<?> clazz = classLoader.loadClass(className);
            final Method method = Stream.of(clazz.getDeclaredMethods())
                    .filter(it -> it.getName().equals(methodName))
                    .findFirst()
                    .orElseThrow(() -> new NoSuchMethodException(String.format("Method with name %s is not found", methodName)));
            return (T) getInvocationResult(method, args);
        } catch (Exception e) {
            throw new InvokerException(e);
        }
    }

    private Object getInvocationResult(Method method, Object[] args) {
        try {
            return method.invoke(null, args);
        } catch (Exception e) {
            throw new RuntimeException("Error during method invocation", e);
        }
    }
}
