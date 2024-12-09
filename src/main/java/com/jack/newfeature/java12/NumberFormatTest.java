package com.jack.newfeature.java12;

import java.text.NumberFormat;
import java.text.NumberFormat.Style;
import java.util.Locale;

public class NumberFormatTest {
    public static void main(String[] args) {
        NumberFormat numberFormat1 = NumberFormat.getCompactNumberInstance(Locale.CHINESE, Style.SHORT);
        System.out.println(numberFormat1.format(1000));
        System.out.println(numberFormat1.format(100000));
        System.out.println(numberFormat1.format(1000000));

        NumberFormat numberFormat4 = NumberFormat.getCompactNumberInstance(Locale.CHINESE, Style.LONG);
        System.out.println(numberFormat1.format(1000));
        System.out.println(numberFormat1.format(100000));
        System.out.println(numberFormat1.format(1000000));

        NumberFormat numberFormat2 = NumberFormat.getCompactNumberInstance(Locale.US, Style.SHORT);
        System.out.println(numberFormat2.format(1000));
        System.out.println(numberFormat2.format(100000));
        System.out.println(numberFormat2.format(1000000000));

        NumberFormat numberFormat3 = NumberFormat.getCompactNumberInstance(Locale.US, Style.LONG);
        System.out.println(numberFormat3.format(1000));
        System.out.println(numberFormat2.format(100000));
    }
}
