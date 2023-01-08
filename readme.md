### Aspect-Oriented Programming

#### @Before Advice Type

##### Use Case
- Most common
  - logging, security, transactions
- Audit Logging
  - who, what, when, where
- API Management
  - how many times has a method been called user
  - analytics: what are peak times? what is average load? who is top user?

##### Development Process
- Step 1: Create target object
```java
import org.springframework.stereotype.Component;

@Component
public class AccountDAO{
    public void addAccount(){
        System.out.println("DOING MY DB JOB: Adding an account");
    }
}
```

- Step 2: Create Spring Java Config class
```java
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.luv2code.aopdemo")
public class DemoConfig(){
    
}
```

- Step 3: Create Main app

```java
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args) {
        // read spring config java class
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(DemoConfig.class);

        //get the bean from the spring container
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        
        // call the business method
        accountDAO.addAccount();

        // close the context
        context.close();
    }
}
```

- Step 4: Create an Aspect with @Before advice

```java
import org.springframework.context.annotation.ComponentScan;

@Aspect
@ComponentScan
public class MyDemoLoggingAspect{
    
    @Before("execution(public void addAccount())")
    public void beforeAddAccountAdvice(){
        System.out.println("Executing @Before advice on addAccount()");
    }
}
```
