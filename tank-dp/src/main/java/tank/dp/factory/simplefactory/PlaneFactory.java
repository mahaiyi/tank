package tank.dp.factory.simplefactory;

/**
 * 生产飞机的工厂
 */
public class PlaneFactory {
    public Plane creat(){
        //可以做其他操作
        return new Plane();
    }
}
