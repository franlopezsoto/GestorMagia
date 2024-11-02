package org.example.gestormagia.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuditoriaAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @AfterReturning("execution(* org.example.gestormagia.service.HechizoService.guardarHechizo(..))")
    public void registrarHechizo(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        if (args.length > 0) {
            logger.info("Hechizo registrado: " + args[0].toString());
        }
    }
}
