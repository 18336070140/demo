package com.example.demo.atguigu;

import java.util.concurrent.TimeUnit;

public class DeadLockDemo implements Runnable {
 public DeadLockDemo(String lockA,String lockB){
 	this.lockA=lockA;
 	this.lockB = lockB;
 }

	String lockA = "a";
	String lockB = "b";
	@Override
	public void run() {
		synchronized (lockA){
			System.out.println("锁住"+lockA);
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (lockB){
				System.out.println("锁住"+lockB);
			}
		}
	}

	public static void main(String[] args) {
		String a= "a";
		String b = "b";
		new Thread(new DeadLockDemo(a,b),"aa").start();
		new Thread(new DeadLockDemo(b,a),"bb").start();
	}
}
