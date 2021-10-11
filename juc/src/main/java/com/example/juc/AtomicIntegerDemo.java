package com.example.juc;

import javax.lang.model.element.VariableElement;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @author yeric
 * @description:
 * @date 2021/9/29 22:12
 */
public class AtomicIntegerDemo {
    static AtomicInteger atomicInteger = new AtomicInteger();
    private static int size = 50;

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(size);
        for (int i = 0; i < size; i++) {
            new Thread(()->{
                try {
                    for (int j = 0; j < 1000; j++) {
                        atomicInteger.incrementAndGet();
                    }
                } catch (Exception e) {

                }finally {
                    countDownLatch.countDown();
                }
            },String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println(atomicInteger.get());
    }
}
