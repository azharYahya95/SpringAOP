package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

    public static void main(String[] args) {
        // read spring config java class
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

        //call the business method
        theAccountDAO.addAccount();

        // do it again
        System.out.println("\n lets call it again!");

        //call the business method again
        theAccountDAO.addAccount();

        //close the context
        context.close();
    }
}
