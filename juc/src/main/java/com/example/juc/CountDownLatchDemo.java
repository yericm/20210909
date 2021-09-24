package com.example.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author yeric
 * @description:
 * @date 2021/9/23 15:11
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch count = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                try {
                    System.out.println(Thread.currentThread().getName());
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count.countDown();
            },"线程名称-"+i).start();
        }
        System.out.println("等待CountDownLatch执行。。。。");
        count.await();
        System.out.println("CountDownLatch执行完成了，继续执行主线程");
    }
}
