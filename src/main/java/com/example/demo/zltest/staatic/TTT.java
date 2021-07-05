package com.example.demo.zltest.staatic;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Vector;

public class TTT {

	public static void main(String[] args) {

		String a="";
//		a.wait();
//		Thread.sleep();
//		Socket f;
//		ServerSocket
//		StaticClass s= new StaticClass();
//		StaticClass s1 = new StaticClass();
//		System.out.println(s == s1);
//		System.out.println(s.i == s1.i);
//		Vector
//		ArrayList

		String[] ips = "10.255.12.9".split("\\.");
		int ipFour = 0;
		//因为每个位置最大255，刚好在2进制里表示8位
		for(String ip4: ips){
			Integer ip4a = Integer.parseInt(ip4);
			//这里应该用+也可以,但是位运算更快
			ipFour = (ipFour << 8) | ip4a;
		}
		System.out.println(ipFour);

		StringBuilder sb = new StringBuilder();
		for(int i = 3; i >= 0; i--){
			int ipa = (ipFour >> (8 * i)) & (0xff);
			sb.append(ipa + ".");
		}
		sb.delete(sb.length() - 1, sb.length());
		System.out.println(sb.toString());


//		new Thread(()->{
//			StaticClass q = new StaticClass();
//			System.out.println(q);
//
//
//		}).start();
//
//		new Thread(()->{
//			StaticClass w = new StaticClass();
//			System.out.println(w);
//
//		}).start();
	}
}
