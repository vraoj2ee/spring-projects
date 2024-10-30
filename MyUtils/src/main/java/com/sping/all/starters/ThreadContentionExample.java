package com.sping.all.starters;

public class ThreadContentionExample {
    private static int count = 0;

    public synchronized void increment() {
        count++;
    }

    public static void main(String[] args) {
        ThreadContentionExample example = new ThreadContentionExample();

        Runnable task = () -> {
            for (int i = 0; i < 10000; i++) {
                example.increment();
            }
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final count: " + count);
    }
}
