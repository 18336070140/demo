package com.example.demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class InnterClassDemo {

	public int i;
	private int a;


	public static void main(String[] args) {
List a = new ArrayList();
//a.r
		//偶数
		List list1 = new CopyOnWriteArrayList();
		//奇数
		List list2 = new CopyOnWriteArrayList();
		for (int j = 0; j <100 ; j++) {
			if(j%2 == 0){
				list1.add(j);
			}else {
				list2.add(j);
			}
		}
		//放21个
		List list3 = new CopyOnWriteArrayList();
		for (int k = 0; k < 21 ; k++) {
			list3.add(list1.get(k));
			list1.remove(k);//29ge
		}
		list1.add(list2.get(1));
		list2.remove(1);
		//放11个
		List list4 = new CopyOnWriteArrayList();
		for (int h = 0; h < 11 ; h++) {
			list4.add(list2.get(h));
			list2.remove(h);
		}
		System.out.println(list1);
		System.out.println(list2);
		System.out.println(list3);
		System.out.println(list4);
	}
}
