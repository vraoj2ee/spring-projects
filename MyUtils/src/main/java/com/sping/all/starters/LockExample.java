package com.sping.all.starters;

public class LockExample {
    public synchronized void performTask() {
        // Critical section
        System.out.println(Thread.currentThread().getName() + " has acquired the lock.");
        // Perform some work
        try {
            Thread.sleep(1000); // Simulate work
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(Thread.currentThread().getName() + " is releasing the lock.");
    }
}
