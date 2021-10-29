package com.example.juc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author yeric
 * @description:ReentrantLock和ReentrantReadWriteLock的区别演示
 * @date 2021/10/22 07:53
 */
public class ReentrantReadWriteLockDemo {
    private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    private ReentrantLock lock = new ReentrantLock();

    Map<String, String> map = new HashMap<>();

    public void reentrantLockWriteMap() throws InterruptedException {
        lock.lock();
        try {
            System.out.println("当前线程是：" + Thread.currentThread().getName() + "开始写。。。");
            Thread.sleep(10);
            map.put("key:" + Thread.currentThread().getName(), "value:" + Thread.currentThread().getName());
            System.out.println("当前线程是：" + Thread.currentThread().getName() + "写完了。。。");
        } finally {
            lock.unlock();
        }
    }

    public void reentrantLockReadMap(Map<String, String> map) {
        lock.lock();
        try {
            System.out.println("当前线程是：" + Thread.currentThread().getName() + "开始读");
            try {
                Thread.sleep(10);
                System.out.println("当前线程是：" + Thread.currentThread().getName() + "读完了");
            } catch (InterruptedException e) {

            }
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantReadWriteLockDemo lockDemo = new ReentrantReadWriteLockDemo();
        /**
         * ReentrantLock锁演示：无论读写都同时只有一个线程可以操作
         */
//        lockDemo.reentrantLockDemo(lockDemo);
        // 注意看下两个方法的最终结果，读线程的区别
        /**
         * ReentrantReadWriteLock锁演示：写时只能一个线程进行，读时可以多个线程
         */
        lockDemo.reentrantReadWriteLockDemo(lockDemo);
    }

    public void writeMap() throws InterruptedException {
        reentrantReadWriteLock.writeLock().lock();
        try {
            System.out.println("当前线程是：" + Thread.currentThread().getName() + "开始写。。。");
            Thread.sleep(10);
            map.put("key:" + Thread.currentThread().getName(), "value:" + Thread.currentThread().getName());
            System.out.println("当前线程是：" + Thread.currentThread().getName() + "写完了。。。");
        } finally {
            reentrantReadWriteLock.writeLock().unlock();
        }
        System.out.println("map.size is "+map.size());
    }

    public void readMap(Map<String, String> map) {
        reentrantReadWriteLock.readLock().lock();
        try {
            System.out.println("当前线程是：" + Thread.currentThread().getName() + "开始读");
            try {
                Thread.sleep(1);
                System.out.println("当前线程是：" + Thread.currentThread().getName() + "读完了");
            } catch (InterruptedException e) {

            }
        } finally {
            reentrantReadWriteLock.readLock().lock();
        }
    }

    public void reentrantLockDemo(ReentrantReadWriteLockDemo lockDemo) throws InterruptedException {
        for (int i = 1; i <= 10; i++) {
            new Thread(() -> {
                try {
                    lockDemo.reentrantLockWriteMap();
                } catch (InterruptedException e) {

                }
            }, String.valueOf(i)).start();
        }
        Thread.sleep(2000);
        for (int i = 1; i <= 10; i++) {
            new Thread(() -> {
                lockDemo.reentrantLockReadMap(lockDemo.map);
            }, String.valueOf(i)).start();
        }
    }

    public void reentrantReadWriteLockDemo(ReentrantReadWriteLockDemo lockDemo) throws InterruptedException {
        for (int i = 1; i <= 10; i++) {
            new Thread(() -> {
                try {
                    lockDemo.writeMap();
                } catch (InterruptedException e) {

                }
            }, String.valueOf(i)).start();
        }
        Thread.sleep(2000);
        for (int i = 1; i <= 10; i++) {
            new Thread(() -> {
                lockDemo.readMap(lockDemo.map);
            }, String.valueOf(i)).start();
        }
    }
}
