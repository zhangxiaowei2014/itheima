package com.zxw.itheima.pool;

import java.util.concurrent.*;

public class ExcutorText {

    public static void main(String[] args) {
        BlockingQueue queue = new ArrayBlockingQueue(2);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                3,
                5,
                20,
                TimeUnit.SECONDS,
                queue,
                new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        System.out.println("reject");
                    }
                });
        for (; ; ) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.currentThread().sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            System.out.println("123");
        }
    }
}
