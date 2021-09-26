package com.example.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yeric
 * @description:
 * @date 2021/9/26 21:20
 */
public class LockSupportDemo {
    public static void main(String[] args) throws InterruptedException {
//        waitNotify();
//        awaitSignal();
        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "启动了");
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + "被唤醒了");
        }, "t1");
        t1.start();

        Thread t2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "启动了");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {

            }
            LockSupport.unpark(t1);
            System.out.println(Thread.currentThread().getName() + "开始唤醒其它指定线程");
        }, "t2");
        t2.start();
    }

    private static void awaitSignal() {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {

            }
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "启动了");
            try {
                condition.await();
            } catch (InterruptedException e) {

            }
            System.out.println(Thread.currentThread().getName()+"被唤醒了");
            lock.unlock();
        },"t1").start();

        new Thread(()->{
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "启动了");

            condition.signal();
            System.out.println(Thread.currentThread().getName()+"开始唤醒其它线程");
            lock.unlock();
        },"t2").start();
    }

    private static void waitNotify() {
        Object obj = new Object();
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {

            }
            synchronized (obj) {
                try {
                    System.out.println(Thread.currentThread().getName() + "启动了");
                    obj.wait();
                    System.out.println(Thread.currentThread().getName()+"被唤醒");
                } catch (InterruptedException e) {

                }
            }
        }, "线程一").start();
        new Thread(() -> {
            synchronized (obj) {
                System.out.println(Thread.currentThread().getName() + "启动了");
                obj.notify();
                System.out.println(Thread.currentThread().getName()+"开始唤醒其它线程");
            }
        }, "线程二").start();
    }
}
