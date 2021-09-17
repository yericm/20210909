package com.example.juc;

import java.util.concurrent.TimeUnit;

/**
 * @author yeric
 * @description:
 * @date 2021/9/16 22:20
 */
class Phone {
    public synchronized void sendEmail (){
        try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println("发送email");
    }
    public void sendSms () {
        synchronized (this){
            System.out.println("发送sms");
        }
    }

    public void noLock() {
        System.out.println("普通方法，没有加锁");
    }
}
public class SynchronizedDemo {
    public static void main(String[] args) {
        Phone phone1 = new Phone();
        Phone phone2 = new Phone();
        // 1. 同一个对象同时访问两个同步方法(两个方法都加synchronized)
        new Thread(() -> {
            phone1.sendEmail();
        },"a").start();
        new Thread(() -> {
            phone1.sendSms();
//            phone1.noLock();
//            phone2.sendSms();
        },"b").start();
    }
}
