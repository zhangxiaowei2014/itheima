package com.zxw.itheima.Thread;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapDemo {


    public static void main(String[] args) throws InterruptedException { //定义ConcurrentHashMap
        Map map = new ConcurrentHashMap();
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() { //多线程下的put可以放心使用
                    map.put(UUID.randomUUID().toString(), "1");
                }
            }).start();
        }
        Thread.sleep(3000);
        System.out.println(map);
    }
}
