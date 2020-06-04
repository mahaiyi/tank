package com.tank.dp.factory.abstractfactory;

import com.tank.dp.factory.simplefactory.Car;

/**
 * 抽象工厂   main
 */
public class AbstractTransFactoryMain {

    public static void main(String[] args) {
        com.tank.dp.factory.simplefactory.Car car=new Car();
        car.go();
        AK47 w=new AK47();
        w.soot();
        Bread b=new Bread();
        b.printName();

    }
}
