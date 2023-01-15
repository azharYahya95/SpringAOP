### Aspect-Oriented Programming

#### @After Advice Type
- it work just like finally block
- will run either failure or success

##### Use Cases
- Log the exception and/or perform auditing
- Code to run regardless of method outcome
- Encapsulate this functionality in AOP aspect for easy reuse

##### Code Example

```
import org.aspectj.lang.annotation.After;

@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
public void afterFinallyFindAccountsAdvice(){
    System.out.println("Executing @After (finally) advice");
}
```

##### Tips
- The @After advice does not have access to the exception
  - if you need exception, then use @AfterThrowing advice

- The @After advice should be able to run in the case of success or error
  - Your code should not depend on happy path or an exception
  - Logging / auditing is the easiest case here

