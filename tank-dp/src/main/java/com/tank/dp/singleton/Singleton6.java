package com.tank.dp.singleton;

import java.util.Date;

/**
 * **
 *  * 饿汉shi  懒加载  线程安全的
 *  效率高 因为在代码块上加上了锁
 *
 *  *
 *
 **/
public class Singleton6 {
    private static volatile Singleton6 INSTANCE;
    private Singleton6(){}
    public static  Singleton6 getInstance(){
        //step 1
        if(null == INSTANCE){
            //试图通过减少同步代码块的方式提高效率  不可行
            //比如线程1执行到第一步时停止执行了 这时线程2获得锁执行第一步和
            //第二步实例化完成 线程一恢复 继续执行第二步 然后执行到第三步时
            //发现已经有这个类的实例了 就直接返回了
            //step 2
            synchronized(Singleton5.class) {
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //step 3
                if(null == INSTANCE){
                    INSTANCE = new Singleton6();
                }

            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
       // System.out.println(new SimpleDateFormat(new Date(),"yyyyMMdd"));
        for (int i = 0; i <100 ; i++) {
            new Thread(()->{
                System.out.println(Singleton6.getInstance());
            }).start();
        }
        System.out.println(new Date());
    }
}
