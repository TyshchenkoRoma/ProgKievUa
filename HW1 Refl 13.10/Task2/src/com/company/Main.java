package com.company;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws IOException, InvocationTargetException, IllegalAccessException {

        TestConteiner testConteiner = new TestConteiner();
        Class<?> classClass = testConteiner.getClass();

        if (!classClass.isAnnotationPresent(SaveTo.class)) {
            System.out.println("Class is not annotated");
        } else {
            Method[] methods = classClass.getMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(Saver.class)) {
                    SaveTo saveTo = classClass.getAnnotation(SaveTo.class);
                    method.invoke(testConteiner, testConteiner.text, saveTo.PATH());
                } else {
                    System.out.println("method is not annotated");
                }
            }
        }
    }
}
