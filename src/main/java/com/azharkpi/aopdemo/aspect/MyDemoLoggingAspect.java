package com.azharkpi.aopdemo.aspect;

import com.azharkpi.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(3)
public class MyDemoLoggingAspect {

    @Around("execution(* com.azharkpi.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(
            ProceedingJoinPoint theProceedingJoinPoint
    )throws Throwable{
        // print out ,ethod we are advising on
        String method = theProceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n====>>>> Executing @Around on method: "+method);

        // get begin timestamp
        long begin = System.currentTimeMillis();

        // execute method
        Object result = null;

        try {
            result = theProceedingJoinPoint.proceed();
        }catch (Exception e){
            // log the exception
            System.out.println(e.getMessage());

            //give user a custom message
            /*result = "Major accident! But now worries" +
                    "But dont worry, your private helicropter is on the way";*/
            throw e;
        }

        // get end timestamp
        long end = System.currentTimeMillis();

        // compute duration and display it
        long duration = end - begin;

        System.out.println("\n=====> Duration: "+duration / 1000.0 +" seconds");

        return result;
    }

    @After("execution(* com.azharkpi.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint theJointPoint){
        // print out which method we are advising on
        String method = theJointPoint.getSignature().toShortString();
        System.out.println("\n====>>>> Executing @After (finally) on method: "+method);

    }

    @AfterThrowing(
            pointcut = "execution(* com.azharkpi.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc"
    )
    public void afterThrowingFindAccountsAdvice(
            JoinPoint theJoinPoint, Throwable theExc
    ){
        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n====>>>> Executing @AfterThrowing on method: "+method);

        // log the exception
        System.out.println("\n====>>>> The Exception is: : "+theExc);


    }

    // add a new advice for @AfterReturning on the findAccounts method
    @AfterReturning(
            pointcut = "execution(* com.azharkpi.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public  void afterReturningFindAccountsAdvice(
            JoinPoint theJoinPoint, List<Account> result
    ){
        // print out which method we are adivising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n====>>>> Executing @AfterReturning on method: "+method);

        // print out the results of the method call
        System.out.println("\n=====>>>> result is: "+result);

        // lets post-process the data ... lets modify it :)

        // convert the account names to uppercase
        convertAccountNamesToUpperCase(result);

        System.out.println("\n=====>>>> result is: "+result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        // loop through accounts
        for (Account tempAccount: result){
            // get uppercase version of name
            String theUpperName = tempAccount.getName().toUpperCase();

            // update the name on the account
            tempAccount.setName(theUpperName);
        }

    }

    // lets start with an @Before advice
    @Before("com.azharkpi.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint){
        System.out.println("\n=====>>> Execution @Before advice on addAccount()");

        // display the method signature
        MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();

        System.out.println("Method: "+methodSig);

        //display method arguments

        // get args
        Object[] args = theJoinPoint.getArgs();

        // loop thru args
        for(Object tempArg : args){
            System.out.println(tempArg);

            if(tempArg instanceof Account){
                // downcast and print Account specific stuff
                Account theAccount = (Account) tempArg;

                System.out.println("account name: "+theAccount.getName());
                System.out.println("account level: "+theAccount.getLevel());
            }
        }
    }

}
