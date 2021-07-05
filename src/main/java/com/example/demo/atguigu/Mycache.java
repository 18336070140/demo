package com.example.demo.atguigu;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Mycache {

	private volatile Map<String ,Object> map = new HashMap<>();
	private ReadWriteLock lock = new ReentrantReadWriteLock();

 	public void put(String key,Object value){
		lock.writeLock().lock();
		try{
			System.out.println(Thread.currentThread().getId()+"正在写");
			map.put(key,value);
			TimeUnit.MILLISECONDS.sleep(100);
			System.out.println(Thread.currentThread().getId()+"写完成");
		}catch (Exception e){

		}finally {
			lock.writeLock().unlock();
		}
	}

	public Object get(String key){
 		lock.readLock().lock();
 		try{
			System.out.println(Thread.currentThread().getId()+"正在读");
 			Object o =map.get(key);
			TimeUnit.MILLISECONDS.sleep(100);
			System.out.println(Thread.currentThread().getId()+" 读完成"+o.toString());
 			return o;
		}catch (Exception e){

		}finally {
 			lock.readLock().unlock();
		}
      return null;
	}

	public static void main(String[] args) {
 		Mycache cache = new Mycache();

		for (int i = 0; i <5 ; i++) {
			int finalI = i;
			new Thread(()->{
				 cache.put(finalI +"", finalI +"" );
			 },String.valueOf(i)).start();
		}
		for (int i = 0; i <5 ; i++) {
			int finalI = i;
			new Thread(()->{
				cache.get (finalI +"");
			},String.valueOf(i)).start();
		}
	}
 }
