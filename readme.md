### Aspect-Oriented Programming

#### @AfterThrowing Advice Type

##### Use Cases
- Log the exception
- Perform auditing on the exception
- Notify DevOps team via email or SMS
- Encapsulate this functionality in AOP aspect for easy reuse

##### Code Example

```
import org.aspectj.lang.annotation.AfterThrowing;

@AfterThrowing("execution (* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
public void afterThrowingFindAccountsAdvice(){
      System.out.println("Executing @AfterThrowing advice");
}
```

##### Access the Exception

```
import org.aspectj.lang.annotation.AfterThrowing;

@AfterThrowing(
        pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
        throwing = "theExc"
)
public void afterThrowingFindAccountsAdvice(
      JoinPoint theJoinPoint, throwable theExc){
    // log the exception
    System.out.println("\n=====>>>> The Exception is: "+ theExc);
}
```