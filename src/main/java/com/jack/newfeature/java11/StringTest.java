package com.jack.newfeature.java11;

import java.util.stream.Collectors;

public class StringTest {

    public static void main(String[] args) {
        String str = "Hello, ";
        System.out.println(str.repeat(3));

        System.out.println("\n".isBlank());

        String lines = """
                aaa
                bbb
                ccc
                """;
        System.out.println(lines.lines().collect(Collectors.toList()));

        String s = "   Hello, World!\n\n";
        System.out.println(s.strip());
        System.out.println(s.stripLeading());
        System.out.println(s.stripTrailing());
    }
}
