package com.company;

public class MyClass {

    @MyAnotation(par1 = 1, par2 = 3)
    public void MyMethod(int par1, int par2) {
        System.out.println("Print from method " + par1 + "," + par2);
    }
}

