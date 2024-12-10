package com.jack.newfeature.java9;

public class PrivateMethodTest {
    public static void main(String[] args) {
        int i = 4, j = 5;
        MyInterface myInterface = new MyClass();
        myInterface.add(i, j);
        myInterface.product(i, j);
    }
}


interface MyInterface {
    private void log(String param) {
        System.out.println("private method in interface: " + param);
    }

    default void add(int i, int j) {
        log("add method in interface");
        System.out.println("i + j = " + (i + j));
    }

    default void product(int i, int j) {
        log("product method in interface");
        System.out.println("i * j = " + (i * j));
    }
}

class MyClass implements MyInterface {

}