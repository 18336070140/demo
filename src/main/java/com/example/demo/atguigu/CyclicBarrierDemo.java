package com.example.demo.atguigu;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

	public static void main(String[] args) {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(5,new Thread(()->{
			System.out.println("hhhh");
		}));

		for (int i = 0; i < 5; i++) {
			int finalI = i;
			new Thread(()->{
				System.out.println(finalI);
				try {
					Thread.sleep(1000);
					cyclicBarrier.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					e.printStackTrace();
				}
			}).start();
		}
		System.out.println("main");
	}
}
