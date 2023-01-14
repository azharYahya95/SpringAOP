### Aspect-Oriented Programming

#### @AfterReturning Advice Type

##### Use Cases
- Most Common
  - logging, security, transactions
- Audit logging
  - who, what, when, where
- Post-processing Data
  - Post process the data before returning to caller

##### code example

```
@AfterReturning("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
public void afterReturningFindAccountsAdvice(){
  System.out.println("Executing @AfterReturning advice");
}
```

##### code Example (Access the return Value)

```
import org.aspectj.lang.annotation.AfterReturning;

@AfterReturning(
        pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
        returning = "result"
)
public void afterRturningFindAccountsAdvice(
        JoinPoint theJoinPoint, List<Account> result){
    System.out.println("\n=====>>> result is: "+result);
}

```