package com.example.demo.zltest.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ShareData {

		private int number = 1;
		private Lock lock = new ReentrantLock();
		private Condition c1 = lock.newCondition();
		private Condition c2 = lock.newCondition();
		private Condition c3 = lock.newCondition();


		public void print5 (){
			lock.lock();
			try {
				while (number !=1){
					c1.await();
				}
				for (int i = 0; i <5 ; i++) {
					System.out.println(Thread.currentThread().getName()+i);
				}
				number=2;
				c2.signal();
			}catch (Exception e ){

			}finally {
				lock.unlock();
			}
		}
		public void print10 (){
			lock.lock();
			try {
				while (number !=2){
					c2.await();
				}
				for (int i = 0; i <10 ; i++) {
					System.out.println(Thread.currentThread().getName()+i);
				}
				number=3;
				c3.signal();
			}catch (Exception e ){

			}finally {
				lock.unlock();
			}
		}
		public void print15 (){
			lock.lock();
			try {
				while (number !=3){
					c3.await();
				}
				for (int i = 0; i <15 ; i++) {
					System.out.println(Thread.currentThread().getName()+i);
				}
				number=1;
				c1.signal();
			}catch (Exception e ){

			}finally {
				lock.unlock();
			}
		}



	}

