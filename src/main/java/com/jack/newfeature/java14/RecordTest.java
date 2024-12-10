package com.jack.newfeature.java14;

public class RecordTest {
    public static void main(String[] args) {
        User user = new User("jack", 18);
        System.out.println(user.name() + "," + user.age());
    }
}

record User(String name, int age) {

}

// inner record class must be static by default, so we can't use non-static field in inner record class
class Outer {
    int out;
    record Inner(String name) {
        // there will be a compile error.
        public void test() {
            System.out.println(out);
        }
    }
}