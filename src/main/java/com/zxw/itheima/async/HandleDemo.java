package com.zxw.itheima.async;

import java.util.concurrent.*;
import java.util.function.BiFunction;
import java.util.function.Function;

public class HandleDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(100);

        /*CompletableFuture<Integer> future = CompletableFuture.supplyAsync(()->{
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName());
                System.out.println("supplyAsync");

            }catch (InterruptedException e){
                e.printStackTrace();
            }
            return 123;
        },executorService).handleAsync(new BiFunction<Integer, Throwable, Integer>() {
            @Override
            public Integer apply(Integer integer, Throwable throwable) {
                System.out.println(Thread.currentThread().getName());
                System.out.println(integer * 100);
                return null;
            }
        });*/

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(()->{
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName());
                System.out.println("supplyAsync");

            }catch (InterruptedException e){
                e.printStackTrace();
            }
            return 123;
        },executorService).handleAsync((value,throwable)->{

            int result = 1;
            if (throwable != null){
                result = value * 10;
            }else {

            }
            return result;
        });

        System.out.println("main end");

        Integer value = future.get();

        System.out.println(value);
    }
}
