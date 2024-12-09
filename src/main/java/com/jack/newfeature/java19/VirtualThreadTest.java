package com.jack.newfeature.java19;

public class VirtualThreadTest {
    public static void main(String[] args) {
        // Create a virtual thread
        Thread virtualThread = Thread.ofVirtual().start(() -> {
            System.out.println("Hello from virtual thread!");
        });

        try {
            virtualThread.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Create multiple virtual threads
        for (int i = 0; i < 10; i++) {
            Thread.ofVirtual().start(() -> {
                System.out.println("Running virtual thread: " + Thread.currentThread());
            });
        }
    }
}
