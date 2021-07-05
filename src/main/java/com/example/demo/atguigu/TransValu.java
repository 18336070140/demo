package com.example.demo.atguigu;

public class TransValu {

	int i = 1;

	public void chang1(Integer t){
		i=30;
		System.out.println("chang1    "+i);
	}
	public void chang2(String b){
		b=new String("xxx");
	}
	public void chang3(String b){
		b="xxx";
	}

	public static void main(String[] args) {
		TransValu tt= new TransValu();
		Integer a= new Integer(1);
		tt.chang1(a);
		System.out.println(a);

		String b = new String ("bbb");
		tt.chang2(b);
		System.out.println(b);

		String c ="ccc";
		tt.chang2(c);
		System.out.println(c);
		tt.chang3(c);
		System.out.println(c);
	}
}
