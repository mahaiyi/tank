package com.tank.dp.singleton;

import java.util.Date;

/**
 * **
 *  * 饿汉shi  懒加载  线程不安全的
 *  效率高 因为在代码块上加上了锁
 *
 *  *
 *
 **/
public class Singleton5 {
    private static Singleton5 INSTANCE;
    private Singleton5(){}
    public static Singleton5 getInstance(){
        //step 1
        if(null == INSTANCE){
            //试图通过减少同步代码块的方式提高效率  不可行
            //比如线程1执行到第一步时停止执行了 这时线程2获得锁执行第一步和
            //第二步实例化完成 线程一恢复 继续执行第二步 也会new对象出来
            //所以没法保证是单列的
            //step 2
            synchronized(Singleton6.class) {
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                INSTANCE = new Singleton5();
            }
        }
        return INSTANCE;
    }


    public static void main(String[] args) {
       // System.out.println(new SimpleDateFormat(new Date(),"yyyyMMdd"));
        for (int i = 0; i <100 ; i++) {
            new Thread(()->{
                System.out.println(Singleton5.getInstance());
            }).start();
        }
        System.out.println(new Date());
    }
}
