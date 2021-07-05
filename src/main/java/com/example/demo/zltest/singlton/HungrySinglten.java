package com.example.demo.zltest.singlton;

import java.io.Serializable;

public class HungrySinglten implements Serializable {

	//final字段必须在类加载时完成初始化   所以在懒加载时不能用
	private final  static HungrySinglten hung = new HungrySinglten();

	private  HungrySinglten(){

	}
	public static HungrySinglten getsinglten(){
		return hung;
	}

	//序列化会破坏单例
	private Object readResolve(){
		return hung;
	}
}
