package com.example.demo.haha;

public class TTT11 {

	public static void main(String[] args) {
//		System.out.format("%4d",1);

//		System.out.format("%"+(10)*2+"s","2");
//		System.out.format("%20s","2");
//		getTriangle(9);
		System.out.println(6 & 1);
	}

	private static int[][] getTriangle(int num)
	{
		int[][] ary = new int[num][num]; //用二维数组存储
		for(int i = 0; i < ary.length; i++) //竖边、斜边置1
		{
			ary[i][0] = 1;
			ary[i][i] = 1;
		}
		for(int i = 1; i < ary.length; i++) //外循环控制行数
		{
			for(int j = 1; j <= i; j++) //内循环控制列
			{
//里面部分，等于当前位置的上方和左上角之和
				ary[i][j] = ary[i-1][j-1] + ary[i-1][j];
			}
		}
		return ary;
	}
}
