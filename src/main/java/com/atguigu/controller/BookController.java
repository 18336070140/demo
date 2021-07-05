package com.atguigu.controller;

import com.atguigu.service.ColorService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class BookController {

//	@Qualifier("c1")
	@Resource
	ColorService service;

	public void print(){
		System.out.println("@@@@@@@@@@@@@@@2"+service.getClass().getName());
	}
}
