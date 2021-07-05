package com.example.demo.atguigu;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class SpinLockDemo {

	AtomicReference<Thread> atomicReference = new AtomicReference<>();

	public void lock(){
		Thread thread = Thread.currentThread();
		while (!atomicReference.compareAndSet(null,thread)){
		}
		System.out.println(thread.getName()+"取得锁");
	}

	public void unLock(){
		Thread thread = Thread.currentThread();
		atomicReference.compareAndSet(thread,null);
		System.out.println(thread.getName()+"释放锁");
	}


	public static void main(String[] args) {
		SpinLockDemo s = new SpinLockDemo();
        new Thread(()->{
        	s.lock();
			try {
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			s.unLock();
		},"aa").start();
		new Thread(()->{
			s.lock();
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			s.unLock();
		},"bb").start();
	}
}
