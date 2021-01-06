package com.zxw.itheima.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PoolTest {

    public static void main(String[] args) {

        ExecutorService poolExecutor = Executors.newFixedThreadPool(5);
        poolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(1000);
                    System.out.println("finish task 1");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } });
        poolExecutor.shutdownNow();
        poolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } });
        System.out.println("ok");
    }
}
