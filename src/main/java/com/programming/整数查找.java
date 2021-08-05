package com.programming;

public class 整数查找 {

    //整数查找
//输入：一个有序数组array，一个整数n输出：如果n在array里，输出n的位置；
//如果n不在array中输出n可以插入的位置，插入后的数组仍然有序，例如：
//
//* [1,3,5,6], 5 → 2
//* [1,3,5,6], 2 → 1
//* [1,3,5,6], 7 → 4
//* [1,3,5,6], 0 → 0
//* [1,3,5,6], 4 → 2
    public  int getSequenceLength(int[] array ,int  n) {

        for (int i=0;i<array.length-1;i++){
            if (array[i]==n){
                return i;
            }
            if (array[i]>n){
                return i;
            }
            if (array[i]<n && array[i+1]>=n){
                return i+1;
            }
        }
        return array.length;
    }
}
