package com.jack.newfeature.java21;

import java.util.Date;

public class StringTemplateTest {
    public static void main(String[] args) {
        String name = "Bob";
        int age = 25;
        Date now = new Date();
        String template = "姓名：%s, 年龄：%s, 当前时间：%s";
//        String result = template.replace("${name}", name).replace("${age}", String.valueOf(age)).replace("${now}", now.toString());
        String result = template.formatted(name, age, now);
        // if they're same between vars in string and real var, you can use the following syntax
//        String result2 = introduction.formatted(name, age, now);

        System.out.println(result);
    }
}
