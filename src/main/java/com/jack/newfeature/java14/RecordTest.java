package com.jack.newfeature.java14;

public class RecordTest {
    public static void main(String[] args) {
        User user = new User("jack", 18);
        System.out.println(user.name() + "," + user.age());
    }
}

record User(String name, int age) {

}