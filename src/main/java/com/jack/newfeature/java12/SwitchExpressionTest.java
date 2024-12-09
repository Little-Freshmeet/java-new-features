package com.jack.newfeature.java12;

public class SwitchExpressionTest {
    public static void main(String[] args) {
        char c = 'b';

        // don't input break keywork anymore, and can compare with multi values with case.
        switch(c) {
            case 'a' -> System.out.println("a");
            case 'b', 'c' -> System.out.println("b or c");
            default -> System.out.println("default");
        }

        // it can be braced by bracket if there are multi expressions after case
        String season = "spring";
        switch(season) {
            case "spring" -> {
                int count = 10;
                System.out.println("spring" + count);
            }

            case "summer" -> {
                int count = 20;
                System.out.println("summer" + count);
            }

            default -> {
                System.out.println("no count season");
            }
        }

        season = null;
        // it can be used as a return value
        int count = switch(season) {
            case "spring" -> 10;
            case "summer" -> 20;
            case null -> throw new NullPointerException("season is null");
            default -> 0;
        };
        System.out.println(count);
    }
}
