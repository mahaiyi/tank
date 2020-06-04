package com.tank.dp.factory.simplefactory;

/**
 * 生产车的工厂
 */
public class CarFactory {
    public Car creat(){
        //可以做其他操作
        return new Car();
    }
}
