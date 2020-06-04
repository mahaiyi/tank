package com.tank.dp.strategy;

/**
 * 猫
 */
public class Cat implements  Comparable<Cat>{
     int width;
     int hight;
    public Cat(int width,int hight){
        this.hight=hight;
        this.width=width;
    }

    //猫比较大小的方法
    /*public  int CompareTo(Cat cat){
        if(this.width > cat.width){
            return 1;
        }else if(this.width < cat.width){
            return -1;
        }else{
            return 0;
        }
    }*/

    public  int compareTo(Cat cat){
        if(this.width > cat.width){
            return 1;
        }else if(this.width < cat.width){
            return -1;
        }else{
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Cat{wigth:"+this.width+",hieght:"+this.hight+"}";
    }

}
