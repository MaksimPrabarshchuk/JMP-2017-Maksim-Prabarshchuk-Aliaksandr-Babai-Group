package com.github.alebabai.jmp2k17.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;

import java.io.IOException;

@SpringBootApplication
@EnableAspectJAutoProxy
@ImportResource("classpath:context.groovy")
public class SomeSpringApplication {
    public static void main(String[] args) throws IOException {
        SpringApplication.run(SomeSpringApplication.class, args);
        System.in.read();
    }
}
