package com.jack.newfeature.java17;

public class SwitchPatternMatchingTest {
    public static void main(String[] args) {
        Object obj = "123";
        switch (obj) {
            case Integer i -> System.out.println("Integer: " + i);
            case String s -> System.out.println("String: " + s);
            default -> System.out.println("Unknown");
        }
    }
}
