package com.tank.dp.factory.simplefactory;

/**
 * 工厂方法
 */
public class FactoryMethod {
    public static void main(String[] args) {
        Transportation car=new Car();
        car.go();

        //简单工厂  1
        Transportation simpleCar=new SimpleTransFactory().creatCar();
        simpleCar.go();
        Transportation simplePlane=new SimpleTransFactory().creatPlane();
        simpleCar.go();
        //简单工厂2 各个交通工具有自己的工厂方法
        Transportation simple2Car=new CarFactory().creat();
        simple2Car.go();
        Transportation simple2Plane=new PlaneFactory().creat();
        simple2Plane.go();
    }
}
