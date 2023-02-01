package com.azharkpi.aopdemo;

import com.azharkpi.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterReturningDemoApp {

    public static void main(String[] args) {
        // read spring config java class
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

        // call method to find the accounts
        List<Account> theAccounts = theAccountDAO.findAccounts();

        // display the Accounts
        System.out.println("\n\n Main Program: AfterReturningDemoApp");
        System.out.println("---");

        System.out.println(theAccounts);

        //close the context
        context.close();
    }
}
