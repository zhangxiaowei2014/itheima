package com.zxw.itheima.async;

import java.util.concurrent.*;

public class RunAsyncDemo {

    public static void main(String[] args) {
        System.out.println();
        System.out.println("RunAsyncDemo.main");
        System.out.println("args = [" + args + "]");
        System.out.println("args = " + args);

        ExecutorService executorService = Executors.newFixedThreadPool(100);

        CompletableFuture.runAsync(()->{

            try{
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName());
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        },executorService);
        System.out.println("main end");
        executorService.shutdown();
    }
}
