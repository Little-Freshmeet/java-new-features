package com.jack.newfeature.java15;

public class SealedClassTest {
    public static void main(String[] args) {

    }
}

/**
 * 如果子类与父类是在同一个源文件中，可以是内部类，也可以不是，就可不用写permits关键字及后面的子类名.
 * 也就是说不写permits关键字，默认就只允许同一个源文件中的类来继承，外部的类是不允许继承的。
 */
sealed class Shape {

}

/**
 * sealed class的子类必须是final, sealed, non-sealed
 */
final class Circle extends Shape {

}

final class Triangle extends Shape {

}