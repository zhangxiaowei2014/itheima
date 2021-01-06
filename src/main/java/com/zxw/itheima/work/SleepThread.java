package com.zxw.itheima.work;

import static sun.jvm.hotspot.runtime.PerfMemory.start;

public class SleepThread{
    public static void main(String[] args) {
        final byte[] lock = new byte[0];
        new Thread(()->{
            synchronized (lock){
                System.out.println("start");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("end");
            }
        }).start();
        new Thread(()->{
            synchronized (lock){
                System.out.println("need lock");
            }
        }).start();

        new Thread(()->{

                System.out.println("no lock");

        }).start();
    }
}

