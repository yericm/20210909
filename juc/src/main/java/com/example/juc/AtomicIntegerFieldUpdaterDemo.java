package com.example.juc;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @author yeric
 * @description:以一种线程安全的方式操作非线程安全对象内的某些字段
 * @date 2021/10/11 20:44
 */
public class AtomicIntegerFieldUpdaterDemo {
    public static void main(String[] args) {
        BankCard bankCard = new BankCard();
        for (int i = 0; i < 1000; i++) {
            new Thread(()->{
                bankCard.transaction(bankCard);
            }).start();
        }
        System.out.println(bankCard.balance);
    }
}

class BankCard {
    private String bankName;//银行名称
    private String userName;// 户名
    private String cardId;//银行卡号
    public volatile int balance;// 余额,更新的对象属性必须使用 public volatile 修饰符。

    AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = AtomicIntegerFieldUpdater.newUpdater(BankCard.class,"balance");
    public void transaction (BankCard bankCard) {
        atomicIntegerFieldUpdater.incrementAndGet(bankCard);
    }
}
