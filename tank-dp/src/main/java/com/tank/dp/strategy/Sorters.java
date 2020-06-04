package com.tank.dp.strategy;

/**
 * 排序方法 策略模式
 */
public class Sorters<T> {
    public  void sort(T[] a,Comparator<T> comparator){
        ///采用冒泡排序 从小到大
        for(int i=0;i<a.length-1;i++){
            for(int j=i+1;j<a.length;j++){
                if(comparator.compare(a[i],a[j])==1){
                   /* T temp=a[j];
                    a[j]=a[i];
                    a[i]=temp;*/
                    swap(i,j,a);
                }
            }
        }
    }


    //两个值进行交换
    public  void  swap(int i,int j,T[] o){
        T tmp=o[i];
        o[i]=o[j];
        o[j]=tmp;

    }
}
