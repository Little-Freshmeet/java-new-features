package com.jack.newfeature.java13;

public class SwitchYieldTest {
    public static void main(String[] args) {
        // we also can use traditional switch to return value, but we must use yield keyword
        // and yield contains break.
        int gender = 1;
        String sex = switch(gender) {
            case 1:
                yield "male";
            case 2:
                yield "female";
            default:
                yield "unknown";
        };

        System.out.println(sex);
    }
}
