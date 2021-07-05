package com.example.demo.leecod;

public class Botto {
	private static int getNumDrink(int i) {
		if (i == 0) {
			return 0;
		}
		int tmp = 0;
		while (i > 1) {
			if (i == 2) {
				tmp++;
				i = 0;
			}
			tmp += i / 3;
			i = i / 3 + i % 3;
		}
		return tmp;
	}
	public static int Water_max(int n){
 //先把手上的空瓶子3个为一组分好
 int k =0;
 while(n>=3){

 if(n %3==0){
 k =k+ n/3;
 n=n/3;
 }
 if(n % 3!=0){
 k=k+n/3;
 int t =n%3;
 n= n/3 +t;
 }
 }
 if(n==2){
  k=k+1;
 }
 return k;

 }

// public int botto(int n){
//
//		int k = 0;
//		while (n>=3) {
//			if (n % 3 == 0) {
//				k = n / 3 + k;
//				n = n / 3;
//			}
//			if (n % 3 != 0) {
//				k = n / 3 + k;
//				n = n / 3 + n % 3;
//			}
//		}
//
//		return k;
// }

	public static void main(String[] args) {
		System.out.println(getNumDrink(10));
	}
}
