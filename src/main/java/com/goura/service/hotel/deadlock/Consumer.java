package com.goura.service.hotel.deadlock;

public class Consumer implements Runnable {
    private final Object lock1;
    private final Object lock2;

    public Consumer(Object lock1, Object lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }
    @Override
    public void run() {
        synchronized (lock1) {
            System.out.println("hold lock1.");
            System.out.println("waiting for lock2.");

            synchronized (lock2) {
                System.out.println("hold lock2.");
            }
            System.out.println("released lock2.");
        }
        System.out.println("released lock1.");
    }
}
