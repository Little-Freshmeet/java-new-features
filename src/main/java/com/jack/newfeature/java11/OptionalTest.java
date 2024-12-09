package com.jack.newfeature.java11;

import java.util.Optional;

/**
 * the following methods are provided in java9
 * ifPresentOrElse
 * or
 * stream
 *
 * the following methods are provided in java10
 * orElseThrow(), not orElseThrow(Supplier<? extends X> exceptionSupplier)
 *
 * the following methods are provided in java11
 * isEmpty
 *
 * no new methods have been provided since java12
 */
public class OptionalTest {
    public static void main(String[] args) {
        Optional<String> optional = Optional.empty();
        if (optional.isEmpty()) {
            System.out.println("empty value");
        }
    }
}
