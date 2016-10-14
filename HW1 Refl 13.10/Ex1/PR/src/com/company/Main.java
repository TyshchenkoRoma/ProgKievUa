package com.company;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
public class Main {
    
//    1. Создать аннотацию, которая принимает параметры для метода. Написать код, который вызовет метод,
//    помеченный этой аннотацией, и передаст параметры аннотации в вызываемый метод.
//    @Test(a=2, b=5)
//    public void test(int a, int b) {…}

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Class<?> classClass = MyClass.class;
        Method[] methods = classClass.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(MyAnotation.class)) {
                MyClass myClass = new MyClass();
                MyAnotation myAnnotationEx1 = method.getAnnotation(MyAnotation.class);
                method.invoke(myClass, myAnnotationEx1.par1(), myAnnotationEx1.par2());
            }
        }
    }
}
