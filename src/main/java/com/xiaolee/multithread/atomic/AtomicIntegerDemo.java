package com.xiaolee.multithread.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo {
    private static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) {
        Thread thread1 = new Thread(()->{
            for (int i=0; i< 1000000; i++) {
                add();
            }
        });

        Thread thread2 = new Thread(()->{
            for (int i=0; i< 1000000; i++) {
                add();
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(count.get());
    }

    private static void add() {
        count.incrementAndGet();
    }
}
