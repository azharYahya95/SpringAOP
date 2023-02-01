package com.azharkpi.aopdemo;

import com.azharkpi.aopdemo.dao.AccountDAO;
import com.azharkpi.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

    public static void main(String[] args) {
        // read spring config java class
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

        //call the business method
        theAccountDAO.addAccount(new Account(), true);

        theAccountDAO.doWork();

        // get Membership bean from spring container
        MembershipDAO theMembershipDAO =
                context.getBean("membershipDAO", MembershipDAO.class);

        //call the membershuo busineess method
        theMembershipDAO.addMembership();

        theMembershipDAO.goToSleep();

        //close the context
        context.close();
    }
}
