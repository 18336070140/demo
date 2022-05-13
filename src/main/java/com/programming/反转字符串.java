package com.programming;

public class 反转字符串 {

    public static void main(String[] args) {
        String w ="sdfg";
        char[] s = w.toCharArray();
        for (int i = 0; i < s.length; i++) {
            int a = s.length-1-i;
            if(i >= a){
                return;
            }
            s[i] = (char) (s[i]^s[a]);
            s[a] = (char) (s[a] ^ s[i]);
            s[i] = (char) (s[i]^s[a]);
        }

    }

    public void reverse(char[] s){
        int l = 0;
        int r = s.length - 1;
        while (l < r) {
            s[l] ^= s[r];  //构造 a ^ b 的结果，并放在 a 中
            s[r] ^= s[l];  //将 a ^ b 这一结果再 ^ b ，存入b中，此时 b = a, a = a ^ b
            s[l] ^= s[r];  //a ^ b 的结果再 ^ a ，存入 a 中，此时 b = a, a = b 完成交换
            l++;
            r--;
        }
    }
}
