package com.example.demo.zltest.singlton;

public class Innersinglten {

	/**
	 * 初始化静态内部类是会加锁
	 */
//	private static class InnerClass{
//		private static Innersinglten innersinglent = new Innersinglten();
//	}
//
//	public static Innersinglten newInnersingle(){
//		return InnerClass.innersinglent;
//	}


	private static class InnerClassSing{
		private static Innersinglten inner = new Innersinglten();
	}
	public static Innersinglten getsingle(){
		return InnerClassSing.inner;
	}
}
