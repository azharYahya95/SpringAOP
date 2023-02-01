package com.azharkpi.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    // this is where we add all of our related advices for logging

    @Pointcut("execution(* com.azharkpi.aopdemo.dao.*.*(..))")
    private void forDaoPackage(){}

    //create point cut for getter methods
    @Pointcut("execution(* com.azharkpi.aopdemo.dao.*.get*(..))")
    private void getter() {}

    //create pointcut for setter methods
    @Pointcut("execution(* com.azharkpi.aopdemo.dao.*.set*(..))")
    private void setter(){}

    //create point: include package ... exclude getter/setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    private void forDaoPackageNoGetterSetter(){}


    // lets start with an @Before advice
    @Before("forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(){
        System.out.println("\n=====>>> Execution @Before advice on addAccount()");
    }

    @Before("forDaoPackageNoGetterSetter()")
    public void performApiAnalytics(){
        System.out.println("\n=====>> Perform API analytics");
    }
}
