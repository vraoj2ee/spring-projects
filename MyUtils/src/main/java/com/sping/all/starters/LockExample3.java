package com.sping.all.starters;

public class LockExample3 {
    private final Object lock = new Object();

    public void performTask() {
        synchronized (lock) {
            // Critical section: only one thread can execute this block at a time
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
}
