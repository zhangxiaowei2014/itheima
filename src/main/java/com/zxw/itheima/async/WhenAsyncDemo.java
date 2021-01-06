package com.zxw.itheima.async;

import java.util.concurrent.*;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class WhenAsyncDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(100);

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(()->{
            try {
                int i = 1/0;
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName());
                System.out.println("supplyAsync");

            }catch (InterruptedException e){
                e.printStackTrace();
            }
            return 123;
        },executorService);

        System.out.println("main end");

        /*future.whenCompleteAsync(new BiConsumer<Integer, Throwable>() {
            @Override
            public void accept(Integer integer, Throwable throwable) {
                System.out.println(Thread.currentThread().getName());
                System.out.println(integer+222);
                executorService.shutdown();
            }
        },executorService);*/

        future.exceptionally(new Function<Throwable, Integer>() {
            @Override
            public Integer apply(Throwable throwable) {
                System.out.println("异常结果的处理线程"+Thread.currentThread().getName());
                System.out.println(throwable.getMessage());
                return null;
            }
        });
    }
}
