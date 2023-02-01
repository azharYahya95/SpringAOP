package com.azharkpi.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LuvAopExpressions {
    // this is where we add all of our related advices for logging
    @Pointcut("execution(* com.azharkpi.aopdemo.dao.*.*(..))")
    public void forDaoPackage(){}

    //create point cut for getter methods
    @Pointcut("execution(* com.azharkpi.aopdemo.dao.*.get*(..))")
    public void getter() {}

    //create pointcut for setter methods
    @Pointcut("execution(* com.azharkpi.aopdemo.dao.*.set*(..))")
    public void setter(){}

    //create point: include package ... exclude getter/setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter(){}

}
