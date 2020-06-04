package com.tank.dp.singleton;

/**
 * 饿汉shi  懒加载  线程不安全的
 *
 */
public class Singleton3 {
    //方案三 在第一次调用的时候初始化 多线程访问时会带来线程不安全的
    //线程拿到的可能不是相同的实例
    private  static Singleton3 INSTANCE;
    private Singleton3(){

    }


    //两个线程同时访问时会new出不同的方法
    public  static Singleton3 getInstance() {
        if(null ==INSTANCE){
            //模拟多线程访问  该线程让出cup 让其他线程执行
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE=new Singleton3();
        }
        return INSTANCE;
    }
    //end ------------------------------------------
    public static void main(String[] args) {
        for (int i = 0; i <100 ; i++) {
            /*new Thread(new Runnable() {
                public void run() {
                        System.out.println(Singleton3.getInstance());

                }
            }).start();*/

            new Thread(() ->{
                System.out.println(Singleton3.getInstance().hashCode());
            }).start();
        }
    }

}
