package com.tank.dp.singleton;

import java.util.Date;

/**
 * **
 *  * 饿汉shi  懒加载  线程安全的
 *  效率的 因为在类上加上了锁
 *  每个线程必须获得锁才能访问
 *  *
 *
 **/
public class Singleton4 {
    private static Singleton4 INSTANCE;
    private Singleton4(){}
    public static synchronized Singleton4 getInstance(){
        if(null == INSTANCE){
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE=new Singleton4();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
       // System.out.println(new SimpleDateFormat(new Date(),"yyyyMMdd"));
        for (int i = 0; i <100 ; i++) {
            new Thread(()->{
                System.out.println(Singleton4.getInstance());
            }).start();
        }
        System.out.println(new Date());
    }
}
