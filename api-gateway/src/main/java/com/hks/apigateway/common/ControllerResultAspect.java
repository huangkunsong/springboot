package com.hks.apigateway.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ControllerResultAspect {

    @Around("execution(* org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor.handleReturnValue(..))")
    public Object ControllerResultHandle(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        ControllerResult controllerResult = new ControllerResult();
        controllerResult.setResult(args[0]);
        args[0] = controllerResult;
        return joinPoint.proceed(args);
    }

}
