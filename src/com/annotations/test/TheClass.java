package com.annotations.test;
@MyAnnotation(name="Class Type",  value = "Hello World")
public class TheClass {

    @MyAnnotation(name="Field Type",  value = "Hello World")
    public String myField = null;

    @MyAnnotation(name="Method Type",  value = "Hello World")
    public void doSomething(){}

    public static void doSomethingElse(
            @MyAnnotation(name="Parameter Type", value="aValue") String parameter){
    }
}
