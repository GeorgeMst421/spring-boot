package com.georgemst.aopdemo.aspect;

import com.georgemst.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(1)
@Component
public class MyDemoLoggingAspect {

//    this is where we add all of our related advices for logging

//    let's start with a @Before advice

//    @Before("execution(void addAccount())")

//    @Before("execution(void add*())")

//    @Before("execution(* add*())")

//    @Before("execution(* add*(com.georgemst.aopdemo.Account))")

//    @Before("execution(* add*(com.georgemst.aopdemo.Account, ..))")

//    @Before("execution(* add*(..))")
    

    @Before("com.georgemst.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint){
        System.out.println("==========>>> Executing Adding account advice ");

        // display the method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println(methodSignature);

        // display method arguments
        Object[] args = joinPoint.getArgs();
        for(Object arg: args){
            System.out.println(arg);

            if(arg instanceof Account account){ // instant casting

                // downcast and print accoutn specs

                System.out.println("Name: "+ account.getName());
                System.out.println("Level: "+account.getLevel());
            }
        }


    }




}
