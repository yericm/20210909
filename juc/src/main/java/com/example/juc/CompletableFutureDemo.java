package com.example.juc;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author yeric
 * @description:
 * @date 2021/9/16 17:16
 */
public class CompletableFutureDemo {
    public static void main(String[] args) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {

            }
            return "abc";
        }).thenApply(v->v.concat("dddd"));
        String join = future.join();
        System.out.println(join);
    }
}
