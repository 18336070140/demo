package com.programming;

public class 回文数 {
    public static boolean isPalindrome(int x) {
        if(x==0){
            return true;
        }
        if(x<0 || x%10==0){
            return false;
        }
        int rem=0,y=0;
        //x每次一位 建立y，若用想！=0判断，需要将整X遍历一遍，用X<Y时已经搬运了一半+1个
        while(x>y){
            rem = x%10;
            y = y*10+rem;
            x= x/10;
        }
        return y==x || x==y/10;

    }

    public static void main(String[] args) {
        isPalindrome(12321);
    }
}
