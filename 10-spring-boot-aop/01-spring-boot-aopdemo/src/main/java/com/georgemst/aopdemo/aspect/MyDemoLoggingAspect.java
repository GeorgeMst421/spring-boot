package com.georgemst.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // this is where we add all of our related advices for logging

    // let's start with a @Before advice

    // @Before("execution(void addAccount())")

//    @Before("execution(void add*())")

//    @Before("execution(* add*())")

//    @Before("execution(* add*(com.georgemst.aopdemo.Account))")

//    @Before("execution(* add*(com.georgemst.aopdemo.Account, ..))")

//    @Before("execution(* add*(..))")
    


    @Before("execution(* com.georgemst.aopdemo.dao.*.*(..))")
    public void beforeAddAccountAdvice(){

        System.out.println("\n==========>>> Executing @Before advice ");

    }


}
