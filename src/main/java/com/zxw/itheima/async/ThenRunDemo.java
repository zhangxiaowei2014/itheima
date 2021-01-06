package com.zxw.itheima.async;

import java.util.concurrent.*;
import java.util.function.Consumer;

public class ThenRunDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(100);

         CompletableFuture.supplyAsync(()->{
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName());
                System.out.println("supplyAsync");

            }catch (InterruptedException e){
                e.printStackTrace();
            }
            return 123;
        },executorService).thenRunAsync(new Runnable() {
             @Override
             public void run() {
                 System.out.println("Then Run Async");
             }
         });

        System.out.println("main end");

    }
}
