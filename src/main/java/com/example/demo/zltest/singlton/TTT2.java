package com.example.demo.zltest.singlton;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class TTT2 {

	public int num(int num){
		if(1==num || 2==num){

		}
		return 1;
	}

	public static void main(String[] args) {
//		System.out.println(5/3);
//		System.out.println(5%3);
//		new HashMap<>();
//		System.out.println(new ArrayList<>().DEFAULTCAPACITY_EMPTY_ELEMENTDATA == new ArrayList<>().DEFAULTCAPACITY_EMPTY_ELEMENTDATA);
		LinkedList<String >[] tables = new LinkedList[998];

		LinkedList<String > linkedList = tables[1];
		System.out.println(linkedList);
		for (String  entry : linkedList) {
			System.out.println("ss");
			}
		}


}
