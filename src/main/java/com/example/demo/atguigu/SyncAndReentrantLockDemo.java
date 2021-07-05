package com.example.demo.atguigu;

import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SyncAndReentrantLockDemo {
	public static void main(String[] args) {
		ShareResource sr = new ShareResource();
		ExecutorService es = new ThreadPoolExecutor(3,3,0, TimeUnit.SECONDS,
				new LinkedBlockingQueue<>(5),
				Executors.defaultThreadFactory(),
				new ThreadPoolExecutor.AbortPolicy());
		es.submit(()->{
			for (int i = 0; i < 10; i++) {
				sr.print5();
			}
		});
		es.submit(()->{
			for (int i = 0; i < 10; i++) {
				sr.print10();
			}
		});
		es.submit(()->{
			for (int i = 0; i < 10; i++) {
				sr.print15();
			}
		});

		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			es.shutdown();
		}
	}
}

class ShareResource{

	private int number = 1;
	private Lock lock = new ReentrantLock();
	private Condition c1 = lock.newCondition();
	private Condition c2 = lock.newCondition();
	private Condition c3 = lock.newCondition();

	public void print5(){
		lock.lock();
		try{
			while (number != 1){
				c1.await();
			}
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName()+i);
			}
			number = 2;
			c2.signal();
		}catch (Exception e ){
			System.out.println(e);
		}finally {
			lock.unlock();
		}
	}
	public void print10(){
		lock.lock();
		try{
			while (number != 2){
				c2.await();
			}
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName()+i);
			}
			number = 3;
			c3.signal();
		}catch (Exception e ){
			System.out.println(e);
		}finally {
			lock.unlock();
		}
	}
	public void print15(){
		lock.lock();
		try{
			while (number != 3){
				c3.await();
			}
			for (int i = 0; i < 15; i++) {
				System.out.println(Thread.currentThread().getName()+i);
			}
			number = 1;
			c1.signal();
		}catch (Exception e ){
			System.out.println(e);
		}finally {
			lock.unlock();
		}
	}
}
