package com.programming;

public class 乘积小于K的子数组 {

    class Solution {
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            int sum =0;
            int mul = 1;
            int right =0;
            int left = 0;
            for (; right < nums.length; right++) {
                mul *= nums[right];
                while(mul>=k && left <= right){
                    mul /= nums[left];
                    left ++;
                }
                sum += right - left +1;
            }
            return sum;
        }
    }
}
