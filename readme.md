### Aspect-Oriented Programming

#### Ordering Aspects

##### Overview
1. To Control Order
- Refactor: Place advices in separate Aspects
- Control order on Aspects using @Order annotation
- Guarantees order of when Aspects are applied

2. Development Process
- Refactor: Place advices in separate Aspects
- Control order on Aspects using @Order annotation

3. Code Example

```java
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAspect {
    
}
```

```java
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyLoggingDemoAspect{
    
}
```

```java
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAspect {
    
}
```

4. @Order annotation
- Lower numbers have higher precedence
  - Range: Integer.MIN_VALUE tp Integer.MAX_VALUE
  - Negative numbers are allowed
  - Does not have to be consecutive

