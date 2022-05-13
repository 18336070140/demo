package com.programming;

import java.util.Arrays;

public class 只出现一次的数字 {

    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     *
     * 说明：
     * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     * ************************************************************************************
     * 交换律：a ^ b ^ c <=> a ^ c ^ b
     *
     * 任何数于0异或为任何数 0 ^ n => n
     *
     * 相同的数异或为0: n ^ n => 0
     *
     * var a = [2,3,2,4,4]
     *
     * 2 ^ 3 ^ 2 ^ 4 ^ 4等价于 2 ^ 2 ^ 4 ^ 4 ^ 3 => 0 ^ 0 ^3 => 3
     */

    static  class Solution {
        public static int singleNumber(int[] nums) {
            return Arrays.stream(nums).reduce((a, b)->a^b).getAsInt();
        }

        public static void main(String[] args) {
            int a= 1;
            int b= 2;
            a = a^0;

            System.out.println(22^2  );
            System.out.println(52222233333L^52222233333L);
        }
    }
}
