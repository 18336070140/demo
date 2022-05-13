package com.programming;

public class 最长公共前缀 {
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length==0)return "";
        //公共前缀比所有字符串都短，随便选一个先
        String s=strs[0];
        for (String string : strs) {
            while(!string.startsWith(s)){
                if(s.length()==0)return "";
                //公共前缀不匹配就让它变短！
                s=s.substring(0,s.length()-1);
            }
        }
        return s;
    }

    public static String fun(String[] strs){
        boolean flag = false;
        String str = strs[0];
        for (int i = 0; i <str.length() ; i++) {
            char ch = str.charAt(i);
            for (String strf : strs) {
                if(strf.length() == i){
                    return strf;
                }
                if (strf.charAt(i) != ch){
                   flag = true;
                }
            }
            if(flag){
                return str.substring(0,i);
            }
        }
        return str;
    }

    public static void main(String[] args) {
        String s = "afv";
        System.out.println(s.substring(0,s.length()));
    }
}
