package com.tank.dp.strategy;

public class CatHightCompare implements Comparator<Cat> {

    @Override
    public int compare(Cat o1, Cat o2) {
        if(o1.hight > o2.hight){
            return 1;
        }else if(o1.hight < o2.hight){
            return -1;
        }else{
            return 0;
        }
    }
}
