package com.azharkpi.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    // this is where we add all of our related advices for logging

    // lets start with an @Before advice
    //@Before("execution(public void addAccount())")
    //@Before("execution(public void com.azharkpi.aopdemo.dao.AccountDAO.addAccount())")
    //@Before("execution(public void add*())")
    //@Before("execution(void add*())")
    //@Before("execution(* add*())")
    //@Before("execution(* add*(com.azharkpi.aopdemo.Account))")
    //@Before("execution(* add*(com.azharkpi.aopdemo.Account, ..))")
    //@Before("execution(* add*(..))")
    @Before("execution(* com.azharkpi.aopdemo.dao.*.*(..))")
    public void beforeAddAccountAdvice(){
        System.out.println("\n=====>>> Execution @Before advice on addAccount()");
    }

}
