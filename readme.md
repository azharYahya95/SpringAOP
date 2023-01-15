### Aspect-Oriented Programming

#### @Around Advice Type
- execute code before we make method call and can get result after method is complete
- it like combination of @Before and @After

##### Use Cases
- Most common: logging, auditing, security
- Pre-processing and post-processing data
- Instrumentation / profiling code
  - How long does it take for a section of code to run?
- Managing exceptions
  - Swallow / handle / stop exceptions

##### ProceedingJoinPoint
- When using @Around advice
  - You will get a reference to a "proceeding join point"
- This is a handle to the target method
- your code can use the proceeding join point to execute target method

##### code example

```
import org.aspectj.lang.annotation.Around;

@Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
public Object afterGetFortune(
    ProceedingJoinPoint theProceedingJoinPoint) throws Throwable{
    // get begin timestamp
    long begin = System.currentTimeMillis();
    
    //execute the method
    Object result = theProceedingJoinPoint.proceed();
    
    // get end timestamp
    long end = System.currentTimeMillis();
    
    // compute duration and display it
    long duration = end - begin;
    System.out.println("\n====> Duration: "+ duration +" milliseconds");
    
    return result;
}
```

##### Code Example (Handling Exception)

```
import org.aspectj.lang.annotation.Around;

@Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
public Object afterGetFortune(
        ProceedingJoinPoint theProceedingJoinPoint)throws Throwable{
    Object result = null;
    
    try{
      // lets execute the method
      result = theProceedingJoinPoint.proceed();
      
    }catch (Exception exc){
      // log exception
      System.out.println("@Around advice: We have a problem "+exc);
      
      // handle and give default fortune ... use this approach with caution
      result = "Nothing exciting here. Move along!";
    }
  return result;
}
```