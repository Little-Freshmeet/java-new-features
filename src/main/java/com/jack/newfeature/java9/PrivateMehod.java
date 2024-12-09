package com.jack.newfeature.java9;

public interface PrivateMehod {

    default void method() {
        System.out.println("default method");
        complexMethod();
    }

    private void complexMethod() {
        System.out.println("private method");
    }
}


class PrivateMehodImpl implements PrivateMehod {
    public static void main(String[] args) {
        PrivateMehod privateMehod = new PrivateMehodImpl();
        privateMehod.method();
    }
}