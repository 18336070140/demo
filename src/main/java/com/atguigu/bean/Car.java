package com.atguigu.bean;

import org.springframework.stereotype.Component;

@Component
public class Car {
	
	public Car(){
		System.out.println("################car constructor...");
	}
	
	public void init(){
		System.out.println("################3car ... init...");
	}
	
	public void detory(){
		System.out.println("##############car ... detory...");
	}

}
