package tank.dp.strategy;

/**
 *  策略模式
 */
public class StrategyMain {
    public static void main(String[] args) {
       // int[] a = {9, 2, 5, 7, 1, 4};
        Cat [] a = {new Cat(3,5), new Cat(7,1), new Cat(9,19),new Cat(4,2)};
       // Sorter sorter=new Sorter();
       // Sorter.sort(a);
        Sorter.sort(a);

        //使用策略模式排序--多态 不同的类去实现接口做不同的事
        Sorters sorters=new Sorters();
        sorters.sort(a,new CatHightCompare());
        for (int i = 0; i <a.length ; i++) {
            System.out.println(a[i]);

        }
        sorters.sort(a,new CatWightCompare());
        for (int i = 0; i <a.length ; i++) {
            System.out.println(a[i]);

        }
    }



}