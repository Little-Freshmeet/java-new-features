package com.jack.newfeature.java16;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnsafeDemo {
    public static void main(String[] args) throws Exception {
        // Accessing Unsafe
        Field unsafeField = Unsafe.class.getDeclaredField("theUnsafe");
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);

        // Allocating memory directly
        long memoryAddress = unsafe.allocateMemory(8L);
        unsafe.putLong(memoryAddress, 42L);
        System.out.println("Value at memory address: " + unsafe.getLong(memoryAddress));
        unsafe.freeMemory(memoryAddress);
    }
}
