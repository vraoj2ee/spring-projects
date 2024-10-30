package com.sping.all.starters;

public class DeadlockExample {
    static class Resource {
        private String name;

        Resource(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    static class ThreadA extends Thread {
        private Resource resource1;
        private Resource resource2;

        ThreadA(Resource resource1, Resource resource2) {
            this.resource1 = resource1;
            this.resource2 = resource2;
        }

        public void run() {
            synchronized (resource1) {
                System.out.println(Thread.currentThread().getName() + " locked " + resource1.getName());
                try { Thread.sleep(100); } catch (InterruptedException e) {}

                synchronized (resource2) {
                    System.out.println(Thread.currentThread().getName() + " locked " + resource2.getName());
                }
            }
        }
    }

    static class ThreadB extends Thread {
        private Resource resource1;
        private Resource resource2;

        ThreadB(Resource resource1, Resource resource2) {
            this.resource1 = resource1;
            this.resource2 = resource2;
        }

        public void run() {
            synchronized (resource2) {
                System.out.println(Thread.currentThread().getName() + " locked " + resource2.getName());
                try { Thread.sleep(100); } catch (InterruptedException e) {}

                synchronized (resource1) {
                    System.out.println(Thread.currentThread().getName() + " locked " + resource1.getName());
                }
            }
        }
    }

    public static void main(String[] args) {
        Resource resource1 = new Resource("Resource 1");
        Resource resource2 = new Resource("Resource 2");

        ThreadA threadA = new ThreadA(resource1, resource2);
        ThreadB threadB = new ThreadB(resource1, resource2);

        threadA.start();
        threadB.start();
    }
}
