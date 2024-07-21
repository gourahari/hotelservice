package com.goura.service.hotel.deadlock;

public class DeadLockDemo {
    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();

        Producer producer = new Producer(lock1, lock2);
        Consumer consumer = new Consumer(lock1, lock2);

        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(consumer);

        t1.start();
        t2.start();
    }
}
