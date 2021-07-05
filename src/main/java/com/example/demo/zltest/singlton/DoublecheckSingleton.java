package com.example.demo.zltest.singlton;

public class DoublecheckSingleton {


	private static volatile DoublecheckSingleton singlten = null;
	private DoublecheckSingleton(){

	}
	public static DoublecheckSingleton newSinlenVol(){
		if(singlten==null){
			synchronized(DoublecheckSingleton.class){
				if(singlten==null){
					singlten =new DoublecheckSingleton();
					//分配内存
					//初始化对象
					//设置singlten指向刚分配的内存地址
					//指令重排序不会改变单线程内的执行结果
					//如果13行指令重拍  会造成10行不为空，但是还没有初始化对象
				}
			}
		}
		return singlten;
	}
}
