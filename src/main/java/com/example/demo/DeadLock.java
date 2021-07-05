package com.example.demo;

import java.util.TreeMap;

public class DeadLock {

	static class DeadLockTh{
		String locka;
		String lockB;
		public DeadLockTh(String A,String B){
			this.locka=A;
			this.lockB=B;
		}
		public void llock(){
			synchronized(locka){
				System.out.println(Thread.currentThread().getName()+"得到A");
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (lockB){
					System.out.println(Thread.currentThread().getName()+"得到B");
				}
			}
		}
	}

	public static void main(String[] args) {
		String a = "a";
		String b = "b";
		DeadLockTh t = new DeadLockTh(a,b);
		DeadLockTh t1 = new DeadLockTh(b,a);
		new Thread(()->{t.llock();}).start();
		new Thread(()->{t1.llock();}).start();


//		TreeMap
	}
}
