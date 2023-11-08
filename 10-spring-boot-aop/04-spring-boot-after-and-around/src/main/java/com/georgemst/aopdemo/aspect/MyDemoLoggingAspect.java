package com.georgemst.aopdemo.aspect;

import com.georgemst.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

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



    // add new advice for @AfterReturning on the findAccounts()
    @AfterReturning(
            pointcut = "execution(* com.georgemst.aopdemo.dao.AccountDao.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result){

        // print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("=======>>> Executing @AfterReturing on method: " + method);

        // print out the results of the method call
        System.out.println("=======>>> Result is: " + result );

        // let's post process the data
        // convert the account names to uppercase
        for(Account account: result) {

            // get the uppercase version of the name
            String upperName = account.getName().toUpperCase();

            // update the name on the account
            account.setName(upperName);
        }

        System.out.println("=======>>> Result after modification is: " + result );

    }

    @AfterThrowing(
            pointcut = "execution(* com.georgemst.aopdemo.dao.AccountDao.findAccounts(..))",
            throwing = "theExc"
    )
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable theExc){

        // point out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("=======>>> Executing @AfterThrowing on method: " + method);

        // log the exception
        System.out.println("=======>>> Exception is: " + theExc );

    }

    @After("execution(* com.georgemst.aopdemo.dao.AccountDao.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint){

        // point out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("=======>>> Executing @After (finally) on method: " + method);

    }

    // AROUND ADVICE
    @Around("execution(* com.georgemst.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{

        // print out method we are advising
        String method = proceedingJoinPoint.getSignature().toShortString();
        System.out.println("=======>>> Executing @Around on method: " + method);

        // get begin timestamp
        long begin = System.currentTimeMillis();

        // now let's execute the method
        Object result = proceedingJoinPoint.proceed();

        // get end timestamp
        long end = System.currentTimeMillis();

        // compute duration and display it
        long duration = end - begin;
        System.out.println("========>Duration: "+duration / 1000.0 +" seconds");

        return result;
    }


}
