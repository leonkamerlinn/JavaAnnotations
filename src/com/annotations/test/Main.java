package com.annotations.test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) {


        classAnntation();
        methodAnnotation();
        //parameterAnnotation();









    }

    private static void classAnntation() {
        Class aClass = TheClass.class;
        Annotation[] annotations = aClass.getAnnotations();

        for(Annotation annotation : annotations){
            if(annotation instanceof MyAnnotation){
                MyAnnotation myAnnotation = (MyAnnotation) annotation;
                System.out.println("name: " + myAnnotation.name());
                System.out.println("value: " + myAnnotation.value());
            }
        }
    }

    private static void methodAnnotation() {
        try {
            Method method = TheClass.class.getMethod("doSomething");
            Annotation[] annotations = method.getDeclaredAnnotations();

            for(Annotation annotation : annotations){
                if(annotation instanceof MyAnnotation){
                    MyAnnotation myAnnotation = (MyAnnotation) annotation;
                    System.out.println("name: " + myAnnotation.name());
                    System.out.println("value: " + myAnnotation.value());
                }
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    private static void parameterAnnotation() {
        try {
            Method method = TheClass.class.getMethod("doSomethingElse");
            Annotation[][] parameterAnnotations = method.getParameterAnnotations();
            Class[] parameterTypes = method.getParameterTypes();

            int i=0;
            for(Annotation[] annotations : parameterAnnotations){
                Class parameterType = parameterTypes[i++];

                for(Annotation annotation : annotations){
                    if(annotation instanceof MyAnnotation){
                        MyAnnotation myAnnotation = (MyAnnotation) annotation;
                        System.out.println("param: " + parameterType.getName());
                        System.out.println("name : " + myAnnotation.name());
                        System.out.println("value: " + myAnnotation.value());
                    }
                }
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    private void fieldAnnotation() {

    }
}
