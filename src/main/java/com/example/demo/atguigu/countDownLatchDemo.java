package com.example.demo.atguigu;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class countDownLatchDemo {

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch countDownLatch = new CountDownLatch(5);

		for (int i = 0; i < 5; i++) {
			new Thread(()->{

				try {
					Thread.sleep(3000);
					System.out.println(Thread.currentThread().getId());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				countDownLatch.countDown();
			}).start();
		}
//		System.out.println(Thread.activeCount());

		countDownLatch.await(1, TimeUnit.SECONDS)	;
		System.out.println("main");
	}
}
