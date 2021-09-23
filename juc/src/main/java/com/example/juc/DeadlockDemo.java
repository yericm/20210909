package com.example.juc;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;

/**
 * @author yeric
 * @description: 死锁演示
 * @date 2021/9/17 20:39
 */
public class DeadlockDemo {
    Object obj1 = new Object();
    Object obj2 = new Object();
    RejectedExecutionHandler
    public void method1 () throws InterruptedException {
        synchronized (obj1){
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(300);
            synchronized (obj2){
                System.out.println("尝试获取obj2这个锁对象");
            }
        }
    }
    public void method2 () {
        synchronized (obj2){
            System.out.println(Thread.currentThread().getName());
            synchronized (obj1) {
                System.out.println("尝试获取obj1这个锁对象");
            }
        }
    }
    public static void main(String[] args) {
        DeadlockDemo deadlockDemo = new DeadlockDemo();
        new Thread(()->{
            try {
                deadlockDemo.method1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"a").start();
        new Thread(()->{
            deadlockDemo.method2();
        },"b").start();
    }
}
