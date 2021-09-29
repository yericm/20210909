package com.example.juc;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author yeric
 * @description:
 * @date 2021/9/28 22:12
 */
public class CASdemo {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(1);
        System.out.println(atomicInteger.compareAndSet(1, 2)+ "   "+ atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(1, 3)+ "   "+ atomicInteger.get());
    }
}
