package com.example.demo.leecod;

public class VersionCompire {

	public int compareVersion(String version1,String version2){
		        String[] arr1=version1.split("[.]");
		        String[] arr2=version2.split("[.]");
		         int length=Math.max(arr1.length,arr2.length);
		        for(int i=0;i<length;i++){
		            Integer a1=i<arr1.length?Integer.parseInt(arr1[i]):0;
		            Integer a2=i<arr2.length?Integer.parseInt(arr2[i]):0;
		            int compare=a1.compareTo(a2);
		            if(compare!=0)
				         return compare;
		        }
		         return 0;
		     }

	public int compareVersion2(String version1, String version2) {
		String v1[]=version1.split("\\.");
		String v2[]=version2.split("\\.");
		int len1=v1.length;//v1字符串数组长度
		int len2=v2.length;//v2字符串数组长度
		int min=Math.min(len1,len2);//最短长度
		int i;
		for( i=0;i<min;i++){
			int a=Integer.parseInt(v1[i]);
			int b=Integer.parseInt(v2[i]);
			if(a>b){
				return 1;
			}else if(a<b){
				return -1;
			}
		}
		if(len1>len2){
			for(int j=i;j<len1;j++){
				int tmp=Integer.parseInt(v1[j]);
				if(tmp!=0){
					return 1;
				}
			}
			return 0;
		}else if(len1<len2){
			for(int j=i;j<len2;j++){
				int tmp=Integer.parseInt(v2[j]);
				if(tmp!=0){
					return -1;
				}
			}
			return 0;
		}
		return 0;
	}


	public static void main(String[] args) {
		System.out.println(new VersionCompire().compareVersion("1.2","1.2.1"));
	}
}
