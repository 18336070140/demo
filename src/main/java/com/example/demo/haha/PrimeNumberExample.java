package com.example.demo.haha;

public class PrimeNumberExample {

	public static boolean isPrime(long n) {

		//n&1==0 等效于 n%2==0,但是效率高
		if (n > 2 && (n & 1) == 0) {
			return false;
		}

		// 1.只有奇数需要被测试 2.测试范围从2与根号n
		for (int i = 3; i * i <= n; i += 2) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int which = 0;
		for (int i = 2; i <= 10000; i++) {
			if (isPrime(i)) {
				which++;
				if (which % 10 == 0) {
					System.out.println();
				}
				System.out.print(i + ", ");
			}
		}
		System.out.println();
		System.out.print("共有" + which + "个质数.");
	}
}
