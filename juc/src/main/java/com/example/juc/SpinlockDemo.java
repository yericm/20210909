package com.example.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author yeric
 * @description: 利用cas自制自旋锁
 * @date 2021/9/28 22:34
 */
public class SpinlockDemo {
    AtomicReference<Thread> atomicReference = new AtomicReference();
    public void lock () {
        System.out.println(Thread.currentThread().getName()+"进来了");
        while (!atomicReference.compareAndSet(null, Thread.currentThread())) {
        }
        System.out.println(Thread.currentThread().getName()+"抢到锁了");
    }
    public void unLock () {
        atomicReference.compareAndSet(Thread.currentThread(), null);
        System.out.println(Thread.currentThread().getName()+"开始释放锁");
    }

    public static void main(String[] args) throws InterruptedException {
        SpinlockDemo spinlockDemo = new SpinlockDemo();
        new Thread(()->{
            spinlockDemo.lock();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {

            }
            spinlockDemo.unLock();
        },"t1").start();
        TimeUnit.SECONDS.sleep(2);
        new Thread(()->{
            spinlockDemo.lock();
            spinlockDemo.unLock();
        },"t2").start();
    }
}
