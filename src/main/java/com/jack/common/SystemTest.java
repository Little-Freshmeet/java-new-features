package com.jack.common;

public class SystemTest {
    public static void main(String[] args) {
        System.out.println(System.getProperty("java.version"));
        System.out.println(System.getenv("JAVA_HOME"));
        System.out.println(System.getProperty("user.dir"));
    }
}
