package com.zxw.itheima.async;

import java.util.concurrent.*;
import java.util.function.Function;

public class ThenAsyncDemo {
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
        },executorService).thenApply(new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                System.out.println(integer * 10);
                return null;
            }
        });

        System.out.println("main end");

        Integer value = future.get();

        System.out.println(value);
    }
}
