package com.jack.newfeature.java14;

import com.jack.common.User;

public class InstanceOfTest {
    public static void main(String[] args) {
        User user = new User("jack", 18);
        if (user instanceof Object aaa) {
            System.out.println(aaa);
        }
    }
}
