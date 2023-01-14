### Aspect-Oriented Programming

#### joinPoints

##### Problem
- How we can access method parameter when we are in aspect?

##### Step by Step Development Process
1. Access and display Method Signature
</br>*Java file*
```
@Before("...")
public void beforeAddAccountAdvice(JoinPoint theJointPoint){
    //display the method signature
    MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
    
    System.out.println("Method: "+ methodSig);
}
```
</br>*Output*
```
Method: void com.luv2code.aopdemo.dao.AccountDAO.addAccount(Account,boolean)
```

2. Access and display Method Arguments
</br>*Java file*
```
@Before("...")
public void beforeAddAccountAdvice(JoinPoint theJoinPoint){
  // display method arguments
  
  //get args
  Object[] args = theJoinPoint.getArgs();
  
  // loop thru args 
  for(Object tempArgs: args){
    System.out.println(tempArgs);
  }
}
```
</br>*Output*
```
com.luv2code.aopdemo.Account@1ce24091

true
```