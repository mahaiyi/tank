package com.tank.dp.singleton;

/**
 * 饿汉式 懒加载  jvm保证线程安全的
 * 因为static 修饰的类在jvm加载后就会立即初始化且
 * 只初始化一次
 * 缺点：不管用于否都会在类装载时完成初始化
 */
public class Singleton2 {
    //方案二 在静态代码块中实例化------------------
    private  static final Singleton2 INSTANCE;
    private Singleton2(){

    }
    static {
        INSTANCE=new Singleton2();
    }

    public  static Singleton2 getInstance(){
        return INSTANCE;
    }
    //end ------------------------------------------
    public static void main(String[] args) {
        Singleton2 singleton2=Singleton2.getInstance();
        Singleton2 singleton22=Singleton2.getInstance();
        System.out.println(singleton2==singleton22);
    }

}
