### Aspect-Oriented Programming

#### Overview
##### Benefits of AOP
  - Code for Aspect is defined in Single class
    - Much better than being scattered everywhere
    - promotes code reuse and easier to change
  - Business code in your application is cleaner
    - Only apply to business functionality: addAccount
    - Reduces code complexity
  - Configurable
    - Based on Configurable, apply Aspects selectively to different parts of app
    - No need to make change to main application code ... very important
##### Additional AOP use cases
  - Most common
    - logging, security, transactions
  - Audit logging
    - who, what, when, where
  - Exception Handling
    - log exception, and notify DevOps teams via SMS/email
  - API management
    - home many times has a method being called user
    - analytics: what are peak times? what is average load? who is top user?
##### Advantages and Disadvantages

|Advantages|Disadvantages|
|---|---|
|Reusable Modules|Too Many aspects and app flow is hard to follow|
|Resolve code tangling|Minor Performance cost for aspect execution (run-time weaving)|
|Resolve code scatter||
|Applied selectively based on configuration||

##### AOP Terminology

|||
|---|---|
|Aspect|module of core for a cross-cutting concern(logging, security)|
|Advice|What action is taken and when it should be applied|
|Join Point|When to apply code during program execution|
|pointcut|A predicate expression for where advice should be applied|

##### Advice Types

| Types                  | Explanation                                |
|------------------------|--------------------------------------------|
| Before Advice          | run before the method                      |
| After Finally Advice   | run after the method (finally)             |
| After Returning Advice | run after the method (Success Execution)   |
| After Throwing Advice  | run after the method (if exception thrown) |
| Around Advice          | run before and after method                |

##### Weaving

- Connecting aspect to target object to create an advised object
- Types of weaving
  - Compile-time, load-time and run-time
- Regarding performance: run-time weaving is the slowest

##### AOP Framework
1. Spring AOP
2. AspectJ

##### Spring AOP support
- Spring provides AOP support
- Key component of Spring
  - Security, transactions, caching etc
- Use Runtime weaving of aspects

##### AspectJ
- Original AOP framework
- provide complete support of AOP
- Rich support for 
  - join points: method-level, constructor field
  - code weaving: compile-time, post compile-time and load time

##### Spring AOP Disadvantages and Advantages

| Advantages                                          | Disadvantages                                                  |
|-----------------------------------------------------|----------------------------------------------------------------|
| Simpler to use than AspectJ                         | Only support method-level join points                          |
| Use Proxy Pattern                                   | Can only apply aspect to beans created by Spring app context   |
| Can migrate to AspectJ when using @Aspect annotaion | Minor performance cost for Aspect execution (run-time weaving) |

##### AspectJ Disadvantages and Advantages
| Advantages                                               | Disadvantages                                                  |
|----------------------------------------------------------|----------------------------------------------------------------|
| Support all join points (method, constuctor, field)      |Compile-time weaving require extra compilation step|
| works with any POJO not just beans from app context      |AspectJ pointcut syntax can become complex|
| Faster performance than Spring AOP                       ||
| Complete AOP support                                     ||
| Weaving (compile-time, post compile-time, and load-time) ||


