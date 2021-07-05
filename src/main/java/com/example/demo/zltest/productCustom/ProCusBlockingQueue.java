package com.example.demo.zltest.productCustom;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReadWriteLock;

public class ProCusBlockingQueue {

	public static void main(String[] args) {
		ResData re = new ResData(new ArrayBlockingQueue<>(5));
		new Thread(()->{
			try {
				System.out.println("pro start");
				re.pro();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		},"pro").start();
		new Thread(()->{
			try {
				System.out.println("cus start");
				re.consumer();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		},"cus").start();

		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		re.stop();
	}
}
class ResData{
	private volatile boolean FLAG = true;

	private AtomicInteger atomicInteger = new AtomicInteger(5);
	private BlockingQueue<String > blockingQueue = null;
	public ResData(BlockingQueue<String > blockingQueue){
		this.blockingQueue =  blockingQueue;
	}

	public void pro() throws InterruptedException {
		String data = null;
		boolean retValue;
		while (FLAG){
			System.out.println("pro"+FLAG);
			data = atomicInteger.incrementAndGet()+"";
			retValue = blockingQueue.offer(data,2l, TimeUnit.SECONDS);
			if(retValue){
				System.out.println(Thread.currentThread().getName()+"入队成功");
			}else {
				System.out.println(Thread.currentThread().getName()+"入队失败");
			}
			TimeUnit.SECONDS.sleep(1);
		}
		System.out.println("叫停");
	}

	public void consumer() throws InterruptedException {
		String retValue = null;
		while (FLAG){
			System.out.println("cus"+FLAG);
			retValue = blockingQueue.poll(2l,TimeUnit.SECONDS);
			if(retValue == null || "".equalsIgnoreCase(retValue)){
//				FLAG=false;
				System.out.println("超过时间没取到");
				return;
			}
			System.out.println(Thread.currentThread().getName()+"取到");
		}
	}

	public void stop (){
		FLAG = false;
	}
}