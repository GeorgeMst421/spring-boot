package com.georgemst.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(3)
@Component
public class MyApiAnalyticsAdvice {


    @Before("com.georgemst.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void apiAnalyticsAdvice(){
        System.out.println("==========>>> Executing Api analytics advice");
    }
}
