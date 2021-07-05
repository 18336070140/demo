package com.example.demo.zltest.productCustom;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProCusmodelDemo {

	public static void main(String[] args) {

		ShareData shareData = new ShareData();
		new Thread(()->{
			for (int i = 0; i <5 ; i++) {
				shareData.inr();
			}
		}).start();
		new Thread(()->{
			for (int i = 0; i <5 ; i++) {
				shareData.dern();
			}
		}).start();
	}
}
 class ShareData{
	int number = 0;
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();

	public void inr (){
//		lock.lock();
		try{
			while (number != 0){
				condition.await();
			}
			number++;
			condition.signalAll();
		}catch (Exception e ){
			System.out.println(e);
		}finally {
//			lock.unlock();
		}
	}
	public void dern(){
//		lock.lock();
		try {
			while (number==0){
				condition.await();
			}
			number--;
			condition.signalAll();
		}catch (Exception e ){
			System.out.println(e);
		}finally {
//			lock.unlock();
		}
	}
 }