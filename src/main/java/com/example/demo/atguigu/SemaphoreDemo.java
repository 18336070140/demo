package com.example.demo.atguigu;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {



	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore(3);

		for (int i = 0; i <6 ; i++) {
			new Thread(()->{
				try {
					semaphore.acquire();
					System.out.println(Thread.currentThread().getId()+"qingdao");

					TimeUnit.MILLISECONDS.sleep(3000);
					System.out.println(Thread.currentThread().getId()+"离开");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}finally {
					semaphore.release();
				}
			}).start();
		}
	}
}
