package com.luv2code.springboot.thymeleafdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class DemoLoginAspect {

    // setup logger
    private Logger logger = Logger.getLogger(getClass().getName());

    // set up pointcur declarations
    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.controller.*.*(..))")
    private void forControllerPackage(){}

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.dao.*.*(..))")
    private void forDaoPackage(){}

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.service.*.*(..))")
    private void forServicePackage(){}


    @Pointcut("forControllerPackage() || forDaoPackage() || forServicePackage()")
    private void forAppFlow(){}

    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint){

        // display method we are all calling
        String method = joinPoint.getSignature().toShortString();
        logger.info("=====> in @Before: calling method: "+method);

        // display the arguments

        // get the arguments
        Object[] args = joinPoint.getArgs();

        // loop thru the arguments and display them
        for(Object arg: args){
            logger.info("=====> argument: " + arg);
        }

    }

    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "result"
    )
    public void afterReturning(JoinPoint joinPoint, Object result){

        // display method
        String method = joinPoint.getSignature().toShortString();
        logger.info("=====> in @AfterReturning calling method: "+method);

        // display data returned
        logger.info("=====> result: " + result);


    }



}
