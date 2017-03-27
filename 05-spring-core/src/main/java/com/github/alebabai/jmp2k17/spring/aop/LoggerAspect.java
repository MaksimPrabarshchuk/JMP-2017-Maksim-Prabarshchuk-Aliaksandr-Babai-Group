package com.github.alebabai.jmp2k17.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {

    @Before("execution( * com.github.alebabai.jmp2k17.spring.service.impl.EventsFactoryImpl.createEvent(..))")
    public void logMethodAccessBefore() {
        System.out.println("Start event creation");
    }
}
