package com.github.alebabai.jmp2k17.classloaders;

import org.junit.Assert;
import org.junit.Test;

import java.net.MalformedURLException;

public class InvokerServiceTest {
    private static final String BASE_FOLDER_NAME = "/Users/alebabai/workspace/JMP-2017/03-classloaders/jars-folder";
    private static final String FIRST_JAR_NAME = "03-classloaders-0.0.1.jar";
    private static final String SECOND_JAR_NAME = "03-classloaders-0.0.2.jar";
    private static final String CLASS_NAME = "com.github.alebabai.jmp2k17.classloaders.SimpleClass";
    private static final String METHOD_NAME = "processText";
    private static final String TEXT = "Some text";

    @Test
    public void firstClassTest() throws MalformedURLException {
        final InvokerService service = new InvokerServiceImpl(InvokerUtils.getURL(BASE_FOLDER_NAME, FIRST_JAR_NAME));
        final String result = service.invokeStatic(CLASS_NAME, METHOD_NAME, "Some text");
        Assert.assertNotNull(result);
    }

    @Test
    public void secondClassTest() throws MalformedURLException {
        final InvokerService service = new InvokerServiceImpl(InvokerUtils.getURL(BASE_FOLDER_NAME, FIRST_JAR_NAME));
        final String result = service.invokeStatic(CLASS_NAME, METHOD_NAME, "Some text");
        Assert.assertNotNull(result);
    }

    @Test
    public void bothClassesTest() throws MalformedURLException {
        final InvokerService service1 = new InvokerServiceImpl(InvokerUtils.getURL(BASE_FOLDER_NAME, FIRST_JAR_NAME));
        final InvokerService service2 = new InvokerServiceImpl(InvokerUtils.getURL(BASE_FOLDER_NAME, SECOND_JAR_NAME));
        final String firstResult = service1.invokeStatic(CLASS_NAME, METHOD_NAME, TEXT);
        final String secondResult = service2.invokeStatic(CLASS_NAME, METHOD_NAME, TEXT);
        Assert.assertNotNull(firstResult);
        Assert.assertNotNull(secondResult);
        Assert.assertNotEquals(firstResult, secondResult);
    }

}
