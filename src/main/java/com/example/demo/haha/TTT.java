package com.example.demo.haha;

import java.util.HashMap;

public class TTT {
	public void hashT(){
		HashMap s = new HashMap();
		BeanMy b = new BeanMy();
		BeanMy b2 = new BeanMy();
		s.put(b,"a");
		s.put(b2,"y");
		System.out.println(s.get(b2));
	}
	public static void main(String[] args) {
//		new HashMap<>();
//		new TTT().hashT();
//		int [][] arr=new int [10][10];
//		for(int i=0;i<arr.length;i++) {
//			for(int j=0;j<arr[i].length;j++) {
//				System.out.print(arr[i][j]+"\t");
//			}
//			System.out.println();
//		}

		//打印行数
		int rows = 9;

		for(int i =0;i<rows;i++) {
			int number = 1;
			//打印空格字符串
			System.out.format("%"+(rows-i)*2+"s","");
			for(int j=0;j<=i;j++) {
				System.out.format("%4d",number);
				number = number * (i - j) / (j + 1);
			}
			System.out.println();
		}

	}

}
//public class Test {
//	public static void main(String[] args) {
//		int [][] arr=new int [10][10];
//		for(int i=0;i<arr.length;i++) {
//			for(int j=0;j<arr[i].length;j++) {
//				System.out.print(arr[i][j]+"\t");
//			}
//			System.out.println();
//		}
//	}
//}
//public static void main(String[] args) {
//	         int rows = 10;
//
//	         for(int i =0;i<rows;i++) {
//		int number = 1;
//		             //打印空格字符串
//		             System.out.format("%"+(rows-i)*2+"s","");
//		             for(int j=0;j<=i;j++) {
//			System.out.format("%4d",number);
//			                 number = number * (i - j) / (j + 1);
//			           }
//		            System.out.println();
//		         }
//	    }