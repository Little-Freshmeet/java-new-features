package com.jack.newfeature.java14;

public class RecordConstructorTest {
    public static void main(String[] args) {
        Person person = new Person("jack", 12);
    }
}

record Person(String name, int age) {
    // define the constructor which has the same params, it doesn't need to write () behind the name
    public Person {

        // it will omit this.name = name and this.age = age, but actually it will do it
        if (age > 10) {
            System.out.println("age is too big");
        }
    }


    public Person(String name, int age, int gender) {
        // must invoke the default constructor directly or indirectly
        this(name, age);
        System.out.println("gender is " + gender);
    }

    public Person(String name, int age, int gender, String address) {
        // invoke the default constructor indirectly
        this(name, age, gender);
    }
}
