package com.zxw.itheima.Thread;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static sun.jvm.hotspot.runtime.PerfMemory.start;

public class BadConcurrent {
       public static void main(String[] args) throws InterruptedException {
           Map<String,Integer> map = new ConcurrentHashMap();
           map.put("val",0);
           for (int i = 0; i < 10; i++) {
               new Thread(()->{
                   int v = map.get("val");
                   v++;
                   try {
                       Thread.currentThread().sleep(100);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   map.put("val",v);
               }).start();
}
           Thread.sleep(3000);
           System.out.println(map);
       }
}