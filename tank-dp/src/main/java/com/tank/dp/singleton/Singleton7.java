package com.tank.dp.singleton;

import java.util.Date;

/**
 * **
 *  * 懒汉shi  懒加载  线程安全的
 *  效率高 私有的静态内部类
 *
 *  *
 *
 **/
public class Singleton7 {
    private Singleton7(){}

    //在静态内部类中实例化
    private static class SingletonHolder{
        private static final Singleton7 INSTANCE =new Singleton7();
    }
    public static Singleton7 getInstance() {
        return  SingletonHolder.INSTANCE;
    }

    public static void main(String[] args) {
       // System.out.println(new SimpleDateFormat(new Date(),"yyyyMMdd"));
        for (int i = 0; i <100 ; i++) {
            new Thread(()->{
                System.out.println(Singleton7.getInstance());
            }).start();
        }
        System.out.println(new Date());




    }
}
