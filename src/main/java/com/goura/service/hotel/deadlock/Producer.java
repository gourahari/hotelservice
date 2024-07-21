package com.goura.service.hotel.deadlock;

public class Producer implements Runnable {
    private final Object lock1;
    private final Object lock2;

    public Producer(Object lock1, Object lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }
    @Override
    public void run() {
        synchronized (lock2) {
            System.out.println("hold lock2.");
            System.out.println("waiting for lock1.");

            synchronized (lock1) {
                System.out.println("hold lock1.");
            }
            System.out.println("released lock1.");
        }
        System.out.println("released lock2.");
    }
}
