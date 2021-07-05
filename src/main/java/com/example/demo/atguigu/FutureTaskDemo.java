package com.example.demo.atguigu;

import java.util.concurrent.*;

public class FutureTaskDemo {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(3);

		ExecutorService threadPoolExecutor = new ThreadPoolExecutor(
				2,
				3,
				1L,
				TimeUnit.SECONDS,
				new LinkedBlockingQueue<>(3),
				Executors.defaultThreadFactory(),
				new ThreadPoolExecutor.CallerRunsPolicy()
		);
//		executorService.execute()
	}
}
