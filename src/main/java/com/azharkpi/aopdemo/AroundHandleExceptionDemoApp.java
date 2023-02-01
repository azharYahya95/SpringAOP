package com.azharkpi.aopdemo;

import com.azharkpi.aopdemo.service.TrafficFortuneService;
import com.azharkpi.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AroundHandleExceptionDemoApp {

    public static void main(String[] args) {
        // read spring config java class
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        TrafficFortuneService theFortuneService
                = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        System.out.println("\n Main Program: AroundDemoApp");

        System.out.println("Calling getFortune");

        boolean tripWire = true;
        String data = theFortuneService.getFortune(tripWire);

        System.out.println("\nMy Fortune is: "+data);

        System.out.println("Finished");
        //close the context
        context.close();
    }
}
