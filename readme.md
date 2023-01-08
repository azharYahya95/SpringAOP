### Aspect-Oriented Programming

#### AOP Pointcut Expression

##### Pointcut Expression Language
- Spring AOP uses AspectJ's pointcut expression language
- We will start with execution pointcuts
  - Applies to execution of methods
```
execution(modifiers-pattern? return-type-pattern declaring-type-pattern?
          method-name-pattern(param-pattern) throws-pattern?)
```
- The pattern is option if has '?'

##### Pointcut Expression Examples
1. Example 1: Match on method names
- Match only addAccount() method in AccountDAO class
```
@Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount())")
```
|example|Type|
|---|---|
|public|modifer|
|void|Return Type|
|com.luv2code.aopdemo.dao.AccountDAO|Declaring Type|
|addAccount()|Method|

2. Example2: Match on Method Names
- Match any addAccount() method in any class
```
@Before("execution(public void addAccount())")
```
|example|Type|
|---|---|
|public|Modifier|
|void|Return Type|
|addAccount()|Method|

3. Example 3: Match on method names (using wildcards)
- match methods starting with add in any class
```
@Before("execution(public void add*())")
```
|example|Type|
|---|---|
|public|Modifier|
|void|Return Type|
|add*|Method|

4. Example 4: Match on method names (using wildcards)
- Match methods starting with processCreditCard in any class
```
@Before("execution(public VerificationResult processCreditCard*())")
```
|example|Type|
|---|---|
|public|Modifier|
|VerificationResult|Return Type|
|processCreditCard*()|Method|

5. Example 5: use wildcards on return type
```
@Before("execution(public * processCreditCard*())")
```
|example|Type|
|---|---|
|public|Modifier|
|*|Return type|
|processCreditCard*()|Method|

6. Example 6: Modifier is Optional
```
@Before(""* processCreditCard*())
```

