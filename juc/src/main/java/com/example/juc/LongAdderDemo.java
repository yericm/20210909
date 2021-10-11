package com.example.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author yeric
 * @description: LongAdder是jdk1.8提供的累加器，基于Striped64实现。它常用于状态采集、统计等场景。AtomicLong也可以用于这种场景，但在线程竞争激烈的情况下，LongAdder要比AtomicLong拥有更高的吞吐量，但会耗费更多的内存空间。
 * LongAccumulator和LongAdder类似，也基于Striped64实现。但要比LongAdder更加灵活(要传入一个函数式接口)，LongAdder相当于是LongAccumulator的一种特例。
 * @date 2021/10/11 22:24
 */
public class LongAdderDemo {
    public static void main(String[] args) throws InterruptedException {
        ClickNumberNet clickNumberNet = new ClickNumberNet();
        long startTime;
        long endTime;
        CountDownLatch countDownLatch = new CountDownLatch(50);
        CountDownLatch countDownLatch2 = new CountDownLatch(50);
        CountDownLatch countDownLatch3 = new CountDownLatch(50);
        CountDownLatch countDownLatch4 = new CountDownLatch(50);
        startTime = System.currentTimeMillis();
        for (int i = 1; i <= 50; i++) {
            new Thread(() -> {
                try {
                    for (int j = 1; j <= 100 * 10000; j++) {
                        clickNumberNet.clickBySync();
                    }
                } finally {
                    countDownLatch.countDown();
                }
            }, String.valueOf(i)).start();
        }
        countDownLatch.await();
        endTime = System.currentTimeMillis();
        System.out.println("----costTime: " + (endTime - startTime) + " 毫秒" + "\t clickBySync result: " + clickNumberNet.number);
        startTime = System.currentTimeMillis();
        for (int i = 1; i <= 50; i++) {
            new Thread(() -> {
                try {
                    for (int j = 1; j <= 100 * 10000; j++) {
                        clickNumberNet.clickByAtomicLong();
                    }
                } finally {
                    countDownLatch2.countDown();
                }
            }, String.valueOf(i)).start();
        }
        countDownLatch2.await();
        endTime = System.currentTimeMillis();
        System.out.println("----costTime: " + (endTime - startTime) + " 毫秒" + "\t clickByAtomicLong result: " + clickNumberNet.atomicLong);
        startTime = System.currentTimeMillis();
        for (int i = 1; i <= 50; i++) {
            new Thread(() -> {
                try {
                    for (int j = 1; j <= 100 * 10000; j++) {
                        clickNumberNet.clickByLongAdder();
                    }
                } finally {
                    countDownLatch3.countDown();
                }
            }, String.valueOf(i)).start();
        }
        countDownLatch3.await();
        endTime = System.currentTimeMillis();
        System.out.println("----costTime: " + (endTime - startTime) + " 毫秒" + "\t clickByLongAdder result: " + clickNumberNet.longAdder.sum());
        startTime = System.currentTimeMillis();
        for (int i = 1; i <= 50; i++) {
            new Thread(() -> {
                try {
                    for (int j = 1; j <= 100 * 10000; j++) {
                        clickNumberNet.clickByLongAccumulator();
                    }
                } finally {
                    countDownLatch4.countDown();
                }
            }, String.valueOf(i)).start();
        }
        countDownLatch4.await();
        endTime = System.currentTimeMillis();
        System.out.println("----costTime: " + (endTime - startTime) + " 毫秒" + "\t clickByLongAccumulator result: " + clickNumberNet.longAccumulator.longValue());
    }
}

class ClickNumberNet {
    int number = 0;

    public synchronized void clickBySync() {
        number++;
    }

    AtomicLong atomicLong = new AtomicLong(0);

    public void clickByAtomicLong() {
        atomicLong.incrementAndGet();
    }

    // LongAdder只能用来计算加法，且从零开始计算
    LongAdder longAdder = new LongAdder();

    public void clickByLongAdder() {
        longAdder.increment();
    }

    // LongAccumulator提供了自定义的函数操作
    LongAccumulator longAccumulator = new LongAccumulator((x, y) -> x + y, 0);

    public void clickByLongAccumulator() {
        longAccumulator.accumulate(1);
    }
}