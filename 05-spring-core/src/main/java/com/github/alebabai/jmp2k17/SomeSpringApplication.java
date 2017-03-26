package com.github.alebabai.jmp2k17;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.StaticApplicationContext;

import java.io.IOException;

@SpringBootApplication
@ImportResource("classpath:context.groovy")
public class SomeSpringApplication {
    public static void main(String[] args) throws IOException {
        SpringApplication.run(SomeSpringApplication.class, args);
        System.in.read();
    }
}
