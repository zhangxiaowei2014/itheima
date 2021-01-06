package com.zxw.itheima.async;

import java.sql.SQLOutput;
import java.util.concurrent.*;

public class SupplyAsyncDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(100);

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(()->{
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName());
                System.out.println("supplyAsync");

            }catch (InterruptedException e){
                e.printStackTrace();
            }
            return 123;
        },executorService);

        System.out.println("main end");

        Integer value = future.get();

        System.out.println(value);
    }
}
