package com.jack.newfeature.java19;

public class SwitchNullWhenTest {
    public static void main(String[] args) {
        String str = "aaaa";
        switch (str) {
            case String i when i.length() > 3 -> System.out.println("the length is greater than 10");
            case "hello" -> System.out.println("hello");
            case "world" -> System.out.println("world");
            case null -> System.out.println("null");
            default -> System.out.println("default");
        }
    }
}
