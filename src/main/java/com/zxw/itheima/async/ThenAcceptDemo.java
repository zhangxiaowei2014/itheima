package com.zxw.itheima.async;

import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.function.Function;

public class ThenAcceptDemo {
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
        },executorService).thenAcceptAsync(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });

        System.out.println("main end");

    }
}
