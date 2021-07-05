package com.example.demo.atguigu;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProdCustom_TraditionDemo {

	public static void main(String[] args) {
		ShareData sd = new ShareData();
		new Thread(()->{
			for (int i = 0; i < 5; i++) {
				sd.increment();
			}
			System.out.println("aa");
		},"aa").start();
		new Thread(()->{
			for (int i = 0; i < 5; i++) {
				sd.decrement();
			}
			System.out.println("bb");
		},"bb").start();
	}

}
class ShareData{

	private int number = 0;
	private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
	public void increment(){

		lock.lock();
		try{
			//之所以用while是因为线程被唤醒后,很可能已经不满足判断条件了,所以要再进行一次条件判断
			while(number != 0){
				condition.await();
			}
			number ++ ;
			System.out.println("iiiiii");
			condition.signalAll();
		}catch (Exception e ){
			System.out.println(e);
		}finally {
			lock.unlock();
		}
	}

	public void decrement(){

		lock.lock();
		try{
			while(number == 0){
				condition.await();
			}
			number -- ;
			System.out.println("dddddd");
			condition.signalAll();
		}catch (Exception e ){
			System.out.println(e);
		}finally {
			lock.unlock();
		}
	}
}