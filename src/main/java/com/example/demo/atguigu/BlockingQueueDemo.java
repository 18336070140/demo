package com.example.demo.atguigu;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueDemo {

	public static void main(String[] args) throws InterruptedException {
		BlockingQueue blockingQueue = new ArrayBlockingQueue(3);


		new Thread(()->{
			try {
				blockingQueue.put("a");
				blockingQueue.put("1");
				blockingQueue.put("2");
				System.out.println(";;;;;;;;;;;;;;;;;;;;;;;");
				blockingQueue.put("3");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
		new Thread(()->{
			try {
				TimeUnit.MILLISECONDS.sleep(3000);
				Object a = blockingQueue.take();
				System.out.println(a.toString());
				System.out.println(blockingQueue.element());
//				blockingQueue.put("1");
//				blockingQueue.put("2");
//				blockingQueue.put("3");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
	}
}
