package com.sping.all.starters;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample2 {
    private final Lock lock = new ReentrantLock();

    public void performTask() {
        lock.lock(); // Acquire the lock
        try {
            // Critical section
            System.out.println(Thread.currentThread().getName() + " has acquired the lock.");
            // Perform some work
            try {
                Thread.sleep(1000); // Simulate work
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        } finally {
            lock.unlock(); // Always release the lock in a finally block
            System.out.println(Thread.currentThread().getName() + " is releasing the lock.");
        }
    }
}
