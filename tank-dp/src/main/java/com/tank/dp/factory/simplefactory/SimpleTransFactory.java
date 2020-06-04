package com.tank.dp.factory.simplefactory;

/**
 * 简单工厂   可扩展性不好 交通工具
 */
public class SimpleTransFactory {
    public Car creatCar(){
        //可以做其他操作
        return new Car();
    }

    public Plane creatPlane(){
        return new Plane();
    }
}
