package com.example.demo.atguigu;

import com.atguigu.bean.Person;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReenTrantLockDemo {


		public synchronized void sendsms(){
			System.out.println("sms");
			sengMail();
		}
		public synchronized void sengMail(){
			System.out.println("mail");
		}
		Lock l = new ReentrantLock();
		public void get(){
			l.lock();
			l.lock();
			try {
				System.out.println("ssssssssssssssss");
			}catch (Exception e){
               e.printStackTrace();
			}finally {
				l.unlock();
			}
		}



	public static void main(String[] args) {
		ReenTrantLockDemo dd = new ReenTrantLockDemo();
//		new Thread(()->{dd.sengMail();},"ss").start();
		new Thread(()->{
			dd.get();

//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			dd.sendsms();
		}).start();
		Phone p = new Phone();
		new Thread(p,"aa").start();
		new Thread(p,"vv").start();
	}


}
class Phone implements Runnable{

	@Override
	public void run() {
		get();
	}

	Lock ll = new ReentrantLock();
	public void get(){
		ll.lock();
		ll.lock();
		try {
			System.out.println("------------");
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			ll.unlock();
		}
	}
}