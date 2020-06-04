package com.tank.dp.singleton;

/**
 * 饿汉式   jvm保证线程安全的
 * 因为static 修饰的类在jvm加载后就会立即初始化且
 * 只初始化一次
 * 缺点：不管用于否都会在类装载时完成初始化
 */
public class Singleton1 {
    //方案一  在类加载的时候进行实例化-------
    //定义static final 类型的类 在类加载的时候实例化
    private static final Singleton1 INSTANCE=new Singleton1();
    //提供私有的构造方法、
    private Singleton1(){}
    public static Singleton1 getInstatnce(){
        return INSTANCE;
    }
    //end  -------------------------------------


    public static void main(String[] args) {
        Singleton1 singleton1=Singleton1.getInstatnce();
        Singleton1 singleton11=Singleton1.getInstatnce();
        System.out.println(singleton1==singleton11);
    }
}
