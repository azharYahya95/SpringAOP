### Aspect-Oriented Programming

#### Pointcut Declaration
- create a pointcut declaration once and apply it to multiple advices

##### Sample Code

```java
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
    private void forDaoPackage() {
    }

    @Before("forDaoPackage")
    public void beforeAddAccountAdvice(){
        
    }
    
    @Before("forDaoPackage")
    public void performApiAnalytics(){
        
    }
}
```

##### Benefit of Pointcut Declarations
- Easily reuse pointcut expressions
- Update pointcut in one location
- Can also share and combine pointcut expressions (coming up later)

##### Combine Pointcut Expressions
- combine pointcut expressions using logic operators
  - AND (&&)
  - OR (||)
  - NOT (!)
- Example

```
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
private void forDaoPackage(){}

// create pointcut for getter methods
@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
private void getter(){}

// create pointcut for setter methods
@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
private void setter(){}

// combine pointcut: include package ... exclude getter/setter
@Pointcut("forDaoPackage()" && !(getter() || setter()))
private void forDaoPackageNoGetterSetter(){}

@Before("forDaoPackageNoGetterSetter()")
public void beforeAddAccountAdvice(){
//...    
}
```
xw
