package com.georgemst.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(2)
@Component
public class MyCloudLogAsync {

    @Before("com.georgemst.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void cloudLoginAdvice(){
        System.out.println("==========>>> Executing Cloud Log in advice");
    }
}
