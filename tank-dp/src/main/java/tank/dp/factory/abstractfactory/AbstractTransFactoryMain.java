package tank.dp.factory.abstractfactory;

import tank.dp.factory.simplefactory.Car;
import tank.dp.factory.simplefactory.Plane;

/**
 * 抽象工厂   main
 */
public class AbstractTransFactoryMain {

    public static void main(String[] args) {
        Car car=new Car();
        car.go();
        AK47 w=new AK47();
        w.soot();
        Bread b=new Bread();
        b.printName();

    }
}
