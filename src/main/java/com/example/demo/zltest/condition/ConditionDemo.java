package com.example.demo.zltest.condition;



import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

 public class ConditionDemo {

	public static void main(String[] args) {
		ShareData sha = new ShareData();
		new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				sha.print5();
			}
		}, "aa").start();

		new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				sha.print10();
			}
		}, "bb").start();
		new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				sha.print15();
			}
		}, "cc").start();


//		new Thread(() -> {
//			for (int i = 0; i < 1; i++) {
//				sha.print5();
//			}
//		}, "dd").start();
//
//		new Thread(() -> {
//			for (int i = 0; i < 1; i++) {
//				sha.print10();
//			}
//		}, "ee").start();
//		new Thread(() -> {
//			for (int i = 0; i < 1; i++) {
//				sha.print15();
//			}
//		}, "ff").start();
	}
 }

