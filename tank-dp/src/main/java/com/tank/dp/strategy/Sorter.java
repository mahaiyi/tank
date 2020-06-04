package com.tank.dp.strategy;

/**
 * 排序方法
 */
public class Sorter {
    public static void sort(int[] a){
      //  int[] a = {9, 2, 5, 7, 1, 4};
        //int[] a = {2,9, 5, 7, 1, 4};
        //int[] a = {1,9, 5, 7, 2, 4};
        //int[] a = {1,5, 9, 7, 2, 4};
        //int[] a = {1,5, 7, 9, 2, 4};
        //int[] a = {1,5, 7, 2, 9, 4};
        //int[] a = {1,5, 7, 2, 4, 9};
        ///采用冒泡排序 从小到大
        for(int i=0;i<a.length-1;i++){
            for(int j=i+1;j<a.length;j++){
                if(a[i] > a[j]){
                    int temp=a[j];
                    a[j]=a[i];
                    a[i]=temp;
                }
            }
        }
    }
   // Cat [] a = {new Cat(3,5), new Cat(1,1), new Cat(9,9)};
    /*public static void sort(Cat [] cat){
        for (int i = 0; i <cat.length -1; i++) {
            for (int j = i+1; j <cat.length ; j++) {
                if(cat[i].CompareTo(cat[j])==1){
                    swap(i,j,cat);
                   *//* Cat tmp=cat[i];
                    cat[i]=cat[j];
                    cat[j]=tmp;*//*
                }
            }
        }

    }*/
    public static void sort(Comparable[] cat){
        for (int i = 0; i <cat.length -1; i++) {
            for (int j = i+1; j <cat.length ; j++) {
                if(cat[i].compareTo(cat[j])==1){
                    swap(i,j,cat);
                }
            }
        }

    }
    //两个值进行交换
    public static void  swap(int i,int j,Comparable[] cat){
        Comparable tmp=cat[i];
        cat[i]=cat[j];
        cat[j]=tmp;

    }
}
