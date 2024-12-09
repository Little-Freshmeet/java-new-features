package com.jack.newfeature.java10;

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
        Optional.empty().orElseThrow();
    }
}
