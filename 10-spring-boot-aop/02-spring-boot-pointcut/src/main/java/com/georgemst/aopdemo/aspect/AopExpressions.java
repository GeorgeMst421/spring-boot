package com.georgemst.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect // optional if the class has only pointcut expressions
public class AopExpressions {

    @Pointcut("execution(* com.georgemst.aopdemo.dao.*.*(..))")
    public void forDaoPackage(){}

    @Pointcut("execution(* com.georgemst.aopdemo.dao.*.get*(..))")
    public void getter(){}

    @Pointcut("execution(* com.georgemst.aopdemo.dao.*.set*(..))")
    public void setter(){}

    @Pointcut("forDaoPackage() && !(setter() || getter()))")
    public void forDaoPackageNoGetterSetter(){}




}
