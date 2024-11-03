package org.example.gestormagia.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* org.example.gestormagia.service.*.*(..))")
    public void logBeforeMethod() {
        System.out.println("Method execution started");
    }
}
