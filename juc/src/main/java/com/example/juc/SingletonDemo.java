package com.example.juc;

import java.util.concurrent.TimeUnit;

/**
 * @author yeric
 * @description:
 * @date 2021/9/27 21:50
 */
public class SingletonDemo {
    // volatile防止指令重排序，内存可见(缓存中的变化及时刷到主存，并且其他的内存失效，必须从主存获取)
    private volatile SingletonDemo instance = null;

    private SingletonDemo() {
        //构造器必须私有  不然直接new就可以创建
    }

    public SingletonDemo getInstance() {
        //第一次判断，假设会有好多线程，如果 SingletonDemo 没有被实例化，那么就会到下一步获取锁，只有一个能获取到，
        //如果已经实例化，那么直接返回了，减少除了初始化时之外的所有锁获取等待过程
        if (instance == null) {
            synchronized (SingletonDemo.class) {
                //第二次判断是因为假设有两个线程A、B,两个同时通过了第一个if，然后A获取了锁，进入然后判断 instance 是null，他就实例化了instance，然后他出了锁，
                //这时候线程B经过等待A释放的锁，B获取锁了，如果没有第二个判断，那么他还是会去new SingletonDemo()，再创建一个实例，所以为了防止这种情况，需要第二次判断
                if (instance == null) {
                    instance = new SingletonDemo();
                }
            }
        }
        return instance;
    }
}

//现在比较好的做法就是采用静态内部内的方式实现
class SingletonDemo2 {
    private SingletonDemo2() {
    }

    private static class SingletonDemoHandler {
        private static SingletonDemo2 instance = new SingletonDemo2();
    }

    public static SingletonDemo2 getInstance() {
        return SingletonDemoHandler.instance;
    }
}

