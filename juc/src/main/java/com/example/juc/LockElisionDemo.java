package com.example.juc;

/**
 * 锁消除 * 从JIT角度看相当于无视它，synchronized (o)不存在了,这个锁对象并没有被共用扩散到其它线程使用，
 * 极端的说就是根本没有加这个锁对象的底层机器码，消除了锁的使用
 * @author yeric
 */
public class LockElisionDemo {

    static Object objectLock = new Object();//正常的

    public void m1() {
        //锁消除,JIT会无视它，synchronized(对象锁)不存在了。不正常的
        Object o = new Object();
        synchronized (o) {
            // 业务代码
        }
    }
}