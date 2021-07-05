package com.example.demo;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class AppleNum{

	public static void main(String[] args) {

		//先分奇偶两组，确保了不重复
		//偶数
		List list1 = new CopyOnWriteArrayList();
		//奇数
		List list2 = new CopyOnWriteArrayList();
		for (int j = 0; j <100 ; j++) {
			if(j % 2 == 0){
				list1.add(j);
			}else {
				list2.add(j);
			}
		}
		//放21个
		List list3 = new CopyOnWriteArrayList();
		for (int k = 0; k < 21 ; k++) {
			list3.add(list1.get(k));
			list1.remove(k);//list1剩余29个
		}
		//list1从奇数组加一个，此时完成两组
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